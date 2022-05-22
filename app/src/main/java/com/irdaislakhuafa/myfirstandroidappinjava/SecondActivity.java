package com.irdaislakhuafa.myfirstandroidappinjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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

        // name
        TextView showName = findViewById(R.id.showName);
        String name = getIntent().getExtras().getString("inputName").toUpperCase();
        showName.setText(name);

        // npm
        TextView showNpm = findViewById(R.id.showNpm);
        String npm = getIntent().getExtras().getString("inputNpm").toUpperCase();
        showNpm.setText(npm);

        // get back button
        Button backButton = findViewById(R.id.backButton);
        // add listener to MainActivity
        backButton.setOnClickListener((view) -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
