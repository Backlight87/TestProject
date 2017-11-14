package com.example.shaopeng.testproject.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.activity.i.CustomTopBarListener;

/**
 * 自定义布局初级实现：自定义顶部控件
 * Created by Administrator on 2017/11/14.
 */
public class CustomTopBarView extends RelativeLayout {
    private String mLeftText;
    private String mRighText;
    private String mTitle;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;
    private Context mContext;
    private CustomTopBarListener mCustomTopBarListener;

    public CustomTopBarView(Context context) {
        super(context);
        mContext = context;

    }

    public CustomTopBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTopBarView);
        if (typedArray != null) {
            mLeftText = typedArray.getString(R.styleable.CustomTopBarView_LeftText);
            mRighText = typedArray.getString(R.styleable.CustomTopBarView_RightText);
            mTitle = typedArray.getString(R.styleable.CustomTopBarView_Title);
        }
        typedArray.recycle();
        initView();
    }

    /**
     * 知识点1： addView(控件,布局参数);这个布局参数是对外面这个根布局起作用的，控件的setLayoutParams是对控件里起作用，比如button里面的文字位置
     */
    private void initView() {
        mLeftButton = new Button(mContext);
        mLeftButton.setText(mLeftText);
        RelativeLayout.LayoutParams layoutParamsLeft = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsLeft.addRule(ALIGN_PARENT_LEFT, TRUE);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomTopBarListener.leftClick();
            }
        });
        RelativeLayout.LayoutParams layoutParamsRight = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsRight.addRule(ALIGN_PARENT_RIGHT);

        mRightButton = new Button(mContext);
        mRightButton.setText(mRighText);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomTopBarListener.rightClick();
            }
        });

        mTitleView = new TextView(mContext);
        mTitleView.setText(mTitle);
        RelativeLayout.LayoutParams layoutParamsTitle = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsTitle.addRule(CENTER_IN_PARENT);

        addView(mLeftButton, layoutParamsLeft);
        addView(mRightButton, layoutParamsRight);
        addView(mTitleView, layoutParamsTitle);
    }

    public void setListener(CustomTopBarListener mCustomTopBarListener) {
        this.mCustomTopBarListener = mCustomTopBarListener;
    }
}
