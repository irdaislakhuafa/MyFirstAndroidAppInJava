package com.irdaislakhuafa.myfirstandroidappinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLogs("onCreate");
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