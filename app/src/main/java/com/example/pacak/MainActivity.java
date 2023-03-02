package com.example.pacak;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int sekundy =0;
    TextView textView;
    Button button;
    boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.czasTextView);
        button = findViewById(R.id.button);
        running = true;
        final Handler handler = new Handler();
        //Pozwoli na wywoływanie czegoś z opóźnieniem
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running){
                    sekundy++;
                }
                textView.setText(Integer.toString(sekundy));
                //Co ile milisekund to wywołam

                handler.postDelayed(this::run, 1000);
            }

        });
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (running) {
                            running = false;
                            button.setText("Start");
                            //Jeśli false naciśnij start
                        } else {
                            running = true;
                            button.setText("Pauza");
                            //Jeśli aplikacja jest uruchomiona, wtedy pauza;
                        }
                    }
                }
        );
    };
}