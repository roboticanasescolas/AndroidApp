package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enoque_alves.roboticaescolas.R;

public class TempoCronometro extends AppCompatActivity {
    private TextView tempoDeco, tempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_cronometro);

        tempo = (TextView) findViewById(R.id.tempo);

        Intent dadosRecebidos = getIntent();

        Bundle parametros = dadosRecebidos.getExtras();

        String time = parametros.getString("tempo");

        tempo.setText(time + "s");
    }
}
