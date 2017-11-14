package com.example.shaopeng.testproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaopeng.testproject.Constant;
import com.example.shaopeng.testproject.R;


/**
 * 社会化分享
 * Created by Administrator on 2017/11/14.
 */
public class SNSShareFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sns_share_fragment, null);
    }

    public static SNSShareFragment getInstance(String loginPath) {
        SNSShareFragment snsShareFragment = new SNSShareFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.LOGIN_PATH_KEY, loginPath);
        snsShareFragment.setArguments(bundle);
        return snsShareFragment;
    }
}
