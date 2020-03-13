package com.sycode.wandroid.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import butterknife.ButterKnife
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.jess.arms.base.delegate.AppLifecycles
import com.jess.arms.integration.cache.IntelligentCache
import com.jess.arms.utils.ArmsUtils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.sycode.wandroid.BuildConfig
import com.sycode.wandroid.R
import com.sycode.wandroid.app.utils.CacheUtil
import com.sycode.wandroid.app.utils.HttpUtils
import com.sycode.wandroid.app.weight.loadCallBack.EmptyCallback
import com.sycode.wandroid.app.weight.loadCallBack.ErrorCallback
import com.sycode.wandroid.app.weight.loadCallBack.LoadingCallback
import com.sycode.wandroid.mvp.ui.activity.error.ErrorActivity
import com.sycode.wandroid.mvp.ui.activity.start.SplashActivity
import com.tencent.bugly.Bugly
import com.tencent.bugly.crashreport.CrashReport.UserStrategy
import com.tencent.mmkv.MMKV
import com.xuexiang.keeplive.KeepLive
import com.xuexiang.keeplive.config.ForegroundNotification
import com.xuexiang.keeplive.config.ForegroundNotificationClickListener
import com.xuexiang.keeplive.config.KeepLiveService
import com.xuexiang.xutil.XUtil


/**
 * ================================================
 * 展示 [AppLifecycles] 的用法
 * ================================================
 */
class AppLifecyclesImpl : AppLifecycles {
    lateinit var mContext: Context
    override fun attachBaseContext(base: Context) {
        MultiDex.install(base)  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化
        mContext = base
    }

    override fun onCreate(application: Application) {
        //初始化MMKV
        MMKV.initialize(application.filesDir.absolutePath + "/mmkv")
        if (LeakCanary.isInAnalyzerProcess(application)) {
            return
        }
        ButterKnife.setDebug(BuildConfig.LOG_DEBUG)
        ArmsUtils.obtainAppComponentFromContext(application).extras()
                .put(IntelligentCache.getKeyOfKeep(RefWatcher::class.java.name), if (BuildConfig.USE_CANARY) LeakCanary.install(application) else RefWatcher.DISABLED)
        XUtil.init(application)
        XUtil.debug(BuildConfig.DEBUG)
        //界面加载管理 初始化
        LoadSir.beginBuilder()
                .addCallback(LoadingCallback())//加载
                .addCallback(ErrorCallback())//错误
                .addCallback(EmptyCallback())//空
                .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
                .commit()
        //初始化Bugly
        val context = application.applicationContext
        // 获取当前包名
        val packageName = context.packageName
        // 获取当前进程名
        val processName = HttpUtils.getProcessName(android.os.Process.myPid())
        // 设置是否为上报进程
        val strategy = UserStrategy(context)
        strategy.isUploadProcess = processName == null || processName == packageName
        // 初始化Bugly
        Bugly.init(context, BuildConfig.BUGLY_KEY, BuildConfig.DEBUG)
        //防止项目崩溃，崩溃后打开错误界面
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
                .enabled(true)//是否启用CustomActivityOnCrash崩溃拦截机制 必须启用！不然集成这个库干啥？？？
                .showErrorDetails(false) //是否必须显示包含错误详细信息的按钮 default: true
                .showRestartButton(false) //是否必须显示“重新启动应用程序”按钮或“关闭应用程序”按钮default: true
                .logErrorOnRestart(false) //是否必须重新堆栈堆栈跟踪 default: true
                .trackActivities(true) //是否必须跟踪用户访问的活动及其生命周期调用 default: false
                .minTimeBetweenCrashesMs(2000) //应用程序崩溃之间必须经过的时间 default: 3000
                .restartActivity(SplashActivity::class.java) // 重启的activity
                .errorActivity(ErrorActivity::class.java) //发生错误跳转的activity
                .eventListener(null) //允许你指定事件侦听器，以便在库显示错误活动 default: null
                .apply()
        if (CacheUtil.isLogin()) {
            initKeepLive(application)
        }
    }

     fun initKeepLive(application: Application) {

        //定义前台服务的默认样式。即标题、描述和图标
        val notification = ForegroundNotification("WanAndroid服务", "WanAndroid服务正在运行中" +
                "...", R.mipmap.ic_launcher_round,  //定义前台服务的通知点击事件
                ForegroundNotificationClickListener { context, intent -> //可以做一些唤醒程序的操作，这里只是简单地启动了应用
                }) //要想不显示通知，可以设置为false，默认是false
                .setIsShow(false)
        //启动保活服务
        KeepLive.startWork(application, KeepLive.RunMode.ENERGY, notification,  //你需要保活的服务，如socket连接、定时任务等，建议不用匿名内部类的方式在这里写
                object : KeepLiveService {
                    /**
                     * 运行中
                     * 由于服务可能会多次自动启动，该方法可能重复调用
                     */
                    override fun onWorking() {
                        //可以做一些保活的处理，比如说恢复推送连接等

                    }

                    /**
                     * 服务终止
                     * 由于服务可能会被多次终止，该方法可能重复调用，需同onWorking配套使用，如注册和注销broadcast
                     */
                    override fun onStop() {
                        //该回调方法可能会不回调
                    }
                }
        )
    }

    override fun onTerminate(application: Application) {

    }
}
