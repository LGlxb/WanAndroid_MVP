package com.sycode.wandroid.mvp.model.main.publicNumber

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.sycode.wandroid.mvp.contract.main.publicNumber.PublicContract
import com.sycode.wandroid.mvp.model.api.Api
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.ClassifyResponse
import io.reactivex.Observable
import javax.inject.Inject


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/31/2019 14:02
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
class PublicModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), PublicContract.Model {

    @Inject
    lateinit var mGson: Gson;

    @Inject
    lateinit var mApplication: Application;

    override fun onDestroy() {
        super.onDestroy();
    }

    override fun getTitles(): Observable<ApiResponse<MutableList<ClassifyResponse>>> {
        return mRepositoryManager
                .obtainRetrofitService(Api::class.java)
                .getPublicTypes()
    }

}
