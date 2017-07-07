package com.cristian_sedano.sharedpreferencecontacts;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etPhone;
    private Button buttonSave, buttonLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);

        buttonSave = (Button) findViewById(R.id.btnSave);
        buttonLoad = (Button) findViewById(R.id.btnRetrieve);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(name, phone);
                editor.commit();
                Toast.makeText(MainActivity.this, "Your Contact Has Been Save", Toast.LENGTH_SHORT).show();
            }
        });
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preference = getSharedPreferences("agenda", Context.MODE_PRIVATE);
                String name = etName.getText().toString();
                String possiblePhone = preference.getString(name, "");

                if (possiblePhone.length()==0){
                    Toast.makeText(MainActivity.this, "Not Found, Try Again", Toast.LENGTH_SHORT).show();
                }else {
                    etPhone.setText(possiblePhone);
                }

            }
        });

    }


}
