package com.sycode.wandroid.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sycode.wandroid.R
import com.sycode.wandroid.mvp.model.entity.OpenProject

/**
 * 开源项目 adapter
 */
class OpenProjectAdapter(data: ArrayList<OpenProject>?) : BaseQuickAdapter<OpenProject, BaseViewHolder>(R.layout.item_openproject, data) {

    override fun convert(helper: BaseViewHolder?, item: OpenProject?) {
        helper ?: return
        //赋值
        item?.run {
            helper.setText(R.id.item_openproject_name, name)
            helper.setText(R.id.item_openproject_content, content)


        }
    }
}


