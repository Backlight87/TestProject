package com.example.shaopeng.testproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaopeng.testproject.Constant;
import com.example.shaopeng.testproject.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import static com.example.shaopeng.testproject.Constant.APPID;

/**
 * 社会化登陆
 * 因为需要申请微信微博应用，还未通过审核，先搁置
 * Created by Administrator on 2017/11/13.
 */
public class SNSLoginFragment extends Fragment {
    private IWXAPI wxapi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sns_login_fragment, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wxapi = WXAPIFactory.createWXAPI(getContext(), APPID, false);
        wxapi.registerApp(APPID);
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        wxapi.sendReq(req);
    }


    public static SNSLoginFragment getInstance(String loginPath) {
        SNSLoginFragment snsLoginFragment = new SNSLoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.LOGIN_PATH_KEY, loginPath);
        snsLoginFragment.setArguments(bundle);
        return snsLoginFragment;
    }
}
