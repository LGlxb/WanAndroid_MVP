package com.sycode.wandroid.di.component.main.project

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.FragmentScope
import com.sycode.wandroid.di.module.main.project.ProjectModule
import com.sycode.wandroid.mvp.ui.activity.main.project.ProjectFragment
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/31/2019 13:58
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(ProjectModule::class), dependencies = arrayOf(AppComponent::class))
interface ProjectComponent {
    fun inject(fragment: ProjectFragment)
}
