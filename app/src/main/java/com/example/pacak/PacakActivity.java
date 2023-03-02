package com.example.pacak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PacakActivity extends AppCompatActivity {

    private int czas=10;
   private TextView textViewczas;
   private TextView textViewPunkty;

    private ArrayList<ImageView> imageViews= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacak);
        textViewczas = findViewById(R.id.textView);
        textViewPunkty = findViewById(R.id.textView3);
        ImageView imageView = findViewById(R.id.imageView);
        imageViews.add(imageView);
        imageViews.add(findViewById(R.id.imageView2));
        imageViews.add(findViewById(R.id.imageView3));
        imageViews.add(findViewById(R.id.imageView4));
        pokazJedenObraz();
        zliczaj();
    }
    private void zliczaj(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(czas>0) {
                    czas--;
                    textViewczas.setText("Czas: "+Integer.toString(czas));
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    private void pokazJedenObraz(){
        for(ImageView obraz:imageViews){
            obraz.setVisibility(View.INVISIBLE);
        }
        int wylosowana = (int) (Math.random()*imageViews.size());
        imageViews.get(wylosowana).setVisibility(View.VISIBLE);
    }
}