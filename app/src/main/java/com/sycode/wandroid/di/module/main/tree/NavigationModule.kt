package com.sycode.wandroid.di.module.main.tree

import com.jess.arms.di.scope.FragmentScope
import com.sycode.wandroid.mvp.contract.main.tree.NavigationContract
import com.sycode.wandroid.mvp.model.main.tree.NavigationModel
import dagger.Module
import dagger.Provides


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/14/2019 11:40
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建NavigationModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class NavigationModule(private val view: NavigationContract.View) {
    @FragmentScope
    @Provides
    fun provideNavigationView(): NavigationContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideNavigationModel(model: NavigationModel): NavigationContract.Model {
        return model
    }
}
