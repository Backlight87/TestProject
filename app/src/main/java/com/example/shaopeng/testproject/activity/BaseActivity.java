package com.example.shaopeng.testproject.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.shaopeng.testproject.R;

/**
 * Created by Administrator on 2017/11/13.
 */
public class BaseActivity  extends FragmentActivity{
    public void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contain_fragment, fragment);
        transaction.commit();
    }
}
