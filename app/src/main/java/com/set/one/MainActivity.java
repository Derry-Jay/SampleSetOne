package com.set.one;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Theme thm = getTheme();
        final Resources res = getResources();
        TextView t1 = findViewById(R.id.textView1), t2 = findViewById(R.id.textView2), t3 = findViewById(R.id.textView3), t4 = findViewById(R.id.textView4), t5 = findViewById(R.id.textView5), t6 = findViewById(R.id.textView6), t7 = findViewById(R.id.textView7), t8 = findViewById(R.id.textView8);
        t1.setBackgroundColor(res.getColor(com.google.android.material.R.color.design_default_color_primary, thm));
        t1.setTextColor(res.getColor(R.color.white, thm));
        t1.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskTwo.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t2.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskThree.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t3.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskFour.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t4.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskOne.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t5.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskFive.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t6.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskSix.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t7.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskSeven.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });

        t8.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            v.getContext().startActivity(new Intent(this, TaskEight.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });
    }

}
