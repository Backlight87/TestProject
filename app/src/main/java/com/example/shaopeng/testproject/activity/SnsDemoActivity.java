package com.example.shaopeng.testproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.shaopeng.testproject.Constant;
import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.fragment.SNSLoginFragment;
import com.example.shaopeng.testproject.fragment.SNSShareFragment;

/**
 * 社会化分享登陆
 * Created by Administrator on 2017/11/13.
 */
public class SnsDemoActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sns_demo_activity_layout);
        findViewById(R.id.we_chat_login).setOnClickListener(this);
        findViewById(R.id.we_chat_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.we_chat_login:
                showFragment(SNSLoginFragment.getInstance(Constant.LOGIN_PATH_WECHAT));
                break;
            case R.id.we_chat_share:
                showFragment(SNSShareFragment.getInstance(Constant.LOGIN_PATH_WECHAT));
                break;
        }
    }
}
