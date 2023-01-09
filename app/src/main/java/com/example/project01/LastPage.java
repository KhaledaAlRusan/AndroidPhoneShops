package com.example.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.project01.databinding.ActivityLastPageBinding;

public class LastPage extends AppCompatActivity {
    ActivityLastPageBinding binding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLastPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        binding.tvCustomerInformation.setText("Name: "+sp.getString("Buyers Name","No Name")+"\n"
                +"Address: "+ sp.getString("Buyers Address","No Address")+"\n"
                +"Postal Code: "+sp.getString("Buyers Postal Code","No Postal Code")+"\n"
                +"Phone Number: "+sp.getString("Buyers phone","No Phone Number"));
        binding.tvPaymentInformation.setText("Card Number: "+sp.getString("Card Number","No Card Number"));
        binding.tvProductInformation.setText("Brand: " + sp.getString("Brand","No Brand")+"\n"
                +"Name: "+sp.getString("Name", "No Name")+"\n"
                +"Price: "+ sp.getString("Price", "No Price")+"\n"
                +"Storage: "+sp.getString("Storage", "No Storage")+"\n"
                +"Color: "+sp.getString("Color","No Color"));
    }
}

