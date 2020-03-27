package com.example.androidnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    private NotificatioHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.txtfname);
        button = findViewById(R.id.button);
        mNotificationHelper = new NotificatioHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnFirsName(editText.getText().toString());
            }
        });
    }
    public void sendOnFirsName(String fname){

        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(fname);
        mNotificationHelper.getManager().notify(1, nb.build());
    }
}
