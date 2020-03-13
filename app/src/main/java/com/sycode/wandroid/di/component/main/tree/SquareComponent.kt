package com.sycode.wandroid.di.component.main.tree

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.sycode.wandroid.di.module.main.tree.SquareModule
import com.sycode.wandroid.mvp.ui.activity.main.tree.SquareFragment
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/08/2019 09:49
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(SquareModule::class), dependencies = arrayOf(AppComponent::class))
interface SquareComponent {
    fun inject(fragment: SquareFragment)
}
