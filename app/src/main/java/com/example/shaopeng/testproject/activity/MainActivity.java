package com.example.shaopeng.testproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shaopeng.testproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.custom_view_main_activity).setOnClickListener(this);
        findViewById(R.id.material_design_main_activity).setOnClickListener(this);
        findViewById(R.id.share_login_pay_main_activity).setOnClickListener(this);
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
        }
    }

    private void startActivity(Class object) {
        Intent intent = new Intent(this, object);
        startActivity(intent);
    }
}
