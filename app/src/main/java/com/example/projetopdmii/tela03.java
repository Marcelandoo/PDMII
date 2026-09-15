package com.example.projetopdmii;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class tela03 extends AppCompatActivity {

    private ViewPager2 viewpager;
    private ArrayList<Slide> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewpager = findViewById(R.id.viewpager);
        lista = new ArrayList<Slide>();
        lista.add(new Slide("Slide 1", R.drawable.jeff, "text"));
        lista.add(new Slide("Slide 2", R.drawable.jim, "text"));
        lista.add(new Slide("Slide 3", R.drawable.kate, "text"));
        lista.add(new Slide("Slide 4", R.drawable.rosalia, "text"));
        lista.add(new Slide("Slide 5", R.drawable.sufjan, "text"));
        SlideAdapter adapter = new SlideAdapter(lista);
        viewpager.setAdapter(adapter);
    }
}