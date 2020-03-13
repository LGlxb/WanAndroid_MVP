package com.sycode.wandroid.di.component.share

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.sycode.wandroid.di.module.share.ShareAriticleModule
import com.sycode.wandroid.mvp.ui.activity.share.ShareAriticleActivity
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/08/2019 13:27
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(ShareAriticleModule::class), dependencies = arrayOf(AppComponent::class))
interface ShareAriticleComponent {
    fun inject(activity: ShareAriticleActivity)
}
