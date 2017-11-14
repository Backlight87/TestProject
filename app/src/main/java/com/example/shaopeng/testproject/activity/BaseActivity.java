package com.example.shaopeng.testproject.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.shaopeng.testproject.R;

/**
 * Created by Administrator on 2017/11/13.
 */
public class BaseActivity extends FragmentActivity {
    /**
     * 用add可能会出现fragment层叠。如果非要add参考书签
     *
     * @param fragment
     */
    public void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contain_fragment, fragment);
        transaction.commit();
    }
}
