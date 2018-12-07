package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.example.enoque_alves.roboticaescolas.R;


public class confguracaoAranha extends AppCompatActivity {

    private Button confirmarCA;
    private EditText eTA1, eTA2, eTB1, eTB2, eTC1, eTC2, eTD1, eTD2;
    private int valorA1, valorA2, valorB1, valorB2, valorC1, valorC2, valorD1, valorD2;
    private int vA1, vA2, vB1, vB2, vC1, vC2, vD1, vD2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confguracao_aranha);

        Intent it = getIntent();
        vA1 = it.getIntExtra("A1", 0);
        vA2 = it.getIntExtra("A2", 0);
        vB1 = it.getIntExtra("B1", 0);
        vB2 = it.getIntExtra("B2", 0);
        vC1 = it.getIntExtra("C1", 0);
        vC2 = it.getIntExtra("C2", 0);
        vD1 = it.getIntExtra("D1", 0);
        vD2 = it.getIntExtra("D2", 0);

        confirmarCA = (Button) findViewById(R.id.bConfirmar);

        eTA1 = (EditText) findViewById(R.id.eTA1);
        eTA2 = (EditText) findViewById(R.id.eTA2);
        eTB1 = (EditText) findViewById(R.id.eTB1);
        eTB2 = (EditText) findViewById(R.id.eTB2);
        eTC1 = (EditText) findViewById(R.id.eTC1);
        eTC2 = (EditText) findViewById(R.id.eTC2);
        eTD1 = (EditText) findViewById(R.id.eTD1);
        eTD2 = (EditText) findViewById(R.id.eTD2);

        confirmarCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((eTA1.getText().length() > 0) && (eTA2.getText().length() > 0) &&
                        (eTB1.getText().length() > 0) && (eTB2.getText().length() > 0) &&
                        (eTC1.getText().length() > 0) && (eTC2.getText().length() > 0) &&
                        (eTD1.getText().length() > 0) && (eTD2.getText().length() > 0)){
                    //Valor A1
                    valorA1 = Integer.parseInt(eTA1.getText().toString());
                    if (valorA1 < 0) valorA1 = 0;
                    if (valorA1 > 100) valorA1 = 100;
                    vA1 = (int) (valorA1);
                    //Valor A2
                    valorA2 = Integer.parseInt(eTA2.getText().toString());
                    if (valorA2 < 0) valorA2 = 0;
                    if (valorA2 > 100) valorA2 = 100;
                    vA2 = (int) (valorA2);
                    //Valor B1
                    valorB1 = Integer.parseInt(eTB1.getText().toString());
                    if (valorB1 < 0) valorB1 = 0;
                    if (valorB1 > 100) valorB1 = 100;
                    vB1 = (int) (valorB1);
                    //Valor B2
                    valorB2 = Integer.parseInt(eTB2.getText().toString());
                    if (valorB2 < 0) valorB2 = 0;
                    if (valorB2 > 100) valorB2 = 100;
                    vB2 = (int) (valorB2);
                    //Valor C1
                    valorC1 = Integer.parseInt(eTC1.getText().toString());
                    if (valorC1 < 0) valorC1 = 0;
                    if (valorC1 > 100) valorC1 = 100;
                    vC1 = (int) (valorC1);
                    //Valor C2
                    valorC2 = Integer.parseInt(eTC2.getText().toString());
                    if (valorC2 < 0) valorC2 = 0;
                    if (valorC2 > 100) valorC2 = 100;
                    vC2 = (int) (valorC2);
                    //Valor D1
                    valorD1 = Integer.parseInt(eTD1.getText().toString());
                    if (valorD1 < 0) valorD1 = 0;
                    if (valorD1 > 100) valorD1 = 100;
                    vD1 = (int) (valorD1);
                    //Valor D2
                    valorD2 = Integer.parseInt(eTD2.getText().toString());
                    if (valorD2 < 0) valorD2 = 0;
                    if (valorD2 > 100) valorD2 = 100;
                    vD2 = (int) (valorD2);

                    Intent devolve = new Intent();
                    devolve.putExtra("A1", vA1);
                    devolve.putExtra("A2", vA2);
                    devolve.putExtra("B1", vB1);
                    devolve.putExtra("B2", vB2);
                    devolve.putExtra("C1", vC1);
                    devolve.putExtra("C2", vC2);
                    devolve.putExtra("D1", vD1);
                    devolve.putExtra("D2", vD2);
                    setResult(RESULT_OK, devolve);
                    finish();


                }else{
                    Toast.makeText(confguracaoAranha.this, "Há campos não preenchidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
