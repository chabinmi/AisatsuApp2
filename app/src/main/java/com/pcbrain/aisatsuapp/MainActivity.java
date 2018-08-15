package com.pcbrain.aisatsuapp;
//package jp.techacademy.taro.kirameki.ui;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import com.pcbrain.aisatsuapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String aisatsu = null;

                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            aisatsu = "おはよう";
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            aisatsu = "こんにちは";
                        } else if ((hourOfDay >= 18 && hourOfDay <= 23) || hourOfDay <= 1) {
                            aisatsu = "こんばんわ";
                        } else {
                            aisatsu = "エラー";
                        }
                        textView.setText(aisatsu);
                        Log.d("UI-PARTS", aisatsu + "、" + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

}
