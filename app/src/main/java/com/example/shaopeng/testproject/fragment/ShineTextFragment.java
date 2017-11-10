package com.example.shaopeng.testproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaopeng.testproject.R;

/**
 * Created by Administrator on 2017/11/10.
 */
public class ShineTextFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shine_text_view_layout, null);
    }

    public static ShineTextFragment getInstance(){
        return  new ShineTextFragment();
    }
}
