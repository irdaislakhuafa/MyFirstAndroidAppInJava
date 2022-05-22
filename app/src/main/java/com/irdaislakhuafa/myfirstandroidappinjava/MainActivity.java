package com.irdaislakhuafa.myfirstandroidappinjava;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showLogs("onCreate");

        // get widget EditText from layout xml
//        Student student = new Student();
//        student.setName((EditText) findViewById(R.id.inputName));
//        student.setNPM((EditText) findViewById(R.id.inputNpm));
//        student.setGender((RadioGroup) findViewById(R.id.inputGender));
//
//        student.getFromLayout();
//        student.getName().setTextSize(25);

        List<String> keys = new ArrayList<String>() {{
            add("inputName");
            add("inputNpm");
            add("inputGender");
            add("inputAngkatan");
            add("inputDateOfBirth");
        }};
        List<String> values = new ArrayList<>();


        EditText inputName = findViewById(R.id.inputName);
        EditText inputNpm = findViewById(R.id.inputNpm);
        RadioGroup inputGender = findViewById(R.id.inputGender);
        Spinner inputAngkatan = findViewById(R.id.inputAngkatan);
        Button inputDateOfBirth = findViewById(R.id.inputDateOfBirth);


        // angkatan
        List<String> listAngkatan = new ArrayList<>();
        int currentYear = new Date().getYear() + 1900;
        for (int i = (currentYear - 4); i <= currentYear; i++) {
            listAngkatan.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAngkatan);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        inputAngkatan.setAdapter(adapter);

        // input date
        inputDateOfBirth.setOnClickListener((v) -> {
            Log.d("MyAppMessage", "Input Date has been clicked");
            Calendar calendar = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (datePicker, year, month, day) -> {
                        inputDateOfBirth.setText(String.format("%s/%s/%s", day, (month + 1), year));
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        // get widget Button from layout xml
        Button sendButton = findViewById(R.id.sendButton);

        // add listener to sendButton
        sendButton.setOnClickListener((view) -> {
                    // check name
                    String name = inputName.getText().toString().trim();
                    if (name.isEmpty()) {
                        inputName.setHint("Nama tidak boleh kosong!");
                        inputName.setText("");
                        return;
                    }
                    values.add(name);

                    // check npm
                    String npm = inputNpm.getText().toString().trim();
                    if (npm.isEmpty()) {
                        inputNpm.setHint("NPM tidak boleh kosong!");
                        inputNpm.setText("");
                        return;
                    }
                    values.add(npm);

                    // gender
                    RadioButton gender = findViewById(inputGender.getCheckedRadioButtonId());
                    values.add(gender.getText().toString());

                    // angkatan
                    String angkatan = String.valueOf(inputAngkatan.getSelectedItem());
                    values.add(angkatan);

                    // tanggal lahir
                    String dateOfBirth = inputDateOfBirth.getText().toString();
                    values.add(dateOfBirth);

                    // skills

                    // create new context (from activity, destination activity)
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    Bundle bundle = new Bundle();

                    // input to bundle
                    for (int i = 0; i < keys.size(); i++) {
                        bundle.putString(keys.get(i), values.get(i));
                    }

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String item = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}