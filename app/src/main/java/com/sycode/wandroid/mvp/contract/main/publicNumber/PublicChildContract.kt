package com.sycode.wandroid.mvp.contract.main.publicNumber

import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import com.sycode.wandroid.mvp.model.entity.ApiPagerResponse
import com.sycode.wandroid.mvp.model.entity.ApiResponse
import com.sycode.wandroid.mvp.model.entity.AriticleResponse
import io.reactivex.Observable


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/09/2019 11:03
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
interface PublicChildContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView {
        fun requestDataSucc(apiPagerResponse: ApiPagerResponse<MutableList<AriticleResponse>>)
        fun requestDataFaild(errorMsg: String)
        fun collect(collected: Boolean, position: Int)
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel {
        //根据分类id获取项目数据
        fun getPublicDatas(pageNo: Int, cid: Int): Observable<ApiResponse<ApiPagerResponse<MutableList<AriticleResponse>>>>
        fun collect(id: Int): Observable<ApiResponse<Any>>
        fun uncollect(id: Int): Observable<ApiResponse<Any>>
    }

}
