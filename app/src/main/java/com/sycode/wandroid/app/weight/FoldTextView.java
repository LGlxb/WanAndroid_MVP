package com.sycode.wandroid.app.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sycode.wandroid.R;

/**
 * Author by 刘小笨LG,  Date on 2020/3/12.
 * Email sy_android@sina.cn,
 * Role:
 */
public class FoldTextView extends LinearLayout implements View.OnClickListener {
    //最多显示行数
    private static final int DEFAULT_MAX_LINE_COUNT = 3;
    //不可操作状态
    private static final int COLLAPSIBLE_STATE_NONE = 0;
    //收起
    private static final int COLLAPSIBLE_STATE_SHRINKUP = 1;
    //展开
    private static final int COLLAPSIBLE_STATE_SPREAD = 2;
    private TextView desc;
    private ImageView img_down;
    private int durationMillis = 350;//动画持续时间
    private int mState;
    private boolean flag;

    public FoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = inflate(context, R.layout.flod_textview, this);
        view.setPadding(0, -1, 0, 0);
        desc = view.findViewById(R.id.desc_tv);
        img_down = view.findViewById(R.id.img_down);
        img_down.setOnClickListener(this);
    }

    public FoldTextView(Context context) {
        this(context, null);
    }

    /**
     * 对外提供暴漏的方法，为文本提供数据
     *
     * @param charSequence 文本内容
     */
    public final void setDesc(CharSequence charSequence) {
        desc.setText(charSequence);
        mState = COLLAPSIBLE_STATE_SPREAD;
        requestLayout();
    }

    @Override
    public void onClick(View v) {
        flag = false;
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!flag) {
            flag = true;
            if (desc.getLineCount() <= DEFAULT_MAX_LINE_COUNT) {
                mState = COLLAPSIBLE_STATE_NONE;
                img_down.setVisibility(View.GONE);
                desc.setMaxLines(DEFAULT_MAX_LINE_COUNT + 1);
            } else {
                post(() -> {
                    if (mState == COLLAPSIBLE_STATE_SPREAD) {
                        /**
                         * 展开动画
                         * 从起始高度增长至实际高度
                         */
                        RotateAnimation animation = new RotateAnimation(180, 0,
                                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        animation.setDuration(durationMillis);
                        animation.setFillAfter(true);
                        desc.setMaxLines(DEFAULT_MAX_LINE_COUNT);
                        img_down.setVisibility(View.VISIBLE);
                        img_down.setImageDrawable(getResources().getDrawable(R.drawable.jtdown));
                        mState = COLLAPSIBLE_STATE_SHRINKUP;
                    } else if (mState == COLLAPSIBLE_STATE_SHRINKUP) {
                        RotateAnimation animation = new RotateAnimation(0, 180,
                                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        animation.setDuration(durationMillis);
                        animation.setFillAfter(true);
                        img_down.startAnimation(animation);
                        desc.setMaxLines(Integer.MAX_VALUE);
                        img_down.setVisibility(View.VISIBLE);
                        img_down.setImageDrawable(getResources().getDrawable(R.drawable.jtup));
                        mState = COLLAPSIBLE_STATE_SPREAD;
                    }
                });
            }
        }
    }
}
