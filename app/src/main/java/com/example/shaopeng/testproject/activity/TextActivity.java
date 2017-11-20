package com.example.shaopeng.testproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.shaopeng.testproject.R;

/**
 * Created by Administrator on 2017/11/20.
 */

public class TextActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_beginner_fragment_layout);
    }
}
