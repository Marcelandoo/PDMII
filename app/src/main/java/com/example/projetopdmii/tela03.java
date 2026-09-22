package com.example.projetopdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class tela03 extends AppCompatActivity implements Runnable, View.OnClickListener {

    private ViewPager2 viewpager;
    private ArrayList<Slide> lista;
    private TextView textoScroll;
    private Button btn;

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

        textoScroll = findViewById(R.id.textView7);
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(this);

        viewpager = findViewById(R.id.viewpager);
        lista = new ArrayList<Slide>();
        lista.add(new Slide("Jeff Buckley", R.drawable.jeff, "text"));
        lista.add(new Slide("Jim Morrison", R.drawable.jim, "text"));
        lista.add(new Slide("Kate Bush", R.drawable.kate, "text"));
        lista.add(new Slide("Rosalía", R.drawable.rosalia, "text"));
        lista.add(new Slide("Sufjan Stevens", R.drawable.sufjan, "text"));

        SlideAdapter adapter = new SlideAdapter(lista);
        viewpager.setAdapter(adapter);

        textoScroll.setText("A música é uma forma de expressão capaz de transmitir sentimentos, contar histórias e marcar diferentes gerações. Alguns artistas se destacam justamente por desenvolverem estilos próprios e deixarem uma influência duradoura na cultura. Entre eles estão Jeff Buckley, Jim Morrison, Kate Bush, Rosalía e Sufjan Stevens, artistas de épocas e estilos diferentes, mas unidos pela criatividade e pela capacidade de transformar suas experiências em música.\n" +
                "\n" +
                "Jeff Buckley foi um cantor, compositor e guitarrista norte-americano conhecido por sua voz marcante e por suas interpretações intensas. Seu único álbum de estúdio lançado em vida, Grace, tornou-se uma obra muito admirada, especialmente pela combinação de rock, folk e elementos experimentais. Buckley também ficou conhecido por sua interpretação de “Hallelujah”, de Leonard Cohen. Apesar de sua carreira ter sido curta, sua música influenciou diversos artistas.\n" +
                "\n" +
                "Jim Morrison foi o vocalista e principal figura pública da banda The Doors, formada nos Estados Unidos na década de 1960. Sua presença de palco, suas letras poéticas e seu interesse por temas como liberdade, morte, amor e existência ajudaram a definir a identidade da banda. Canções como “Light My Fire”, “The End” e “Riders on the Storm” fizeram parte da história do rock. Morrison morreu em 1971, aos 27 anos, tornando-se uma figura marcante da cultura do rock.\n" +
                "\n" +
                "Kate Bush é uma cantora, compositora, produtora e instrumentista britânica reconhecida por sua originalidade. Desde o início de sua carreira, apresentou uma mistura incomum de música pop, rock, música clássica e elementos experimentais. A canção “Wuthering Heights”, inspirada no romance de Emily Brontë, tornou-se um de seus maiores sucessos. Seu trabalho também é conhecido pela teatralidade e pela exploração de diferentes personagens e narrativas.\n" +
                "\n" +
                "Rosalía, cantora e compositora espanhola, ganhou destaque internacional ao combinar elementos do flamenco com pop, música urbana e sons experimentais. Seu álbum El Mal Querer apresentou uma proposta conceitual inspirada na literatura medieval e ajudou a ampliar sua projeção internacional. Posteriormente, em Motomami, Rosalía explorou ainda mais diferentes gêneros e influências, mostrando uma abordagem aberta à experimentação e à mistura de tradições com sons contemporâneos.\n" +
                "\n" +
                "Sufjan Stevens é um cantor, compositor e multi-instrumentista norte-americano conhecido pela variedade de estilos presentes em sua obra. Suas músicas podem incorporar elementos de folk, música eletrônica, indie rock e música clássica. Seus álbuns frequentemente apresentam temas pessoais, familiares e religiosos. Um de seus trabalhos mais conhecidos é Carrie & Lowell, marcado por uma abordagem intimista e reflexiva.\n" +
                "\n" +
                "Embora Jeff Buckley, Jim Morrison, Kate Bush, Rosalía e Sufjan Stevens tenham estilos e trajetórias diferentes, todos demonstram como a música pode ultrapassar os limites de um gênero específico. Cada um encontrou maneiras próprias de transformar emoções, experiências e referências culturais em obras artísticas. Por isso, seus trabalhos continuam despertando o interesse de diferentes públicos e mostrando a diversidade da música ao longo das gerações.");
    }

    @Override
    public void run() {

    }

    @Override
    public void onClick(View view) {
        if(view == btn){
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}