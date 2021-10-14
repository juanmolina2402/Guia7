package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgPlay = findViewById(R.id.imvPlay);
        ImageView imgScore = findViewById(R.id.imvScore);
        ImageView imgHelp = findViewById(R.id.imvHelp);
        ImageView imgConfig = findViewById(R.id.imvConfig);
        ImageView imgDatos = findViewById(R.id.imvDatos);

        imgPlay.setOnClickListener(aux -> {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
        });

        imgConfig.setOnClickListener(aux -> {
            startActivity(new Intent(MainActivity.this, ConfigActivity.class));
        });

        imgDatos.setOnClickListener(aux -> {
            startActivity(new Intent(MainActivity.this, DatosActivity.class));
        });
    }
}