package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

//import com.example.enoque_alves.roboticaescolas.R;

public class configuracaoBraco extends AppCompatActivity {
    private Button confirmar;
    private EditText eTGarra, eTAltura, eTAvanco, eTBase;
    private int valorGarra, valorAltura, valorAvanco, valorBase;
    private int vG, vAl, vAv, vB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao_braco);

        Intent it = getIntent();
        vG = it.getIntExtra("garra", 0);
        vAl = it.getIntExtra("altura", 0);
        vAv = it.getIntExtra("avanco", 0);
        vB = it.getIntExtra("base", 0);

        confirmar = (Button) findViewById(R.id.bPIConf);

        eTGarra = (EditText) findViewById(R.id.editTextGarra);
        eTAltura = (EditText) findViewById(R.id.editTextAltura);
        eTAvanco = (EditText) findViewById(R.id.editTextAvanco);
        eTBase = (EditText) findViewById(R.id.editTextBase);


        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((eTGarra.getText().length() > 0) && (eTAltura.getText().length() > 0) && (eTAvanco.getText().length() > 0) && (eTBase.getText().length() > 0)){
                    //Valor Garra
                    valorGarra = Integer.parseInt(eTGarra.getText().toString());
                    if (valorGarra < 0) valorGarra = 0;
                    if (valorGarra > 100) valorGarra = 100;
                    vG = (int) (valorGarra * 0.57);
                    //Valor Altura
                    valorAltura = Integer.parseInt(eTAltura.getText().toString());
                    if (valorAltura < 0) valorAltura = 0;
                    if (valorAltura> 100) valorAltura = 100;
                    vAl = (int) (valorAltura * 0.7);
                    //Valor Avanço
                    valorAvanco = Integer.parseInt(eTAvanco.getText().toString());
                    if (valorAvanco < 0) valorAvanco = 0;
                    if (valorAvanco > 100) valorAvanco = 100;
                    vAv = (int) (valorAvanco * 0.6);
                    //Valor Base
                    valorBase = Integer.parseInt(eTBase.getText().toString());
                    if (valorBase < 0) valorBase = 0;
                    if (valorBase > 100) valorBase = 100;
                    vB = (int) (valorBase * 1.8);

                    Intent devolve = new Intent();
                    devolve.putExtra("garra", vG);
                    devolve.putExtra("altura", vAl);
                    devolve.putExtra("avanco", vAv);
                    devolve.putExtra("base", vB);
                    setResult(RESULT_OK, devolve);
                    finish();

                }else{
                    Toast.makeText(configuracaoBraco.this, "Há campos não preenchidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
