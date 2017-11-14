package com.example.shaopeng.testproject.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

import com.example.shaopeng.testproject.Constant;
import com.example.shaopeng.testproject.activity.MainActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信登陆必须在自己的包下比如com.example.shaopeng.testproject新建包名wxapi,
 * 在wxapi下新建WXEntryActivity extends Activity implements IWXAPIEventHandler
 * 来接受回调信息
 * Created by Administrator on 2017/11/13.
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI mIwxapi;

    @Override
    protected void onResume() {
        super.onResume();
        mIwxapi = WXAPIFactory.createWXAPI(this, Constant.APPID, false);
        mIwxapi.handleIntent(getIntent(), this);
        mFinish();
    }

    @Override
    public void onReq(BaseReq baseReq) {
    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp != null && baseResp.errCode == BaseResp.ErrCode.ERR_OK) {
            if (baseResp instanceof SendAuth.Resp) {
                SendAuth.Resp resp = (SendAuth.Resp) baseResp;
                if (resp.code != null && resp.code.length() > 0) {
                    Intent intent = new Intent(WXEntryActivity.this, MainActivity.class);
                    intent.putExtra("2222", resp.code);
                    startActivity(intent);
                }
            }
        }
        mFinish();
    }

    private void mFinish() {
        if (Build.VERSION.SDK_INT >= 21) {
            finishAfterTransition();
        } else {
            finish();
        }
    }
}
