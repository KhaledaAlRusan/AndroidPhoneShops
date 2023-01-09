package com.example.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.project01.databinding.ActivityPhoneDetailsBinding;

public class PhoneDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityPhoneDetailsBinding binding;
    String[] Colors;
    SharedPreferences sp;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneDetailsBinding.inflate(getLayoutInflater());
        Colors = getIntent().getStringArrayExtra("Color");
        setContentView(binding.getRoot());
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        edit = sp.edit();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Colors);
        binding.spinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.btnNext.setOnClickListener(v -> {
            int radioId = binding.radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(radioId);
            edit.putString("Storage",radioButton.getText().toString());
            Intent intent = new Intent(getBaseContext(),BuyersDetails.class);
            edit.apply();
            startActivity(intent);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        edit.putString("Color",Colors[position]);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}