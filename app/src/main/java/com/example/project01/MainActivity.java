package com.example.project01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.phone_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getBaseContext(),PhonesList.class);
        switch(item.getItemId()){
            case R.id.IPhone:
                intent.putExtra("Brand","Apple");
                startActivity(intent);
                return true;
            case R.id.Samsung:
                intent.putExtra("Brand","Samsung");
                startActivity(intent);
                return true;
            case R.id.GooglePixel:
                intent.putExtra("Brand","Google");
                startActivity(intent);
                return true;
            case R.id.Oppo:
                intent.putExtra("Brand","Oppo");
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}