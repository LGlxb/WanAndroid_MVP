package com.sycode.wandroid.app.utils

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.sycode.wandroid.R
import com.sycode.wandroid.app.weight.dialog.LoadingDialog


object ShowUtils {
    private var dialog: LoadingDialog? = null
    private var toast: Toast? = null
    fun showLoading(context: Context) {
        var attr: WindowManager.LayoutParams? = dialog?.window?.attributes
        attr?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        attr?.width = ViewGroup.LayoutParams.WRAP_CONTENT
        attr?.gravity = Gravity.CENTER//设置dialog 在布局中的位置
        dialog?.run {
            if (isShowing) return
        }
        dialog = LoadingDialog(context, R.style.MyDialogStyle)
        dialog?.run {
            setCanceledOnTouchOutside(false)
            setMessage("请求网络中...")
            show()
        }
    }

    fun dismissLoading() {
        dialog?.run {
            if (isShowing) {
                dismiss()
            }
        }
        dialog = null
    }

    fun showDialog(activity: Activity, message: String) {
        if (!activity.isFinishing) {
            MaterialDialog(activity).show {
                title(R.string.title)
                message(text = message)
                positiveButton(R.string.confirm)
            }
        }

    }

    fun showDialog(activity: Activity, message: String, title: String) {
        if (!activity.isFinishing) {
            MaterialDialog(activity).show {
                title(text = title)
                message(text = message)
                positiveButton(R.string.confirm)
            }
        }

    }

    /**
     * 隐藏软键盘(只适用于Activity，不适用于Fragment)
     */
    fun hideSoftKeyboard(activity: Activity) {
        val view = activity.currentFocus
        view?.let {
            val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }


    /**
     * 在屏幕中间吐司
     */
    fun showToastCenter(context: Context, arg: String) {
        if (!TextUtils.isEmpty(arg)) {
            toast?.cancel()
            toast = Toast.makeText(context.applicationContext, arg, Toast.LENGTH_SHORT).apply {
                setGravity(Gravity.CENTER, 0, 0)
                show()
            }
        }

    }

    /**
     * 在屏幕底部吐司 默认
     */
    fun showToast(context: Context, msg: String) {
        if (!TextUtils.isEmpty(msg)) {
            toast?.cancel()
            toast = Toast.makeText(context.applicationContext, msg, Toast.LENGTH_SHORT).apply {
                show()
            }
        }
    }

    /**
     * 隐藏toast
     */
    fun hide() {
        toast?.cancel()
    }


}
