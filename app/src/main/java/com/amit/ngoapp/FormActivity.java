package com.amit.ngoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class FormActivity extends AppCompatActivity {

    EditText nameInput, contactInput, cityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);

        nameInput = findViewById(R.id.nameInput);
        contactInput = findViewById(R.id.contactInput);
        cityInput = findViewById(R.id.cityInput);
    }

    public void submitForm(View view) {
        String name = nameInput.getText().toString();
        String contact = contactInput.getText().toString();
        String city = cityInput.getText().toString();

        if(name.isEmpty() || contact.isEmpty() || city.isEmpty()) {
            Toast.makeText(this,"Please fill all fields!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thank you " + name + " for joining!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}