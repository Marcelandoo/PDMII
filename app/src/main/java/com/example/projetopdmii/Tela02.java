package com.example.projetopdmii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, OnClickListener, Runnable, SeekBar.OnSeekBarChangeListener {
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;
    private int musica, indiceLista;
    private ArrayList <playlist> lista;
    private CardView card1, card2, card3, card4, card5;
    private TextView textoMusicaSelecionada, textoMusicaTocada;
    private ImageView imgPreview, imgNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        handler = new Handler();

        musica = R.raw.forrodofarol_quincasmoreira;
        lista = new ArrayList<playlist>();
        lista.add(new playlist(" Forro do Farol", R.raw.forrodofarol_quincasmoreira));
        lista.add(new playlist(" I Don't Know Why", R.raw.idontknowwhy_alexrobinson));
        lista.add(new playlist(" Sly Sky", R.raw.slysky_telecasted));
        lista.add(new playlist(" We Alrigth", R.raw.wealright_patrickpatrikios));
        lista.add(new playlist(" Wildfire", R.raw.wildfire_jessievilla));

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = findViewById(R.id.card5);
        card5.setOnClickListener(this);
        textoMusicaSelecionada = findViewById(R.id.textView);
        textoMusicaTocada = findViewById(R.id.textView2);

        imgPreview = findViewById(R.id.imageView10);
        imgPreview.setOnClickListener(this);
        imgNext = findViewById(R.id.imageView8);
        imgNext.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        if(id == R.id.id001){
            play();
        }
        if(id == R.id.id003){
            stop();
        }
        if(id == R.id.id002){
            if(mediaPlayer !=null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        handler.removeCallbacks(this);
        mediaPlayer.release();
        this.mediaPlayer = null;
        seekBar.setProgress(0);
    }

    @Override
    public void onClick(View view) {
        if(view == card1){
            indiceLista = 0;
            textoMusicaSelecionada.setText("Música selecionada:" + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }
        if(view == card2){
            indiceLista = 1;
            textoMusicaSelecionada.setText("Música selecionada:" + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }
        if(view == card3){
            indiceLista = 2;
            textoMusicaSelecionada.setText("Música selecionada:" + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }
        if(view == card4){
            indiceLista = 3;
            textoMusicaSelecionada.setText("Música selecionada:" + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }
        if(view == card5){
            indiceLista = 4;
            textoMusicaSelecionada.setText("Música selecionada:" + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();
        }
        if(view == imgPreview) {
            indiceLista--;
            if (indiceLista < 0){
                indiceLista = lista.size()-1;
            }
            textoMusicaSelecionada.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            stop();
            play();
        }
        if(view == imgNext){
            indiceLista++;
            if(indiceLista >= lista.size()){
                indiceLista = 0;
            }
            textoMusicaSelecionada.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            stop();
            play();
        }
    }

    @Override
    public void run() {
        if(mediaPlayer != null) {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this, 1000);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }

    public void play(){
        if(mediaPlayer == null){
            mediaPlayer= MediaPlayer.create(this, lista.get(indiceLista).getMusica());
            textoMusicaTocada.setText("Música tocando: " + lista.get(indiceLista).getNome());
            mediaPlayer.setOnCompletionListener(this);
            seekBar.setMax(mediaPlayer.getDuration());
            handler.post(this);
            mediaPlayer.start();
        }else if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
    }

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}