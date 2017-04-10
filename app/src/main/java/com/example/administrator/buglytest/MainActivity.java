package com.example.administrator.buglytest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.bugly.crashreport.CrashReport;

public class MainActivity extends AppCompatActivity {
    private Button btnBugly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CrashReport.initCrashReport(getApplicationContext(), "53368ff87b", false);
        initViews();
        getPermission();
    }

    private void initViews() {
        btnBugly= (Button) findViewById(R.id.btnBugly);
        btnBugly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrashReport.testJavaCrash();
                Toast.makeText(MainActivity.this, "You clicked this Button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getPermission(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_PHONE_STATE},1001);
        }
    }
}
