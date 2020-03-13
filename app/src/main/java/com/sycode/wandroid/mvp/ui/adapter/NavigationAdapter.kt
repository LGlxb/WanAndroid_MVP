package com.sycode.wandroid.mvp.ui.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sycode.wandroid.R
import com.sycode.wandroid.app.utils.ColorUtil
import com.sycode.wandroid.mvp.model.entity.AriticleResponse
import com.sycode.wandroid.mvp.model.entity.NavigationResponse
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout
import kotlinx.android.synthetic.main.flow_layout.view.*

/**
 * 导航 adapter
 */
class NavigationAdapter(data: MutableList<NavigationResponse>?) : BaseQuickAdapter<NavigationResponse, BaseViewHolder>(R.layout.item_system, data) {

    var tagClicklistener: TagClicklistener? = null

    override fun convert(helper: BaseViewHolder?, item: NavigationResponse?) {
        item?.let {
            helper?.setText(R.id.item_system_title, it.name)
            helper?.getView<TagFlowLayout>(R.id.item_system_flowlayout)?.run {
                adapter = object : TagAdapter<AriticleResponse>(it.articles) {
                    override fun getView(parent: FlowLayout?, position: Int, hotSearchBean: AriticleResponse?): View {
                        return LayoutInflater.from(parent?.context).inflate(R.layout.flow_layout, this@run, false)
                                .apply {
                                    flow_tag.text = Html.fromHtml(hotSearchBean?.title)
                                    flow_tag.setTextColor(ColorUtil.randomColor())
                                }
                    }
                }
                setOnTagClickListener { view, position, parent ->
                    tagClicklistener?.onClick(helper.adapterPosition, position)
                    false
                }
            }
        }
    }

    fun setTagClickListener(tagClicklistener: TagClicklistener) {
        this.tagClicklistener = tagClicklistener
    }

    interface TagClicklistener {
        fun onClick(position: Int, childPosition: Int)
    }


}