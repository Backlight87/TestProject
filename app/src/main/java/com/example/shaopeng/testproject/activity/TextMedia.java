package com.example.shaopeng.testproject.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.shaopeng.testproject.R;

/**
 * 参考gist： Android MediaPlayer的生命周期，写出更健壮的media play
 * Created by Administrator on 2017/11/16.
 */
public class TextMedia extends Activity implements OnClickListener {
    private int count = 0;
    private MediaPlayer mp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_media_layout);
        findViewById(R.id.play_movie).setOnClickListener(this);
        findViewById(R.id.play_music).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_movie:
                playMusic();
                break;
            case R.id.play_music:
                playMovie();
                break;
        }
    }

    /**
     * 知识点：raw和asset文件夹的区别，raw可以直接用R引用，asset只能用assetmanager去管理和读取
     * 放进raw的文件不要有后缀名
     * MediaPlayer要播放的文件主要包括3个来源：
     * a. 用户在应用中事先自带的resource资源
     * 例如：MediaPlayer.create(this, R.raw.test);
     * b. 存储在SD卡或其他文件路径下的媒体文件
     * 例如：mp.setDataSource("/sdcard/test.mp3");
     * c. 网络上的媒体文件
     * 例如：mp.setDataSource("http://www.citynorth.cn/music/confucius.mp3");
     * 两种创建media的方式，用create的方式就不用prepare了
     * mp.setDataSource("/sdcard/test2.mov");
     * mp.prepare();
     *
     * seekTo()是定位方法，可以让播放器从指定的位置开始播放，需要注意的是该方法是个异步方法，
     * 也就是说该方法返回时并不意味着定位完成，尤其是播放的网络文件，真正定位完成时会触发OnSeekComplete.onSeekComplete()，
     * 如果需要是可以调用setOnSeekCompleteListener(OnSeekCompleteListener)设置监听器来处理的。
     * mediaplay有很多监听器可以多用
     **/
    private void playMusic() {
        mp = new MediaPlayer();
        try {
            mp = MediaPlayer.create(TextMedia.this, R.raw.money_ding);
            mp.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (count < 1) {
                    count++;
                    mp = MediaPlayer.create(TextMedia.this, R.raw.money_ding);
                    mp.start();
                } else if (count == 1) {
                    mp.release();
                    count = 0;
                }
            }
        });
    }

    private void playMovie() {

    }


}
