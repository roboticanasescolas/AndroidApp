package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.example.enoque_alves.roboticaescolas.R;


public class telaConexaoAran extends AppCompatActivity {

    private Button bPlay;
    private Button bPlayEasy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conexao_aran);

        bPlay = (Button) findViewById(R.id.bPlayAran);
        bPlayEasy = (Button) findViewById(R.id.bPlayAraEasy);


        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle parametros = new Bundle();
                parametros.putString("key", "aranha");
                Intent it = new Intent(telaConexaoAran.this, MainActivity.class);
                it.putExtras(parametros);
                startActivity(it);
            }
        });

        bPlayEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(telaConexaoAran.this, "Ainda não implementado!", Toast.LENGTH_SHORT).show();
//                Bundle parametros = new Bundle();
//                parametros.putString("key", "aranhaEasy");
//                Intent it = new Intent(telaConexaoAran.this, MainActivity.class);
//                it.putExtras(parametros);
//                startActivity(it);
            }
        });
    }
}
