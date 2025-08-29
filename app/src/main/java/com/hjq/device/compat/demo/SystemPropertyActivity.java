package com.hjq.device.compat.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.device.compat.demo.ShellUtils.CommandResult;

public final class SystemPropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_property_activity);

        TextView messageView = findViewById(R.id.tv_system_property_messages);

        TitleBar titleBar = findViewById(R.id.tb_system_property_bar);
        titleBar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onTitleClick(TitleBar titleBar) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(titleBar.getTitle().toString()));
                startActivity(intent);
            }
        });

        new Thread(() -> {
            CommandResult systemPropertyInfo = ShellUtils.execCmd("getprop", false, true);
            Log.i("DeviceCompat", systemPropertyInfo.successMsg);
            runOnUiThread(() -> messageView.setText(systemPropertyInfo.successMsg));
        }).start();
    }
}
