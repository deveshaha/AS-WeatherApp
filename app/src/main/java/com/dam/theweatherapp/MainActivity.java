package com.dam.theweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etLat, etLon;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLat = findViewById(R.id.etLatitud);
        etLon = findViewById(R.id.etLongitud);
        btn = findViewById(R.id.btnConsultar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultWeather();
            }
        });

        consultWeather();
    }

    private void consultWeather() {
        Double Latitud = Double.valueOf(etLat.getText().toString());
        Double Longitud = Double.valueOf(etLon.getText().toString());
        Intent i = new Intent(MainActivity.this, WeatherActivity.class);
        i.putExtra("Latitud", Latitud);
        i.putExtra("Longitud", Longitud);
        startActivity(i);
    }

}