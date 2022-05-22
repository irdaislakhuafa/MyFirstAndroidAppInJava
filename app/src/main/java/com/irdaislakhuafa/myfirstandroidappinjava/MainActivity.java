package com.irdaislakhuafa.myfirstandroidappinjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLogs("onCreate");

        // get widget EditText from layout xml
        EditText inputSomething = (EditText) findViewById(R.id.inputSomething);
        // get widget Button from layout xml
        Button sendButton = (Button) findViewById(R.id.sendButton);

        // add listener to sendButton
        sendButton.setOnClickListener((view) -> {
                    String text = inputSomething.getText().toString().trim();

                    // create new context
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("stringInputSomething", text);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLogs("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLogs("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLogs("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLogs("onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLogs("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLogs("onDestroy");
    }

    private static void showLogs(String value) {
        Log.d("MyAppMessage", "Running method " + value.trim() + "(1412190011)");
    }
}