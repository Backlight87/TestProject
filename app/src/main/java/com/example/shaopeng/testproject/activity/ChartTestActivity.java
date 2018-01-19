package com.example.shaopeng.testproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import com.example.shaopeng.testproject.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 图表练习专用
 * Created by Administrator on 2018/1/18.
 */
public class ChartTestActivity extends BaseActivity {
    private LineChart mChart;
    private List<Entry> entries = new ArrayList<Entry>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_layout);
        mChart = (LineChart) findViewById(R.id.chart);
        getData();
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        mChart.setTouchEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(true);
        mChart.setData(lineData);
        mChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });
        mChart.invalidate(); // refresh
    }


    private void getData() {
        entries.add(new Entry(16, 1.8f));
        entries.add(new Entry(17, 2f));
        entries.add(new Entry(18, 1.9f));
        entries.add(new Entry(19, 1.8f));
        entries.add(new Entry(20, 2f));

    }
}
