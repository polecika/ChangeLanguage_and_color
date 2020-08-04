package com.example.changelanguage_and_color;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerChangeLanguage;
    private Spinner spinnerChangeColor;
    private Button okBtn;
    private static int selectedTheme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerChangeLanguage = findViewById(R.id.spinner);
                spinnerChangeColor = findViewById(R.id.spinnerColor);
                int selected = spinnerChangeLanguage.getSelectedItemPosition();
                selectedTheme = spinnerChangeColor.getSelectedItemPosition();
                if (selected == 0) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    Toast.makeText(MainActivity.this, R.string.tostLanguage, Toast.LENGTH_SHORT).show();
                } else if (selected == 1) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    Toast.makeText(MainActivity.this, R.string.tostLanguage, Toast.LENGTH_SHORT).show();
                }
               Utils.changeToTheme(MainActivity.this, selectedTheme);
            }
        });
    }
}