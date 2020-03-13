package com.sycode.wandroid.app.weight.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sycode.wandroid.R;


/**
 * Author by 刘小笨LG,  Date on 2020/2/27.
 * Email sy_android@sina.cn,
 * Role:动画加载View弹窗
 */
public class LoadingDialog extends Dialog {
    private AVLoadingIndicatorView avi;
    private TextView messagetv;
    private RelativeLayout loadingbg;

    /**
     * 自定义主题及布局的构造方法
     *
     * @param context
     * @param theme// 去除顶部蓝色线条
     */
    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams attr = getWindow().getAttributes();
        attr.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        attr.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 按返回键是否取消
        setCancelable(false);
        // 点击Dialog外围是否取消
        setCanceledOnTouchOutside(false);
        attr.gravity = Gravity.CENTER;//设置dialog 在布局中的位置
        setContentView(R.layout.avidialog_layout);
        loadingbg = findViewById(R.id.loadingbg);
        avi = findViewById(R.id.avi);
        messagetv = findViewById(R.id.message);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public LoadingDialog setMessage(String message) {
        messagetv.setText(message);
        return this;
    }

    @Override
    public void show() {
        super.show();
        avi.smoothToShow();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        avi.smoothToHide();
    }

    /***
     * 设置loading背景色
     * @param Colorbg
     * @return
     */
    public LoadingDialog setLoadingBg(int Colorbg) {
        loadingbg.setBackgroundColor(Colorbg);
        return this;
    }
}