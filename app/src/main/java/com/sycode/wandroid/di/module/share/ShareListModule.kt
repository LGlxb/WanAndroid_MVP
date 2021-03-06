package com.sycode.wandroid.di.module.share

import com.jess.arms.di.scope.ActivityScope
import com.sycode.wandroid.mvp.contract.share.ShareListContract
import com.sycode.wandroid.mvp.model.share.ShareListModel
import dagger.Module
import dagger.Provides


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
@Module
//构建ShareListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ShareListModule(private val view: ShareListContract.View) {
    @ActivityScope
    @Provides
    fun provideShareListView(): ShareListContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideShareListModel(model: ShareListModel): ShareListContract.Model {
        return model
    }
}
