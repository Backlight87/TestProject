package com.example.shaopeng.testproject.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shaopeng.testproject.Model.RingsViewWithNumberModel;
import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.widget.RingsView;

import java.util.ArrayList;
import java.util.List;

/**
 * 初级的自定义view都放在这，通过隐藏和显示来控制
 * Created by Administrator on 2017/11/14.
 */
public class CustomViewBeginnerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_view_beginner_fragment_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       /* List<RingsViewWithNumberModel> ringsViewModels = new ArrayList<>();
        RingsViewWithNumberModel ringsViewModel2 = new RingsViewWithNumberModel("巨胖", 20, Color.BLUE);
        RingsViewWithNumberModel ringsViewModel3 = new RingsViewWithNumberModel("大胖", 29, Color.YELLOW);
        RingsViewWithNumberModel ringsViewModel4 = new RingsViewWithNumberModel("小胖", 40, Color.RED);
        ringsViewModels.add(ringsViewModel2);
        ringsViewModels.add(ringsViewModel3);
        ringsViewModels.add(ringsViewModel4);
        RingsView ringsView = view.findViewById(R.id.ring);
        ringsView.setdata(ringsViewModels, 200);
        ringsView.setVisibility(View.GONE);*/
        /*RelativeLayout relativeLayout= view.findViewById(R.id.view_group);
        relativeLayout.addView(new MusicRectView(getActivity()));*/
    }

    public static CustomViewBeginnerFragment getInstance() {
        return new CustomViewBeginnerFragment();
    }
}
