package com.set.one;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class TaskEight extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_eight);
        final Theme thm = getTheme();
        final Resources res = getResources();
        TextView output = findViewById(R.id.textView1);
        String strJson = "{\"Employee\":[{\"id\":\"01\",\"name\":\"Gokul\",\"salary\":\"500000\"},{\"id\":\"02\",\"name\":\"krishna\",\"salary\":\"500000\"},{\"id\":\"03\",\"name\":\"Sathish\",\"salary\":\"600000\"}]}";
        StringBuilder data = new StringBuilder();
        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
//Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");
//Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = Integer.parseInt(jsonObject.optString("id"));
                String name = jsonObject.optString("name");
                float salary = Float.parseFloat(jsonObject.optString("salary"));
                data = data.append("Node").append(i).append(": \n id=").append(id).append(" \n Name=").append(name).append(" \n Salary=").append(salary).append("\n ");
            }
            output.setText(data.toString());
            switch (res.getConfiguration().uiMode &
                    Configuration.UI_MODE_NIGHT_MASK) {
                case Configuration.UI_MODE_NIGHT_YES:
                    output.setTextColor(res.getColor(R.color.white, thm));
                    break;

                case Configuration.UI_MODE_NIGHT_NO:
                    output.setTextColor(res.getColor(R.color.black, thm));
                    break;

                case Configuration.UI_MODE_NIGHT_UNDEFINED:
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}