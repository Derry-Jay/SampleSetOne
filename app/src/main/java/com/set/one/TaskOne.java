package com.set.one;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.widget.TextView;

public class TaskOne extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_one);
        final Theme thm = getTheme();
        final Resources res = getResources();
        TextView t = findViewById(R.id.textview);
        t.setText("hi take care");
        t.setBackgroundColor(res.getColor(R.color.paragraph, thm));
        t.setTextColor(res.getColor(R.color.black, thm));
    }
}