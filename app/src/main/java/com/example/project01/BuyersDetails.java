package com.example.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.project01.databinding.ActivityBuyersDetailsBinding;

public class BuyersDetails extends AppCompatActivity {
    ActivityBuyersDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyersDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor edit = sp.edit();
        //edit.putString("Buyers Name",binding.etName.getText().toString());

        binding.btnSubmit.setOnClickListener(v -> {
            edit.putString("Buyers Name",binding.etName.getText().toString());
            edit.putString("Buyers Address",binding.etAddress.getText().toString());
            edit.putString("Buyers Postal Code",binding.etPostalCode.getText().toString());
            edit.putString("Buyers phone",binding.etPhone.getText().toString());
            edit.putString("Card Number",binding.etCreditCardNumber.getText().toString());
            edit.commit();
            Intent intent = new Intent(getBaseContext(),LastPage.class);
            startActivity(intent);
        });

    }
}