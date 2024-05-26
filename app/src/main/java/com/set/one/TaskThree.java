package com.set.one;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TaskThree extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_three);
        EditText t2 = findViewById(R.id.name);
        TextView t1 = findViewById(R.id.textView2);
        Button b1 = findViewById(R.id.btn1), b2 = findViewById(R.id.btn2), b3 = findViewById(R.id.btn3), b4 = findViewById(R.id.btn4);
        b1.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), "Hai Guys!!!", Toast.LENGTH_SHORT).show();
        });

        b2.setOnLongClickListener(v -> {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), "Hai Fellas!!!", Toast.LENGTH_SHORT).show();
            return false;
        });

        b3.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), "You tapped me!", Toast.LENGTH_SHORT).show();
        });

        b3.setOnLongClickListener(v -> {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), "You tapped me for so long!!", Toast.LENGTH_LONG).show();
            return false;
        });

        b4.setOnClickListener(v -> {
            // TODO Auto-generated method stub
            final String name = t2.getText().toString();
            t1.setText(name.isEmpty() ? getString(R.string.task_three) : name);
        });
    }
}