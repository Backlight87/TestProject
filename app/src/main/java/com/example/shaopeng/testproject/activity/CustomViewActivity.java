package com.example.shaopeng.testproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.fragment.CustomTopBarFragment;
import com.example.shaopeng.testproject.fragment.ShineTextFragment;

/**
 * Created by Administrator on 2017/11/10.
 */
public class CustomViewActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_layout);
        findViewById(R.id.shine_text_widget).setOnClickListener(this);
        findViewById(R.id.custom_top_bar_widget).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shine_text_widget:
                showFragment(ShineTextFragment.getInstance());
                break;
            case R.id.custom_top_bar_widget:
                showFragment(CustomTopBarFragment.getInstance());
                break;
        }
    }
}
