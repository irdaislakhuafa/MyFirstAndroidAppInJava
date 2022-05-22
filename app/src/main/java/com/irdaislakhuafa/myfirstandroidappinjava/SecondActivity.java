package com.irdaislakhuafa.myfirstandroidappinjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MyAppMessage", "onCreate: Second Activity has been created");

        // set layout view activity_second.xml
        setContentView(R.layout.activity_second);

        // get element from second_activity.xml with id showInputSomething
        TextView showInputSomething = (TextView) findViewById(R.id.showInputSomething);

        // get string inputSomething from Intent
        String inputString = getIntent().getExtras().getString("stringInputSomething");

        // set text to TextView
        showInputSomething.setText(inputString);
    }
}
