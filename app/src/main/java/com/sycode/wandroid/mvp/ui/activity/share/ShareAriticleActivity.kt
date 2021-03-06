package com.sycode.wandroid.mvp.ui.activity.share

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import butterknife.OnClick
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.jess.arms.di.component.AppComponent
import com.sycode.wandroid.R
import com.sycode.wandroid.app.event.AddEvent
import com.sycode.wandroid.app.event.AddEvent.Companion.SHARE_CODE
import com.sycode.wandroid.app.utils.CacheUtil
import com.sycode.wandroid.app.utils.SettingUtil
import com.sycode.wandroid.di.component.share.DaggerShareAriticleComponent
import com.sycode.wandroid.di.module.share.ShareAriticleModule
import com.sycode.wandroid.mvp.contract.share.ShareAriticleContract
import com.sycode.wandroid.mvp.model.entity.UserInfoResponse
import com.sycode.wandroid.mvp.presenter.share.ShareAriticlePresenter
import com.sycode.wandroid.mvp.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_share_ariticle.*
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * 分享文章
 */
class ShareAriticleActivity : BaseActivity<ShareAriticlePresenter>(), ShareAriticleContract.View {
    lateinit var user: UserInfoResponse
    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerShareAriticleComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .shareAriticleModule(ShareAriticleModule(this))
                .build()
                .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_share_ariticle //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {
        toolbar.run {
            setSupportActionBar(this)
            title = "分享文章"
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener { finish() }
        }
        user = CacheUtil.getUser()
        SettingUtil.setShapColor(share_submit, SettingUtil.getColor(this))
        share_username.hint = if (user.nickname.isEmpty()) user.username else user.nickname
    }

    @OnClick(R.id.share_submit)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.share_submit -> {
                when {
                    share_title.text.toString().isEmpty() -> showMessage("请填写文章标题")
                    share_url.text.toString().isEmpty() -> showMessage("请填写文章链接")
                    else -> MaterialDialog(this).show {
                        title(R.string.title)
                        message(text = "确定分享吗？")
                        positiveButton(text = "确定") {
                            mPresenter?.addAriticle(this@ShareAriticleActivity.share_title.text.toString(),
                                    this@ShareAriticleActivity.share_url.text.toString())
                        }
                        negativeButton(text = "取消")
                    }
                }
            }
        }
    }

    override fun addSucc() {
        AddEvent(SHARE_CODE).post()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.share_guize -> {
                MaterialDialog(this, BottomSheet()).show {
                    title(text = "温馨提示")
                    customView(R.layout.customview, scrollable = true, horizontalPadding = true)
                    positiveButton(text = "知道了")
                    cornerRadius(16f)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
