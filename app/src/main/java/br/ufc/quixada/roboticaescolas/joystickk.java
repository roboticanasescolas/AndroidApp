package br.ufc.quixada.roboticaescolas;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enoque_alves.roboticaescolas.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class joystickk extends AppCompatActivity {
    private SeekBar garra_bar, base_bar, c_bar, d_bar;
    private OutputStream mmOutputStream;
    private BluetoothSocket mmSocket;
    private boolean gravando = false;
    private ArrayList<String> comandosGravados = new ArrayList<String>();
    private ArrayList<String> comandos = new ArrayList<String>();
    private ArrayList<String> comandosTela = new ArrayList<String>();
    private Button gravar, limpar, play, reset, programar, frenteCosta, posicoes, cronometroPS;
    private ImageButton more_base, more_garra, less_base, less_garra, more_c, more_d, less_c, less_d;
    private ConexaoBlue connection = ConexaoBlue.getInstance(null, false);
    private EnviaDados enviaDados = EnviaDados.getEnviaDados();
    private TextView label_garra, label_base, label_c, label_d, setVisao;
    private int delay = 1000;
    private boolean fCosta = true;
    private boolean running = true;
    private Chronometer cronometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystickk);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        garra_bar = (SeekBar) findViewById(R.id.seekbar_garra);
        base_bar = (SeekBar) findViewById(R.id.seekbar_base);
        c_bar = (SeekBar) findViewById(R.id.seekbar_c);
        d_bar = (SeekBar) findViewById(R.id.seekbar_d);
        play = (Button) findViewById(R.id.butao_play);
        reset = (Button) findViewById(R.id.butao_reset);
        limpar = (Button) findViewById(R.id.butao_limpa);
        gravar = (Button) findViewById(R.id.butao_gravar);
        programar = (Button) findViewById(R.id.programar);
        more_c = (ImageButton) findViewById(R.id.button_more_c);
        more_d = (ImageButton) findViewById(R.id.button_more_d);
        less_c = (ImageButton) findViewById(R.id.button_less_c);
        less_d = (ImageButton) findViewById(R.id.button_less_d);
        more_base = (ImageButton) findViewById(R.id.button_more_base);
        more_garra = (ImageButton) findViewById(R.id.button_more_garra);
        less_garra = (ImageButton) findViewById(R.id.button_less_garra);
        less_base = (ImageButton) findViewById(R.id.button_less_base);
        label_base = (TextView) findViewById(R.id.label_base);
        label_garra = (TextView) findViewById(R.id.label_garra);
        label_c = (TextView) findViewById(R.id.label_c);
        label_d = (TextView) findViewById(R.id.label_d);

        //Botão frente costa
        frenteCosta = (Button) findViewById(R.id.frenteCosta);
        posicoes = (Button) findViewById(R.id.bPosicoes);
        setVisao = (TextView) findViewById(R.id.tVisao);

        //Cronometro
        cronometro = findViewById(R.id.cronometro);
        cronometroPS = (Button) findViewById(R.id.bCronometro);


        label_garra.setText("" + (int) (garra_bar.getProgress()/0.57));
        label_base.setText("" + (int) (base_bar.getProgress()/1.8));
        label_c.setText("" + (int) (c_bar.getProgress()/0.7));
        label_d.setText("" + (int) (d_bar.getProgress()/1.2));

        //play.setVisibility(View.INVISIBLE);
        mmSocket = connection.getConection();

        cronometroPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(running){
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                    running = false;
                    cronometroPS.setText("STOP");
                }else {

                    cronometro.stop();
                    cronometroPS.setText("PLAY");
                    running = true;
                }
            }
        });

        garra_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String comando = "!a" + (seekBar.getProgress()+10);
                enviarComando(comando);
                /*
                 * Valor máximo da seekbar: 57
                 */
            }
        });
        base_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(fCosta == true){
                    String comando = "!b" + (seekBar.getProgress()+10);
                    enviarComando(comando);
                    /*
                        Vamor máximo da seekbar 180
                     */
                }else{
                    int aux = 180 - (seekBar.getProgress());
                    String comando = "!b" + (aux+10);
                    enviarComando(comando);
                }

            }
        });
        c_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){// Altura

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                /*
                Valor máximo da seekbar 70
                 */
                String comando = "!c" + (seekBar.getProgress() + 100);
                enviarComando(comando);

            }
        });
        d_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ //Avanço

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                /*
                Valor máximo da seekbar 60
                 */
                String comando = "!d" + (seekBar.getProgress()+60);
                enviarComando(comando);

            }
        });

        gravar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                gravando = !gravando;
                if (gravando){
                    gravar.setText("PARAR GRAVAÇÃO");
                    Toast.makeText(joystickk.this, "Gravando!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    gravar.setText("GRAVAR");
                    Toast.makeText(joystickk.this, "Fim da gravação!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        frenteCosta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fCosta = !fCosta;
                Log.i("asd", "FrenteCosta = " + fCosta);
                if(fCosta == true){
                    setVisao.setText("Visão Frontal");
                }else{
                    setVisao.setText("Visão Trazeira");
                }
            }
        });

        //Função para chamar tela das pisiçoes dos servos
        posicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String garraT = (String) label_garra.getText();
                String baseT = (String) label_base.getText();
                String alturaT = (String) label_c.getText();
                String avancoT = (String) label_d.getText();

                Toast toast = Toast.makeText(joystickk.this, "Garra (Motor 1): " + garraT +
                        "\nAltura (Motor 2): " + alturaT +
                        "\nAvanço (Motor 3): " + avancoT +
                        "\nBase (Motor 4): " + baseT, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();


//                Intent it = new Intent(joystickk.this, posiServos.class);
//
//                Bundle parametros = new Bundle();
//
//                parametros.putString("teste", "teste");
//                parametros.putString("cGarra", garraT);
//                parametros.putString("cBase", baseT);
//                parametros.putString("cAltura", alturaT);
//                parametros.putString("cAvanco", avancoT);
//
//                it.putExtras(parametros);
//                startActivity(it);
            }
        });

        limpar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                comandosGravados.clear();
                comandos.clear();
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                garra_bar.setProgress(57); //(Auto Lembrete) 57 Valor máximo da garra na seekbar (100 na label, mudado pelo enviar comando)
                base_bar.setProgress(90);  //(Auto Lembrete) 90 Valor médio (máximo 180) da base na seekbar (50 na label, mudado pelo enviar comando)
                c_bar.setProgress(70);     //(Auto Lembrete) 70 Valor máximo da Altura na seekbar (100 na label, mudado pelo enviar comando)
                d_bar.setProgress(30);     //(Auto Lembrete) 30 Valor médio da Altura na seekbar (50 na label, mudado pelo enviar comando)
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!a67");
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!b100");
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!c170");
                    TimeUnit.MILLISECONDS.sleep(300);
                    enviarComando("!d90");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        programar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(joystickk.this, TelaDeProgramacao.class);
                intent.putExtra("comandos", comandosGravados);
                intent.putExtra("comandosTela", comandosTela);
                startActivityForResult(intent, 100);
            }
        });

        play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (gravando) gravando = !gravando;
                enviaDados.enviarVariosComandos(comandosGravados, delay);

            }
        });

        more_c.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                c_bar.setProgress(c_bar.getProgress()+1);
                String comando = "!c" + (c_bar.getProgress()+100);
                enviarComando(comando);
            }
        });
        less_c.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                c_bar.setProgress(c_bar.getProgress()-1);
                String comando = "!c" + (c_bar.getProgress()+100);
                enviarComando(comando);
            }
        });

        more_d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                d_bar.setProgress(d_bar.getProgress()+1);
                String comando = "!d" + (d_bar.getProgress()+60);
                enviarComando(comando);
            }
        });

        less_d.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                d_bar.setProgress(d_bar.getProgress()-1);
                String comando = "!d" + (d_bar.getProgress()+60);
                enviarComando(comando);
            }
        });
        less_base.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(fCosta == true) {
                    base_bar.setProgress(base_bar.getProgress() - 1);
                    String comando = "!b" + (base_bar.getProgress() + 10);
                    enviarComando(comando);
                }else if(fCosta == false){
                    base_bar.setProgress(base_bar.getProgress() - 1);
                    int aux = 180 - (base_bar.getProgress());
                    aux--;
                    String comando = "!b" + (aux + 10);
                    enviarComando(comando);
                }
            }
        });

        more_base.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(fCosta == true) {
                    base_bar.setProgress(base_bar.getProgress() + 1);
                    String comando = "!b" + (base_bar.getProgress() + 10);
                    enviarComando(comando);
                }else if(fCosta == false){
                    base_bar.setProgress(base_bar.getProgress() + 1);
                    int aux = 180 - (base_bar.getProgress());
                    aux++;
                    String comando = "!b" + (aux + 10);
                    enviarComando(comando);
                }
            }
        });
        more_garra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                garra_bar.setProgress(garra_bar.getProgress()+1);
                String comando = "!a" + (garra_bar.getProgress()+10);
                enviarComando(comando);
            }
        });

        less_garra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                garra_bar.setProgress(garra_bar.getProgress()-1);
                String comando = "!a" + (garra_bar.getProgress()+10);
                enviarComando(comando);
            }
        });



        try{
            mmOutputStream = mmSocket.getOutputStream();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == joystickk.this.RESULT_OK && requestCode == 100) {
            comandosGravados = data.getStringArrayListExtra("comandos");
            comandosTela = data.getStringArrayListExtra("comandosTela");
            delay = data.getIntExtra("delay", 1000);
            //Toast.makeText(ReceivingData.this,"Mensagem Recebida da SegundaActivity:\n" + resposta, Toast.LENGTH_LONG).show();
        }
    }

    public void enviarComando (String comando){
//        try {
//            mmOutputStream.write(comando.getBytes());
            //Toast.makeText(joystickk.this, "enviado : " + comando, Toast.LENGTH_SHORT).show();
            if (gravando){
                comandosGravados.add(comando);
                char chars [] = comando.toCharArray();
                char servo = chars[1];
                String aux = "";
                String comandoTela = "";
                for (int j = 2 ; j < chars.length; j++) {
                    aux = aux + chars[j];
                }
                int posicaoAtual = Integer.parseInt(aux);
                if (servo == 'a'){
                    comandoTela = "Abre/fecha  ";
                    posicaoAtual = (int) ((posicaoAtual-10)/0.57);
                    Log.i("asd", "valor posicao: " + posicaoAtual);
                    label_garra.setText(""+ posicaoAtual);
                }
                else if (servo == 'b'){
                    comandoTela = "Girar  ";
                    posicaoAtual = (int) ((posicaoAtual-10)/1.8);
                    label_base.setText(""+ posicaoAtual);
                }
                else if (servo == 'c'){
                    comandoTela = "Avanca/recua  ";
                    posicaoAtual = (int) ((posicaoAtual-100)/0.7);
                    label_c.setText(""+posicaoAtual);
                }
                else if (servo == 'd'){
                    comandoTela = "Sobe/desce  ";
                    posicaoAtual = (int) ((posicaoAtual-60)/0.6);
                    label_d.setText(""+ posicaoAtual);
                }
                comandoTela += ""+posicaoAtual;
                comandosTela.add(comandoTela);
            }

        char chars [] = comando.toCharArray();
        char servo = chars[1];
        int auxBase = 0;
        String aux = "";
        for (int j = 2 ; j < chars.length; j++) {
            aux = aux + chars[j];
        }
        int posicaoAtual = Integer.parseInt(aux);
        if (servo == 'a'){
            posicaoAtual = (int) ((posicaoAtual-10)/0.57);
            label_garra.setText(""+ posicaoAtual);
        }
        else if (servo == 'b'){//controlar visao
            if(fCosta == true){
                posicaoAtual = (int) ((posicaoAtual-10)/1.8);
            }else{
                auxBase = 180 - (posicaoAtual-10);
                posicaoAtual = (int) (auxBase/1.8);
            }

            label_base.setText(""+ posicaoAtual);
        }
        else if (servo == 'c'){
            posicaoAtual = (int) ((posicaoAtual-100)/0.7);
            label_c.setText(""+posicaoAtual);
        }
        else if (servo == 'd'){
            posicaoAtual = (int) ((posicaoAtual-60)/0.6);
            label_d.setText(""+ posicaoAtual);
        }
            enviaDados.enviarComando(comando);

    }
}