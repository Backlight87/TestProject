package com.example.shaopeng.testproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.fragment.ShineTextFragment;

/**
 * Created by Administrator on 2017/11/10.
 */
public class CustomViewActivity extends FragmentActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_layout);
        findViewById(R.id.shine_text_widget).setOnClickListener(this);
    }


    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contain_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shine_text_widget:
                showFragment(ShineTextFragment.getInstance());
                break;
        }
    }
}
