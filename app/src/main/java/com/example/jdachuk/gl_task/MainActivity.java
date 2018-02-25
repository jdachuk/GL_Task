package com.example.jdachuk.gl_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jdachuk.gl_task.model.CarKeylessEntrySystem;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{

    private CarKeylessEntrySystem carKeylessEntrySystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carKeylessEntrySystem = new CarKeylessEntrySystem();
        carKeylessEntrySystem.setIndicator((TextView) findViewById(R.id.alarm_indicator));

        findViewById(R.id.lock_btn).setOnClickListener(this);
        findViewById(R.id.unlock_btn).setOnClickListener(this);
        findViewById(R.id.lock_x2_btn).setOnClickListener(this);
        findViewById(R.id.unlock_x2_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.lock_btn:
                carKeylessEntrySystem.Lock();
                break;
            case R.id.unlock_btn:
                carKeylessEntrySystem.Unlock();
                break;
            case R.id.lock_x2_btn:
                carKeylessEntrySystem.Lock_x2();
                break;
            case R.id.unlock_x2_btn:
                carKeylessEntrySystem.Unlock_x2();
                break;
        }
    }
}
