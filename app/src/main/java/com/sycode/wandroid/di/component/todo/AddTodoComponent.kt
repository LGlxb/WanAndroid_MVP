package com.sycode.wandroid.di.component.todo

import com.jess.arms.di.component.AppComponent
import com.jess.arms.di.scope.ActivityScope
import com.sycode.wandroid.di.module.todo.AddTodoModule
import com.sycode.wandroid.mvp.ui.activity.todo.AddTodoActivity
import dagger.Component


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/03/2019 21:45
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = arrayOf(AddTodoModule::class), dependencies = arrayOf(AppComponent::class))
interface AddTodoComponent {
    fun inject(activity: AddTodoActivity)
}
