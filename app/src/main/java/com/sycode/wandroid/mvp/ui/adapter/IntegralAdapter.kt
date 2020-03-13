package com.sycode.wandroid.mvp.ui.adapter

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sycode.wandroid.R
import com.sycode.wandroid.app.utils.SettingUtil
import com.sycode.wandroid.mvp.model.entity.IntegralResponse

/**
 * 积分排行 adapter
 */
class IntegralAdapter(data: ArrayList<IntegralResponse>?) : BaseQuickAdapter<IntegralResponse, BaseViewHolder>(R.layout.item_integral, data) {
    private var rankNum: Int = -1

    constructor(data: ArrayList<IntegralResponse>?, rank: Int) : this(data) {
        this.rankNum = rank
    }

    override fun convert(helper: BaseViewHolder?, item: IntegralResponse?) {
        helper ?: return
        //赋值
        item?.run {
            if (rankNum == helper.adapterPosition + 1) {
                helper.setTextColor(R.id.item_integral_rank, SettingUtil.getColor(mContext))
                helper.setTextColor(R.id.item_integral_name, SettingUtil.getColor(mContext))
                helper.setTextColor(R.id.item_integral_count, SettingUtil.getColor(mContext))
            } else {
                helper.setTextColor(R.id.item_integral_rank, ContextCompat.getColor(mContext, R.color.colorBlack333))
                helper.setTextColor(R.id.item_integral_name, ContextCompat.getColor(mContext, R.color.colorBlack666))
                helper.setTextColor(R.id.item_integral_count, ContextCompat.getColor(mContext, R.color.textHint))
            }
            helper.setText(R.id.item_integral_rank, "${helper.adapterPosition + 1}")
            helper.setText(R.id.item_integral_name, username)
            helper.setText(R.id.item_integral_count, coinCount.toString())
        }
    }
}


