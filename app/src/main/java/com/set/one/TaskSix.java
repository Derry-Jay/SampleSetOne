package com.set.one;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class TaskSix extends Activity {
    Handler hand = new Handler();
    //    Button clickMe;
    TextView timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_six);
        timer = findViewById(R.id.timer);
        String zero = "10";
        timer.setText(zero);
        hand.postDelayed(run, 1000);
    }

    public void updateTime() {
        timer.setText(String.valueOf(Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0) {
            Intent browserIntent =
                    new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.au_url)));
            startActivity(browserIntent);
//            Intent browserIntent =
//                    new Intent(getApplicationContext(), SecondActivity.class);
        } else {
            hand.postDelayed(run, 1000);
        }
    }

    Runnable run = this::updateTime;


}