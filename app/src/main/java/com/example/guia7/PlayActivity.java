package com.example.guia7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    public SharedPreferences sharedPreferences;
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tvUser = findViewById(R.id.tvUser);
        addToTextView();
    }

    private void addToTextView(){
        sharedPreferences = getSharedPreferences("configuration", MODE_PRIVATE);
        if(sharedPreferences != null){
            tvUser.setText(sharedPreferences.getString("USER", ""));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}