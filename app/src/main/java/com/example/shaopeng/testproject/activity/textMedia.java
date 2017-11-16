package com.example.shaopeng.testproject.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.shaopeng.testproject.R;

import java.io.IOException;

/**reset 取代release
 * Created by Administrator on 2017/11/16.
 */
public class textMedia extends Activity{
    private int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_media_layout);
        init();
    }
    private void init() {
        MediaPlayer mp=new MediaPlayer();
        try {
            mp.setDataSource("/sdcard/test2.mov");
            mp.prepare();
            mp.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(count<1){
                    count++;
                    mp.start();
                }else if(count==1){
                    mp.release();
                    count=0;
                }

            }
        });
    }

}
