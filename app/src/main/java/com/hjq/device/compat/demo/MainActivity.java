package com.hjq.device.compat.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.device.compat.DeviceBrand;
import com.hjq.device.compat.DeviceMarketName;
import com.hjq.device.compat.DeviceOs;

public final class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TextView messageView = findViewById(R.id.tv_main_messages);
        StringBuilder stringBuilder = new StringBuilder()
            .append("BrandName: " + DeviceBrand.getBrandName())
            .append("\nMarketName: " + DeviceMarketName.getMarketName(this))
            .append("\nOsName: " + DeviceOs.getOsName())
            .append("\nOriginalOsVersionName: " + DeviceOs.getOsVersionName())
            .append("\nOsVersionName: " + DeviceOs.getOsVersionName())
            .append("\nOsBigVersionCode: " + DeviceOs.getOsBigVersionCode())
            .append("\nAndroidVersion: Android " + Build.VERSION.RELEASE)
            .append("\nAndroidApiLevel: " + Build.VERSION.SDK_INT);
        messageView.setText(stringBuilder);

        findViewById(R.id.btn_main_about_device).setOnClickListener(this);
        findViewById(R.id.btn_main_get_system_property).setOnClickListener(this);
        findViewById(R.id.btn_main_android_settings).setOnClickListener(this);

        TitleBar titleBar = findViewById(R.id.tb_main_bar);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onTitleClick(TitleBar titleBar) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(titleBar.getTitle().toString()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn_main_about_device) {
            // 跳转到关于手机界面
            startActivity(new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS));
        } else if (viewId == R.id.btn_main_get_system_property) {
            // 跳转到获取系统属性界面
            startActivity(new Intent(this, SystemPropertyActivity.class));
        } else if (viewId == R.id.btn_main_android_settings) {
            // 跳转到 Android 设置界面
            startActivity(new Intent(Settings.ACTION_SETTINGS));
        }
    }
}