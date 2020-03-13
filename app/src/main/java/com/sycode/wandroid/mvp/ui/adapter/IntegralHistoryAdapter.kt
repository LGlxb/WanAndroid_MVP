package com.sycode.wandroid.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sycode.wandroid.R
import com.sycode.wandroid.app.utils.DatetimeUtil
import com.sycode.wandroid.app.utils.SettingUtil
import com.sycode.wandroid.mvp.model.entity.IntegralHistoryResponse

/**
 * 积分获取历史 adapter
 */
class IntegralHistoryAdapter(data: ArrayList<IntegralHistoryResponse>?) : BaseQuickAdapter<IntegralHistoryResponse, BaseViewHolder>(R.layout.item_integral_history, data) {
    override fun convert(helper: BaseViewHolder, item: IntegralHistoryResponse?) {
        //赋值
        item?.run {
            val descStr = if (desc.contains("积分")) desc.subSequence(desc.indexOf("积分"), desc.length) else ""
            helper.setText(R.id.item_integralhistory_title, reason + descStr)
            helper.setText(R.id.item_integralhistory_date, DatetimeUtil.formatDate(date, DatetimeUtil.DATE_PATTERN_SS))
            helper.setText(R.id.item_integralhistory_count, "+$coinCount")
            helper.setTextColor(R.id.item_integralhistory_count, SettingUtil.getColor(mContext))
        }
    }
}


