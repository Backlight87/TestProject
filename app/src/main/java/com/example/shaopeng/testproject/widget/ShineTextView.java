package com.example.shaopeng.testproject.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 闪烁文字效果：
 * 基本原理：利用渲染器LinearGradient绘制（两边一个颜色，中间白色会给人一种闪光的感觉），然后在绘制的时候不断平移LinearGradient，是的中间白色部分不断平移
 * Created by Administrator on 2017/11/9.
 */
public class ShineTextView extends android.support.v7.widget.AppCompatTextView {
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private int mViewWidth;
    private int mTranslate;

    public ShineTextView(Context context) {
        super(context);
    }
    public ShineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 在这里一般是为了获取view的宽高，因为会先执行测量再执行size change
     * 执行顺序，先measure（不确定次数）——onsize change——on layout——on draw
     * 关于渲染器的知识点：
     * mLinearGradient是shade的一个子类，设置给画笔片头，带来各种渲染效果
     * LinearGradient（起点X，起点有，终点想，终点有，渲染颜色集合，颜色所占比例（null就是平分），渲染模式）
     * 渲染模式（三种）：假定颜色集合：红蓝白，渲染起点到终点是图形的中间，CLAMP边缘拉伸就是拉伸紅和白填充满整个图形，还有一种镜像，就是红蓝白，白蓝红，红蓝白填充满，还有一种就是红蓝白红蓝白红蓝白填充。
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLUE, Color.WHITE,
                                Color.BLUE},
                        null,
                        Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    /**
     * 关于平移有这个两个知识点：
     * 1、每次平移都是基于原始点的，所以我们每次要平移五分之一，平移距离要累加
     * 2、平移的原始点是中心，也就是中间那一点，所以要让mTranslate = -mViewWidth;
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }

}