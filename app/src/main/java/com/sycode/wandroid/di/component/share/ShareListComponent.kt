package com.sycode.wandroid.di.component.share

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.sycode.wandroid.di.module.share.ShareListModule
import com.sycode.wandroid.mvp.ui.activity.share.ShareListActivity
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/08/2019 13:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(ShareListModule::class), dependencies = arrayOf(AppComponent::class))
interface ShareListComponent {
    fun inject(activity: ShareListActivity)
}
