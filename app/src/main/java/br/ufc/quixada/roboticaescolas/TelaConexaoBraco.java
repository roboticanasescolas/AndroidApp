package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.example.enoque_alves.roboticaescolas.R;

public class TelaConexaoBraco extends AppCompatActivity {
    private Button b_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conexao_braco);

        b_play = (Button) findViewById(R.id.confBracoPlay);


        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chamar Conexao
                Bundle parametros = new Bundle();
                parametros.putString("key", "braco");
                Intent it = new Intent(TelaConexaoBraco.this, MainActivity.class);
                it.putExtras(parametros);
                startActivity(it);
            }
        });

    }
}
