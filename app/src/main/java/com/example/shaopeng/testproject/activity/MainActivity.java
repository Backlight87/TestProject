package com.example.shaopeng.testproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shaopeng.testproject.R;
import com.example.shaopeng.testproject.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private String mJsonText="{\"result_code\":1000,\"result_msg\":\"\",\"data\":{\"page\":1,\"size\":10,\"total_pages\":1,\"total_result\":6,\"rows\":[{\"id\":7,\"name\":\"虚拟商品\",\"price\":233.0,\"integral\":200,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"images/goods/86ea4aab7da84924a4c9da9b59a0169c.png\"},{\"id\":10024,\"name\":\"香蕉\",\"price\":10.0,\"integral\":0,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"goods/15064976206925378/261bb622c8dc4c628a4bdbebec2f62a8.png\"},{\"id\":10025,\"name\":\"香蕉\",\"price\":10.0,\"integral\":0,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"goods/15064976206925378/485563002c0c4328ab46a6b3b7387b26.png\"},{\"id\":10026,\"name\":\"香蕉\",\"price\":10.0,\"integral\":0,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"goods/15064976206925378/57b5362d0d374a61801766cb977051f0.png\"},{\"id\":10027,\"name\":\"赏你花\",\"price\":20.0,\"integral\":0,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"goods/15064976206925378/e6b8527d6f254f09bd72b986f592be56.png\"},{\"id\":10028,\"name\":\"苹果\",\"price\":10.0,\"integral\":0,\"deduct\":0.0,\"points\":0.0,\"first_image\":\"goods/15064976206925378/8b2ed837a33b4a63a38bc16099607974.png\"}]}}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_viewgroup);
       /* findViewById(R.id.custom_view_main_activity).setOnClickListener(this);
        findViewById(R.id.material_design_main_activity).setOnClickListener(this);
        findViewById(R.id.share_login_pay_main_activity).setOnClickListener(this);
        findViewById(R.id.tts_main_activity).setOnClickListener(this);
        findViewById(R.id.media_text_main_activity).setOnClickListener(this);
*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.custom_view_main_activity:
                startActivity(CustomViewActivity.class);
                break;
            case R.id.material_design_main_activity:
                startActivity(MaterialDesignActivity.class);
                break;
            case R.id.share_login_pay_main_activity:
                startActivity(SnsDemoActivity.class);
                break;
            case R.id.tts_main_activity:
                startActivity(TTSTextActivity.class);
                break;
            case R.id.media_text_main_activity:
                startActivity(TextMedia.class);
                break;
        }
    }

    private void startActivity(Class object) {
        Intent intent = new Intent(this, object);
        intent.putExtra("ddd",222);
        startActivity(intent);
    }
}
