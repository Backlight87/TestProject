package com.example.shaopeng.testproject.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.shaopeng.testproject.Model.RingsViewModel;
import com.example.shaopeng.testproject.Model.RingsViewWithNumberModel;
import com.example.shaopeng.testproject.util.FormatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 画圆环比例图表
 * Created by Administrator on 2017/11/14.
 */
public class RingsView extends View {

    private float mTextRatio = 0.04f;
    private List<RingsViewModel> ringsViewModels = new ArrayList<>();
    //测量的宽跟高
    private int mMeasureHeigth;
    private int mMeasureWidth;
    //圆弧相关
    private Paint mArcPaint;
    private RectF mArcRectF;
    private float mSweepAngle;
    private float mSweepValue = 100;
    //圆弧外切正方形的长度
    float length;
    //矩形相关
    private Rect rect;
    private Paint mRectPaint;
    //矩形宽高对应的比例（跟屏幕的宽跟高相比）
    private float mRectWeightRatio = 0.12f;
    private float mRectHeightRatio = 0.08f;
    //文字和百分比相关
    //文字的宽（高和矩形一样吧）
    //文字宽高对应的比例（跟屏幕的宽跟高相比）
    private float mTextWeightRatio = 0.07f;

    private int textX;
    private int textY;
    private Paint mTextPaint;
    private int ratioX;
    private int ratioY;

    public RingsView(Context context, List<RingsViewModel> ringsViewModels) {
        super(context);
        this.ringsViewModels = ringsViewModels;
    }

    public RingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setdata(List<RingsViewModel> ringsViewModels) {
        this.ringsViewModels = ringsViewModels;
        invalidate();
    }

    public void setdata(List<RingsViewWithNumberModel> ringsViewWithModels, int total) {
        if (ringsViewWithModels == null || total == 0) {
            return;
        }
        for (int i = 0; i < ringsViewWithModels.size(); i++) {
            RingsViewModel ringsViewModel = new RingsViewModel(ringsViewWithModels.get(i).getName(), FormatUtil.format2Decimal((ringsViewWithModels.get(i).getNumber() / (total * 1.0f)) * 100), ringsViewWithModels.get(i).getColor());
            ringsViewModels.add(ringsViewModel);
        }
        setdata(ringsViewModels);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //在这里获取宽跟高，暂时只支持mode.exart模式
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float countstart = 180;
        for (int i = 0; i < ringsViewModels.size(); i++) {
            float ratioTemp = ringsViewModels.get(i).getRatio();
            mSweepValue -= ratioTemp;
            mSweepAngle = (ratioTemp / 100f) * 360f;
            mArcPaint.setColor(ringsViewModels.get(i).getColor());
            canvas.drawArc(mArcRectF, countstart, mSweepAngle, false, mArcPaint);
            countstart += mSweepAngle;
            mRectPaint.setColor(ringsViewModels.get(i).getColor());
            canvas.drawRect(rect, mRectPaint);
            canvas.drawText(ringsViewModels.get(i).getName(), 0, ringsViewModels.get(i).getName().length(), textX, textY + (int) (mTextRatio * length / 4), mTextPaint);
            canvas.drawText(ringsViewModels.get(i).getRatio() + "%", 0, (ringsViewModels.get(i).getRatio() + "%").length(), ratioX, ratioY + (int) (mTextRatio * length / 4), mTextPaint);
            refreshRect(i);
            refreshText(i);
            refreshRadio(i);
        }
        if (mSweepValue != 0) {
            mSweepAngle = (mSweepValue / 100f) * 360f;
            mArcPaint.setColor(getResources().getColor(
                    android.R.color.black));
            canvas.drawArc(mArcRectF, countstart, mSweepAngle, false, mArcPaint);
            mRectPaint.setColor(getResources().getColor(
                    android.R.color.black));
            canvas.drawRect(rect, mRectPaint);
            String showtext = "其他";
            canvas.drawText(showtext, 0, showtext.length(), textX, textY + (int) (mTextRatio * length / 4), mTextPaint);
            canvas.drawText(mSweepValue + "%", 0, (mSweepValue + "%").length(), ratioX, ratioY + (int) (mTextRatio * length / 4), mTextPaint);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void init() {
        length = 0;
        if (mMeasureHeigth >= mMeasureWidth) {
            length = mMeasureWidth;
        } else {
            length = mMeasureHeigth;
        }
        //不给设置比例了不然容易比例不一致不好看
       /* mRectHeightRatio = mRectHeight / (length + 0f);
        mRectWeightRatio = mRectWeight / (length + 0f);
        mTextWeightRatio = mTextWeight / (length + 0f);*/
        mArcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.6),
                (float) (length * 0.6));
        rect = new Rect(
                (int) (length * 0.7),
                (int) (length * 0.1),
                (int) (length * (0.7 + mRectWeightRatio)),
                (int) (length * (0.1 + mRectHeightRatio)));

        //默认文字和百分比的高和矩形的高一样
        textX = (int) (length * (0.75 + mRectWeightRatio));
        ratioX = (int) (length * (0.77 + mRectWeightRatio + mTextWeightRatio));

        textY = (int) (length * (0.1 + mRectHeightRatio / 2));
        ratioY = (int) (length * (0.1 + mRectHeightRatio / 2));
        mSweepAngle = (mSweepValue / 100f) * 360f;
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mRectPaint = new Paint();
        mRectPaint.setStyle(Paint.Style.FILL);
        mTextPaint = new Paint();
        int textSize = (int) (mTextRatio * length);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void refreshRect(int i) {
        rect = new Rect(
                (int) (length * 0.7),
                (int) (length * (0.1 + (i + 1) * mRectHeightRatio)),
                (int) (length * (0.7 + mRectWeightRatio)),
                (int) (length * (0.1 + mRectHeightRatio + (i + 1) * (mRectHeightRatio))));
    }

    private void refreshText(int i) {
        textY = (int) (length * (0.1 + mRectHeightRatio / 2) + (int) (length * (i + 1) * mRectHeightRatio));
    }

    private void refreshRadio(int i) {
        ratioY = (int) (length * (0.1 + mRectHeightRatio / 2)) + (int) (length * (i + 1) * mRectHeightRatio);

    }
}
