package com.example.shaopeng.testproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.activity.i.CustomTopBarListener;
import com.example.shaopeng.testproject.util.ToastUtil;
import com.example.shaopeng.testproject.widget.CustomTopBarView;

/**
 * Created by Administrator on 2017/11/14.
 */
public class CustomTopBarFragment extends Fragment {
    private CustomTopBarListener mCustomTopBarListener = new CustomTopBarListener() {
        @Override
        public void rightClick() {
            ToastUtil.showToast("右边被点击");
        }

        @Override
        public void leftClick() {
            ToastUtil.showToast("左边被点击");
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_top_bar_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CustomTopBarView customTopBarView = view.findViewById(R.id.custom_top_bar_widget_fragment);
        customTopBarView.setListener(mCustomTopBarListener);
    }

    public static CustomTopBarFragment getInstance() {
        return new CustomTopBarFragment();
    }
}
