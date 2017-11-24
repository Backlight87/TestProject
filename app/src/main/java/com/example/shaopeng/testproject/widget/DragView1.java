package com.example.shaopeng.testproject.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class DragView1 extends View {

    private int lastX;
    private int lastY;
    private Scroller scroller;

    public DragView1(Context context) {
        super(context);
        ininView();
        scroller = new Scroller(context);
    }

    public DragView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        ininView();
        scroller = new Scroller(context);
    }

    public DragView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ininView();
        scroller = new Scroller(context);
    }

    private void ininView() {
        // 给View设置背景颜色，便于观察
        setBackgroundColor(Color.BLUE);

    }

    // 视图坐标方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 在当前left、top、right、bottom的基础上加上偏移量
               /* ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                lp.leftMargin = getLeft() + offsetX;
                lp.topMargin = getTop() + offsetY;
                setLayoutParams(lp);*/
                ((ViewGroup) getParent()).scrollBy(-offsetX, -offsetY);
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                ViewGroup v = ((ViewGroup) getParent());
                int c = getScrollX();
                scroller.startScroll(v.getScrollX(), v.getScrollY(), -v.getScrollX(), -v.getScrollY(), 1000);
                invalidate();
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            ((ViewGroup) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
        }
        invalidate();
    }
}
