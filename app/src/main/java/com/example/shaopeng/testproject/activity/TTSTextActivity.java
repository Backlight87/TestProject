package com.example.shaopeng.testproject.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;


import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.util.ToastUtil;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.util.ResourceUtil;

import java.util.Locale;


/**
 * Created by Administrator on 2017/11/15.
 */
public class TTSTextActivity extends Activity implements View.OnClickListener {
    private final String text = "您收到一笔12.25元的转账";
    private TextToSpeech tts;
    private SpeechSynthesizer mTts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts_layout);
        requestPermissions();
        findViewById(R.id.xunfei_tts_local).setOnClickListener(this);
        findViewById(R.id.xunfei_tts_online).setOnClickListener(this);
        findViewById(R.id.android_tts).setOnClickListener(this);

        mTts = SpeechSynthesizer.createSynthesizer(this,
                new InitListener() {
                    @Override
                    public void onInit(int i) {

                    }
                });
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
        mTts.setParameter(ResourceUtil.TTS_RES_PATH, getResourcePath());
        mTts.setParameter(SpeechConstant.ENGINE_MODE, SpeechConstant.MODE_MSC);
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaofeng");// 设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "80");// 设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");// 设置音量，范围0~100

        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");
        mTts.startSpeaking(text, mSynListener);
    }

    // 合成监听器
    private SynthesizerListener mSynListener = new SynthesizerListener() {
        // 会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {
        }

        // 缓冲进度回调
        // percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
        }

        // 开始播放
        public void onSpeakBegin() {
        }

        // 暂停播放
        public void onSpeakPaused() {
        }

        // 播放进度回调
        // percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
        }

        // 恢复播放回调接口
        public void onSpeakResumed() {
        }

        // 会话事件回调接口
        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
        }

    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xunfei_tts_local:
                break;
            case R.id.xunfei_tts_online:
                break;
            case R.id.android_tts:
                androidTtsSetting();
                break;
        }
    }

    //获取发音人资源路径
    private String getResourcePath() {
        StringBuffer tempBuffer = new StringBuffer();
        //合成通用资源
        tempBuffer.append(ResourceUtil.generateResourcePath(this, ResourceUtil.RESOURCE_TYPE.assets, "tts/common.jet"));
        tempBuffer.append(";");
        //发音人资源
        tempBuffer.append(ResourceUtil.generateResourcePath(this, ResourceUtil.RESOURCE_TYPE.assets, "tts/" + "xiaofeng" + ".jet"));
        return tempBuffer.toString();
    }


    /**
     * 动态请求权限
     */
    private void requestPermissions() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int permission = ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.LOCATION_HARDWARE, Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_SETTINGS, Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_CONTACTS}, 0x0010);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) { // 关闭TTS引擎
            tts.shutdown();
        }
    }

    /**
     * 三种TTs参数配置
     */
    private void xunfeiOnlineTtsSetting() {

    }

    private void xunfeiLocalTtsSetting() {
    }

    private void androidTtsSetting() {

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int supported = tts.setLanguage(Locale.CHINESE);
                    if ((supported != TextToSpeech.LANG_AVAILABLE) && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
                        ToastUtil.showToast("不支持当前语言");
                    } else {
                        //speak（播报文字,播报方式（QUEUE_ADD是追加，也就是队列前面的执行完成再执行，QUEUE_FLUSH是晴空前面的队列，立即播放当前的这条））方法返回：-1失败 1 成功，
                        //在这里播放保证一定会被播放（不然有可能还没初始化导致失败）
                        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                        //可选参数
                        //ynthesizeToFile是把转换得到的音频保存成声音文件。speak是直接播放
                        //tts.synthesizeToFile(text, null, "/mnt/sdcard/sound.wav");
                    }
                }
            }
        });
    }
}
