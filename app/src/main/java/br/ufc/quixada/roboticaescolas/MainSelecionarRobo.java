package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

//import com.example.enoque_alves.roboticaescolas.R;

public class MainSelecionarRobo extends AppCompatActivity {
    private ImageButton b_braco, b_carro, b_aranha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_robo);
        b_braco = (ImageButton) findViewById(R.id.bBraco);
        b_carro = (ImageButton) findViewById(R.id.bCarro);
        b_aranha = (ImageButton) findViewById(R.id.bAranha);


        b_braco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamar tela de conexão braco
                Intent it = new Intent(MainSelecionarRobo.this, TelaConexaoBraco.class);
                startActivity(it);
            }
        });

        b_carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamar tela de conexão Carro
//                Intent it = new Intent(MainSelecionarRobo.this, telaConfBraco.class);
//                startActivity(it);
//
                Toast.makeText(MainSelecionarRobo.this, "Ainda não implementado!", Toast.LENGTH_SHORT).show();
            }
        });

        b_aranha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chamar tela de conecxão Aranha
                Intent it = new Intent(MainSelecionarRobo.this, telaConexaoAran.class);
                startActivity(it);
            }
        });
    }
}
