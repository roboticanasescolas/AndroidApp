package br.ufc.quixada.roboticaescolas;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

//import com.example.enoque_alves.roboticaescolas.R;

import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class joyAranha extends AppCompatActivity {

    private EnviaDados enviaDados = EnviaDados.getEnviaDados();
    private OutputStream mmOutputStream;
    private BluetoothSocket mmSocket;
    private ConexaoBlue connection = ConexaoBlue.getInstance(null, false);

    private SeekBar sBa, sBb, sBc, sBd, sBe, sBf, sBg, sBh;
    private TextView tVa1, tVa2, tVb1, tVb2, tVc1, tVc2, tVd1, tVd2;
    private Button reset;
    private ImageButton confgurarPI;
    private int pIa, pIb, pIc, pId, pIe, pIf, pIg, pIh, maxH, maxV, minH, minV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_aranha);

        maxH = 170;
        minH = 20;
        maxV = 150;
        minV = 10;

        pIa = 50;
        pIb = 50;
        pIc = 50;
        pId = 50;
        pIe = 50;
        pIf = 50;
        pIg = 50;
        pIh = 50;

        sBa = (SeekBar) findViewById(R.id.seekBar_a1);
        sBb = (SeekBar) findViewById(R.id.seekBar_a2);
        sBc = (SeekBar) findViewById(R.id.seekBar_b2);
        sBd = (SeekBar) findViewById(R.id.seekBar_b1);
        sBe = (SeekBar) findViewById(R.id.seekBar_c1);
        sBf = (SeekBar) findViewById(R.id.seekBar_c2);
        sBg = (SeekBar) findViewById(R.id.seekBar_d2);
        sBh = (SeekBar) findViewById(R.id.seekBar_d1);

        tVa1 = (TextView) findViewById(R.id.tVa1);
        tVa2 = (TextView) findViewById(R.id.tVa2);
        tVb1 = (TextView) findViewById(R.id.tVb1);
        tVb2 = (TextView) findViewById(R.id.tVb2);
        tVc1 = (TextView) findViewById(R.id.tVc1);
        tVc2 = (TextView) findViewById(R.id.tVc2);
        tVd1 = (TextView) findViewById(R.id.tVd1);
        tVd2 = (TextView) findViewById(R.id.tVd2);

        tVa1.setText("A1: " + pIa);
        tVa2.setText("A2: " + pIb);
        tVc1.setText("C1: " + pIc);
        tVc2.setText("C2: " + pId);
        tVb1.setText("B1: " + pIe);
        tVb2.setText("B2: " + pIf);
        tVd1.setText("D1: " + pIg);
        tVd2.setText("D2: " + pIh);

        sBa.setProgress(pIa);
        sBb.setProgress(pIb);
        sBc.setProgress(pIc);
        sBd.setProgress(pId);
        sBe.setProgress(pIe);
        sBf.setProgress(pIf);
        sBg.setProgress(pIg);
        sBh.setProgress(pIh);

        reset = (Button) findViewById(R.id.bReset);
        confgurarPI = (ImageButton) findViewById(R.id.bConfAra);

        confgurarPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(joyAranha.this, confguracaoAranha.class);
                intent.putExtra("A1", pIa);
                intent.putExtra("A2", pIb);
                intent.putExtra("B2", pIc);
                intent.putExtra("B1", pId);
                intent.putExtra("C1", pIe);
                intent.putExtra("C2", pIf);
                intent.putExtra("D2", pIg);
                intent.putExtra("D1", pIh);
                startActivityForResult(intent, 100);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* A sequencia de cada valor é diferente por causa da configuração do programa no arduino
                    verifica-se que a seekbar A pega o valor A, mas ja na seekbar C pega o valor de E,
                    tomar cuidado com essa diferença de nome.
                */
                sBa.setProgress(pIa);
                sBb.setProgress(pIb);
                sBc.setProgress(pIc);
                sBd.setProgress(pId);
                sBe.setProgress(pIe);
                sBf.setProgress(pIf);
                sBg.setProgress(pIg);
                sBh.setProgress(pIh);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!a" + pIa);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!b" + pIb);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!c" + pIe);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!d" + pIf);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!e" + pIh);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!f" + pIg);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!g" + pId);
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!h" + pIc);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        sBa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!a" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!b" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!h" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!g" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBe.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!c" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBf.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!d" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!f" + (seekBar.getProgress());
                enviarComando(comando);
            }
        });
        sBh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //int teste = 70 + (int) ;
                String comando = "!e" + seekBar.getProgress();
                enviarComando(comando);
            }
        });
    }

   public void enviarComando (String comando){
        char chars [] = comando.toCharArray();
        char servo = chars[1];
        int auxBase = 0;
        String aux = "";
        String comando2 = "";
        for (int j = 2 ; j < chars.length; j++) {
            aux = aux + chars[j];
        }
        int posicaoAtual = Integer.parseInt(aux);
        if (servo == 'a'){
            tVa1.setText("A1: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.5);
            int valor2 = (int) valor + 20;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 V: " + comando2);
        }
        else if (servo == 'b'){
            tVa2.setText("A2: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.4);
            int valor2 = (int) valor + 10;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 H: " + comando2);
        }
        else if (servo == 'c'){
            tVc1.setText("C1: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.5);
            int valor2 = (int) valor + 20;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 V: " + comando2);
        }
        else if (servo == 'd'){
            tVc2.setText("C2: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.4);
            int valor2 = (int) valor + 10;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 H: " + comando2);
        }
        else if (servo == 'e'){
            tVd1.setText("D1: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.5);
            int valor2 = (int) valor + 20;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 V: " + comando2);
        }
        else if (servo == 'f'){
            tVd2.setText("D2: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.4);
            int valor2 = (int) valor + 10;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 H: " + comando2);
        }
        else if (servo == 'g'){
            tVb1.setText("B1: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.5);
            int valor2 = (int) valor + 20;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 V: " + comando2);
        }
        else if (servo == 'h'){
            tVb2.setText("B2: " + aux);
            int aux2 = Integer.parseInt(aux);
            float valor = (float) (aux2 * 1.4);
            int valor2 = (int) valor + 10;
            comando2 = ("!" + servo + valor2);
            Log.i("asd", "Comando 2 H: " + comando2);
        }
        enviaDados.enviarComando(comando2);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == joyAranha.this.RESULT_OK && requestCode == 100){
            pIa = data.getIntExtra("A1", 0);
            pIb = data.getIntExtra("A2", 0);
            pIc = data.getIntExtra("B2", 0);
            pId = data.getIntExtra("B1", 0);
            pIe = data.getIntExtra("C1", 0);
            pIf = data.getIntExtra("C2", 0);
            pIg = data.getIntExtra("D2", 0);
            pIh = data.getIntExtra("D1", 0);
        }
    }
}

