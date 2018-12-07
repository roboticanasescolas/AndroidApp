/*
Ainda não implementado
 */

package br.ufc.quixada.roboticaescolas;

import android.bluetooth.BluetoothSocket;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.OutputStream;

//import com.example.enoque_alves.roboticaescolas.R;

public class joyEasyAranha extends AppCompatActivity {

    private EnviaDados enviaDados = EnviaDados.getEnviaDados();
    private OutputStream mmOutputStream;
    private BluetoothSocket mmSocket;
    private ConexaoBlue connection = ConexaoBlue.getInstance(null, false);

    private Button frente, direita, esquerda, tras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_easy_aranha);


        frente = (Button) findViewById(R.id.bAFrente);
        direita = (Button) findViewById(R.id.bADireita);
        esquerda = (Button) findViewById(R.id.bAEsquerda);
        tras = (Button) findViewById(R.id.bATras);

        frente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        direita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        esquerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void enviarComando (String comando){
        char chars [] = comando.toCharArray();
        char servo = chars[1];
        int auxBase = 0;
        String aux = "";
        String comando2 = "";
//        for (int j = 2 ; j < chars.length; j++) {
//            aux = aux + chars[j];
//        }
//        int posicaoAtual = Integer.parseInt(aux);
//        if (servo == 'a'){
//            //tVa1.setText("A1: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.5);
//            int valor2 = (int) valor + 20;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 V: " + comando2);
//        }
//        else if (servo == 'b'){
//            //tVa2.setText("A2: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.4);
//            int valor2 = (int) valor + 10;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 H: " + comando2);
//        }
//        else if (servo == 'c'){
//            //tVc1.setText("C1: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.5);
//            int valor2 = (int) valor + 20;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 V: " + comando2);
//        }
//        else if (servo == 'd'){
//            //tVc2.setText("C2: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.4);
//            int valor2 = (int) valor + 10;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 H: " + comando2);
//        }
//        else if (servo == 'e'){
//            //tVd1.setText("D1: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.5);
//            int valor2 = (int) valor + 20;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 V: " + comando2);
//        }
//        else if (servo == 'f'){
//            //tVd2.setText("D2: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.4);
//            int valor2 = (int) valor + 10;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 H: " + comando2);
//        }
//        else if (servo == 'g'){
//            //tVb1.setText("B1: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.5);
//            int valor2 = (int) valor + 20;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 V: " + comando2);
//        }
//        else if (servo == 'h'){
//            //tVb2.setText("B2: " + aux);
//            int aux2 = Integer.parseInt(aux);
//            float valor = (float) (aux2 * 1.4);
//            int valor2 = (int) valor + 10;
//            comando2 = ("!" + servo + valor2);
//            Log.i("asd", "Comando 2 H: " + comando2);
//        }
        enviaDados.enviarComando(comando2);

    }
}
