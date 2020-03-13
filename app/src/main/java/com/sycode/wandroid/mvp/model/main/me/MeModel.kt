package com.sycode.wandroid.mvp.model.main.me

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.sycode.wandroid.mvp.contract.main.me.MeContract
import com.sycode.wandroid.mvp.model.api.Api
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.IntegralResponse
import io.reactivex.Observable
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/31/2019 14:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
class MeModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MeContract.Model {
    override fun getIntegral(): Observable<ApiResponse<IntegralResponse>> {
        return mRepositoryManager
                .obtainRetrofitService(Api::class.java)
                .getIntegral()

    }

    @Inject
    lateinit var mGson: Gson

    @Inject
    lateinit var mApplication: Application

    override fun onDestroy() {
        super.onDestroy()
    }
}
