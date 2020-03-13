package com.sycode.wandroid.mvp.model.collect

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.sycode.wandroid.mvp.contract.collect.CollectUrlContract
import com.sycode.wandroid.mvp.model.api.Api
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.CollectUrlResponse
import io.reactivex.Observable
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/31/2019 11:27
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
class CollectUrlModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), CollectUrlContract.Model {
    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application

    override fun getCollectUrlDatas(): Observable<ApiResponse<MutableList<CollectUrlResponse>>> {
        return mRepositoryManager.obtainRetrofitService(Api::class.java)
                .getCollectUrlData()
    }

    override fun uncollectList(id: Int): Observable<ApiResponse<Any>> {
        return mRepositoryManager
                .obtainRetrofitService(Api::class.java)
                .deletetool(id)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
