package com.set.one;

import android.app.Activity;
import android.os.Bundle;

import androidx.cardview.widget.CardView;

public class TaskTwo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_two);
        CardView cv = findViewById(R.id.layout1);
        cv.setMaxCardElevation(8);
    }
}