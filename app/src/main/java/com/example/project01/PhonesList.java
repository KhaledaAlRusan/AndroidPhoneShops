package com.example.project01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.ArrayList;

public class PhonesList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Phones> phones = new ArrayList<>();
    public static final String GOOGLE_KEY = "Google",SAMSUNG_KEY = "Samsung",APPLE_KEY = "Apple",OPPO_KEY = "Oppo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones_list);


        PhonesAdapter adapter = new PhonesAdapter(filterPhones(phones), new PhonesAdapter.onUserClickListener() {
            @Override
            public void onUserClicked(Phones phone) {
                Intent intent = new Intent(getBaseContext(),PhoneDetails.class);
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("Name",phone.getName());
                edit.putString("Price",String.valueOf(phone.getPrice()));
                edit.putString("Brand",phone.getBrand());
                edit.apply();
                intent.putExtra("Color",phone.getColors());
                startActivity(intent);

            }


        });
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addPhones(){
        Phones Apple14 = new Phones("IPhone14","Apple",new String[]{"Black","White","Blue"},1000,R.drawable.iphone,new int[]{64,128,256});
        Phones Apple14pro = new Phones("IPhone14 Pro","Apple",new String[]{"Black","White","Blue"},1500,R.drawable.iphone,new int[]{64,128,256});
        Phones Apple14proMax = new Phones("IPhone14 Pro Max","Apple",new String[]{"Black","White","Blue"},2000,R.drawable.iphone,new int[]{64,128,256});
        Phones SamsungS22 = new Phones("Samsung S22","Samsung",new String[]{"Black","White","Blue"},1000,R.drawable.samsung,new int[]{64,128,256});
        Phones SamsungS22Plus = new Phones("Samsung S22 Plus","Samsung",new String[]{"Black","White","Blue"},1500,R.drawable.samsung,new int[]{64,128,256});
        Phones SamsungS22Ultra = new Phones("Samsung S22 Ultra","Samsung",new String[]{"Black","White","Blue"},2000,R.drawable.samsung,new int[]{64,128,256});
        Phones GoogePixel7 = new Phones("google pixel 7","Google",new String[]{"Black","White","Blue"},1000,R.drawable.google,new int[]{64,128,256});
        Phones GoogePixel7pro = new Phones("google pixel 7 pro","Google",new String[]{"Black","White","Blue"},1500,R.drawable.google,new int[]{64,128,256});
        Phones GoogePixel7ultra = new Phones("google pixel 7 Ultra","Google",new String[]{"Black","White","Blue"},2000,R.drawable.google,new int[]{64,128,256});
        Phones OppoF17 = new Phones("oppo f17","Oppo",new String[]{"Black","White","Blue"},1000,R.drawable.oppo,new int[]{64,128,256});
        Phones OppoF17pro = new Phones("oppo f17 pro","Oppo",new String[]{"Black","White","Blue"},1500,R.drawable.oppo,new int[]{64,128,256});
        Phones OppoF17Ultra = new Phones("oppo f17 Ultra","Oppo",new String[]{"Black","White","Blue"},2000,R.drawable.oppo,new int[]{64,128,256});
        Phones Samsung = new Phones("oppo f17 Ultra","Oppo",new String[]{"Black","White","Blue"},2000,R.drawable.oppo,new int[]{64,128,256});

        phones.add(Apple14);
        phones.add(Apple14pro);
        phones.add(Apple14proMax);
        phones.add(SamsungS22);
        phones.add(SamsungS22Plus);
        phones.add(SamsungS22Ultra);
        phones.add(GoogePixel7);
        phones.add(GoogePixel7pro);
        phones.add(GoogePixel7ultra);
        phones.add(OppoF17);
        phones.add(OppoF17pro);
        phones.add(OppoF17Ultra);


    }




    @Nullable
    private ArrayList<Phones> filterPhones(ArrayList<Phones> phones){
        addPhones();
        ArrayList<Phones> filteredPhone = new ArrayList<>();
        switch (getIntent().getStringExtra("Brand")){
            case APPLE_KEY:
                for(Phones phone : phones){
                    if(phone.getBrand().equals(APPLE_KEY)){
                        filteredPhone.add(phone);
                    }
                }
                return filteredPhone;
            case SAMSUNG_KEY:
                for(Phones phone : phones){
                    if(phone.getBrand().equals(SAMSUNG_KEY)){
                        filteredPhone.add(phone);
                    }
                }
                return filteredPhone;
            case OPPO_KEY:
                for(Phones phone : phones){
                    if(phone.getBrand().equals(OPPO_KEY)){
                        filteredPhone.add(phone);
                    }
                }
                return filteredPhone;
            case GOOGLE_KEY:
                for(Phones phone : phones){
                    if(phone.getBrand().equals(GOOGLE_KEY)){
                        filteredPhone.add(phone);
                    }
                }
                return filteredPhone;
            default:return null;
        }
    }

}