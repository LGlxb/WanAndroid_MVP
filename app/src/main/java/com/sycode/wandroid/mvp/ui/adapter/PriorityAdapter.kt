package com.sycode.wandroid.mvp.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sycode.wandroid.R
import com.sycode.wandroid.app.weight.MyColorCircleView
import com.sycode.wandroid.mvp.model.entity.enums.TodoType

/**
 * 重要程度 adapter
 */
class PriorityAdapter(data: ArrayList<TodoType>?) : BaseQuickAdapter<TodoType, BaseViewHolder>(R.layout.item_todo_dialog, data) {
    var checkType = TodoType.TodoType1.type

    constructor(data: ArrayList<TodoType>?, checkType: Int) : this(data) {
        this.checkType = checkType
    }

    override fun convert(helper: BaseViewHolder, item: TodoType?) {
        //赋值
        item?.run {
            helper.setText(R.id.item_todo_dialog_name, item.content)
            if (checkType == item.type) {
                helper.getView<MyColorCircleView>(R.id.item_todo_dialog_icon).setViewSelect(item.color)
            } else {
                helper.getView<MyColorCircleView>(R.id.item_todo_dialog_icon).setView(item.color)
            }
        }
    }
}


