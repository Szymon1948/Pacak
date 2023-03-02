package com.example.pacak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ZegarSzachowyActivity extends AppCompatActivity {

    Button button;
    TextView textView2;
    TextView textView4;
    Zegar zegar1;
    Zegar zegar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zegar_szachowy);
        button = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView4);
        zegar1 = new Zegar(true,textView2);
        zegar2 = new Zegar(false,textView4);
        zegar1.startTimer();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zegar1.isRunning()){
                    zegar1.stopTimer();
                    zegar2.startTimer();
                }
                else{
                    zegar1.startTimer();
                    zegar2.stopTimer();
                }
            }
        });
    }
}