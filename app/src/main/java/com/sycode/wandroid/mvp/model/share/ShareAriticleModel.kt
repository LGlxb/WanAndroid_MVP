package com.sycode.wandroid.mvp.model.share

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.sycode.wandroid.mvp.contract.share.ShareAriticleContract
import com.sycode.wandroid.mvp.model.api.Api
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import io.reactivex.Observable
import javax.inject.Inject


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
class ShareAriticleModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), ShareAriticleContract.Model {


    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application


    override fun addAriticle(title: String, url: String): Observable<ApiResponse<Any>> {
        return mRepositoryManager.obtainRetrofitService(Api::class.java)
                .addAriticle(title, url)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
