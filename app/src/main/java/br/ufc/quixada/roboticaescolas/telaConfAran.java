package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.enoque_alves.roboticaescolas.R;

public class telaConfAran extends AppCompatActivity {

    private Button bPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conf_aran);

        bPlay = (Button) findViewById(R.id.bPlayAran);


        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle parametros = new Bundle();
                parametros.putString("key", "aranha");
                Intent it = new Intent(telaConfAran.this, MainActivity.class);
                it.putExtras(parametros);
                startActivity(it);
            }
        });
    }
}
