package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.enoque_alves.roboticaescolas.R;

public class posiServos extends AppCompatActivity {

    private TextView garra, base, altura, avanco;
  //  private Button start, stop;
   // private Chronometer cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posi_servos);

        garra = (TextView) findViewById(R.id.garraT);
        altura = (TextView) findViewById(R.id.alturaT);
        avanco = (TextView) findViewById(R.id.avancoT);
        base = (TextView) findViewById(R.id.baseT);

//        start = (Button) findViewById(R.id.bPlay);
//        stop = (Button) findViewById(R.id.bStop);
//        cronometro = (Chronometer) findViewById(R.id.cronometro);

        Intent dadosRecebidos = getIntent();

        Bundle parametros = dadosRecebidos.getExtras();

        if(parametros != null) {

            String garraT = parametros.getString("cGarra");
            String baseT = parametros.getString("cBase");
            String alturaT = parametros.getString("cAltura");
            String avancoT = parametros.getString("cAvanco");

            garra.setText("Garra (Motor 1): " + garraT);

            altura.setText("Altura (Motor 2): " + alturaT);

            avanco.setText("Avanço (Motor 3): " + avancoT);

            base.setText("Base (Motor 4): " + baseT);
        }
    }
}

