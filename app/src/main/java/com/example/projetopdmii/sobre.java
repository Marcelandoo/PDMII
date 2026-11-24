package com.example.projetopdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class sobre extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ArrayList<Pergunta> lista_perguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.idtela01) {
            drawerLayout.closeDrawers();
            startActivity(new Intent(sobre.this, TelaHome.class));
            return true;
        }
        if (menuItem.getItemId() == R.id.idtela02) {
            startActivity(new Intent(sobre.this, Tela02.class));
            return true;
        }
        if (menuItem.getItemId() == R.id.idtela03) {
            startActivity(new Intent(sobre.this, tela03.class));
            return false;
        }
        if(menuItem.getItemId() == R.id.quiz){
            startActivity(new Intent(sobre.this, tela03.class));
            return true;
        }
        if(menuItem.getItemId() == R.id.sobre){
            drawerLayout.closeDrawers();
            return false;
        }
        return false;
    }
}