package br.ufc.quixada.roboticaescolas;

import android.bluetooth.BluetoothSocket;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.enoque_alves.roboticaescolas.R;

import java.io.OutputStream;

public class joyAranha extends AppCompatActivity {

//    private EnviaDados enviaDados = EnviaDados.getEnviaDados();
//    private OutputStream mmOutputStream;
//    private BluetoothSocket mmSocket;
//    private ConexaoBlue connection = ConexaoBlue.getInstance(null, false);

    private SeekBar sBa, sBb, sBc, sBd, sBe, sBf, sBg, sBh;
    private TextView tVa1, tVa2, tVb1, tVb2, tVc1, tVc2, tVd1, tVd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_aranha);

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
                tVa1.setText("A1: " + seekBar.getProgress());
                //enviaDados.enviarComando(comando);
              //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVa2.setText("A2: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVb2.setText("B2: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVb1.setText("B1: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVc1.setText("C1: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVc2.setText("C2: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVd2.setText("D2: " + seekBar.getProgress());
                //  enviarComando(comando);
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
                //String comando = "!a" + (seekBar.getProgress());
                tVd1.setText("D1: " + seekBar.getProgress());
                //  enviarComando(comando);
            }
        });




    }

 //   public void enviarComando (String comando){
//        char chars [] = comando.toCharArray();
//        char servo = chars[1];
//        int auxBase = 0;
//        String aux = "";
//        for (int j = 2 ; j < chars.length; j++) {
//            aux = aux + chars[j];
//        }
//        int posicaoAtual = Integer.parseInt(aux);
//        if (servo == 'a'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVa1.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'b'){//controlar visao
//            posicaoAtual = (int) (posicaoAtual);
//            tVa2.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'c'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVb1.setText(""+posicaoAtual);
//        }
//        else if (servo == 'd'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVb2.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'e'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVc1.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'f'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVc2.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'g'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVd1.setText(""+ posicaoAtual);
//        }
//        else if (servo == 'h'){
//            posicaoAtual = (int) (posicaoAtual);
//            tVd2.setText(""+ posicaoAtual);
//        }
    //    enviaDados.enviarComando(comando);
//
   // }
}
