package com.example.guia7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;

public class ConfigActivity extends AppCompatActivity {
    private EditText edtUser;
    private Button btnSave;
    public static String FILE_CONF = "configuration";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        edtUser = findViewById(R.id.edtUser);
        btnSave = findViewById(R.id.btnSave);
        addToEditText();

        btnSave.setOnClickListener( aux -> {
            addUser();
        });
    }

    private void addToEditText(){
        sharedPreferences = getSharedPreferences(FILE_CONF, MODE_PRIVATE);
        if(sharedPreferences != null){
            edtUser.setText(sharedPreferences.getString("USER", ""));
        }
    }

    private void addUser() {
        if(!edtUser.getText().toString().isEmpty()) {
            int numero = (int) (Math.random() * 10) + 1;
            sharedPreferences = getSharedPreferences(FILE_CONF, MODE_PRIVATE);
            SharedPreferences.Editor editorConfig = sharedPreferences.edit();
            editorConfig.putString("USER", edtUser.getText().toString());
            editorConfig.putString("NUMBER", String.valueOf(numero));
            editorConfig.putString("SCORE", "0");
            editorConfig.commit();
            Toast.makeText(ConfigActivity.this, "El usuario se guardó con éxito", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(ConfigActivity.this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show();
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