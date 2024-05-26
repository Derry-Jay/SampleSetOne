package com.set.one;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TaskSeven extends Activity {
    File f;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_seven);
        try {
            txt = findViewById(R.id.txt);
            File sdCard = Environment.getExternalStorageDirectory(), dir = new File(sdCard.getAbsolutePath() + "/AndroidLab/");
            if (!dir.exists() && dir.mkdirs()) System.out.println("Directory Created");
            f = new File(dir, "text.txt");
            if (!f.exists() && f.createNewFile())
                System.out.println("File Created");
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Line: " + e.getStackTrace()[0].getLineNumber(), Toast.LENGTH_SHORT).show();
        }
    }

    public void read(View view) {
        try {
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(f));
            while (br.readLine() != null) {
                String line = br.readLine();
                text = text.append(line).append('\n');
                br.close();
            }
            txt.setText(text.toString());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage() + "Line: " + e.getStackTrace()[0].getLineNumber(), Toast.LENGTH_SHORT).show();
        }
    }

    public void save(View view) throws IOException {
        FileOutputStream os = new FileOutputStream(f);
        String data = txt.getText().toString();
        os.write(data.getBytes());
        os.close();
        Toast.makeText(this, "File Saved Sucessfully", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        txt.setText("");
    }
}