package com.sycode.wandroid.mvp.model.collect

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.sycode.wandroid.mvp.contract.collect.CollectContract
import com.sycode.wandroid.mvp.model.api.Api
import com.sycode.wandroid.mvp.model.entity.ApiPagerResponse
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.CollectResponse
import io.reactivex.Observable
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/29/2019 11:01
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
class CollectModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), CollectContract.Model {


    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application

    override fun getCollectDatas(pageNo: Int): Observable<ApiResponse<ApiPagerResponse<MutableList<CollectResponse>>>> {
        return mRepositoryManager.obtainRetrofitService(Api::class.java)
                .getCollectData(pageNo)
    }


    override fun uncollectList(id: Int, originId: Int): Observable<ApiResponse<Any>> {
        return mRepositoryManager
                .obtainRetrofitService(Api::class.java)
                .uncollectList(id, originId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
