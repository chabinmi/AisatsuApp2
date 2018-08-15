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

        TextView textView = (TextView) findViewById(R.id.textView);
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
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            textView.setText("おはよう");
                            Log.d("UI-PARTS", "おはよう、" + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            //textView.setText("こんにちは");
                            Log.d("UI-PARTS", "こんにちは、" + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        } else if ((hourOfDay >= 18 && hourOfDay <= 23) || hourOfDay <= 1) {
                            //textView.setText("こんばんわ");
                            Log.d("UI-PARTS", "こんばんわ、" + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        } else {
                            //textView.setText("エラー");
                            Log.d("UI-PARTS", "エラー、" + String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

}
