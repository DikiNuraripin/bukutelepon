package com.example.bukutelepon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvnya;
    List<Teman>dataTemannya;
    RecyclerView.LayoutManager layoutManager;
    ApiInterpace apiInterpace;
    TemanAdafter adafternya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvnya=(RecyclerView)findViewById(R.id.rv_home);
        layoutManager=new LinearLayoutManager(this);
        rvnya.setLayoutManager(layoutManager);
        apiInterpace=Apiclient.ambilTeman().create(ApiInterpace.class);
        Call<List<Teman>> call=apiInterpace.getTeman();
        call.enqueue(new Callback<List<Teman>>() {
            @Override
            public void onResponse(Call<List<Teman>> call, Response<List<Teman>> response) {
                dataTemannya=response.body();
                adafternya=new TemanAdafter(dataTemannya,MainActivity.this);
                rvnya.setAdapter(adafternya);
            }

            @Override
            public void onFailure(Call<List<Teman>> call, Throwable t) {

            }
        });
    }
}