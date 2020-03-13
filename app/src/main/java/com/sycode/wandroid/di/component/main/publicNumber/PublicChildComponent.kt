package com.sycode.wandroid.di.component.main.publicNumber

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.sycode.wandroid.di.module.main.publicNumber.PublicChildModule
import com.sycode.wandroid.mvp.ui.activity.main.publicNumber.PublicChildFragment
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/09/2019 11:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(PublicChildModule::class), dependencies = arrayOf(AppComponent::class))
interface PublicChildComponent {
    fun inject(fragment: PublicChildFragment)
}
