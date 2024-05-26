package com.set.one;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskFive extends Activity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bp, bm, bmu, bdo, bd, be, bclr;
    EditText tx;
    float val1 = 0, val2 = 0, res = 0;
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_five);
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        bp = findViewById(R.id.plus);
        bm = findViewById(R.id.minus);
        bmu = findViewById(R.id.multi);
        bdo = findViewById(R.id.dot);
        bd = findViewById(R.id.divide);
        be = findViewById(R.id.equal);
        bclr = findViewById(R.id.clear);
        tx = findViewById(R.id.txt);
    }

    public void show(View v) {
        Button b = (Button) v;
        String set = b.getText().toString();
        tx.append(set);
    }

    public void calc(View v) {
        Button b = (Button) v;
        op = b.getText().toString();
        val1 = Float.parseFloat(tx.getText().toString());
        tx.setText("");
    }

    public void equal(View v) {
        val2 = Float.parseFloat(tx.getText().toString());
        switch (op) {
            case "+":
                res = val1 + val2;
                break;
            case "-":
                res = val1 - val2;
                break;
            case "*":
                res = val1 * val2;
                break;
            case "/":
                res = val1 / val2;
                break;
            default:
        }
        tx.setText(String.valueOf(res));
    }
}