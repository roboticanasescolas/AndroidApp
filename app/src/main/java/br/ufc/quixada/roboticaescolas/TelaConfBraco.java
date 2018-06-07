package br.ufc.quixada.roboticaescolas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.enoque_alves.roboticaescolas.R;

public class TelaConfBraco extends AppCompatActivity {
    private Button b_play, b_config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conf_braco);

        b_play = (Button) findViewById(R.id.confBracoPlay);
        b_config = (Button) findViewById(R.id.confBracoServos);


        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chamar Joystickk
                Intent it = new Intent(TelaConfBraco.this, MainActivity.class);
                startActivity(it);
            }
        });

        b_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chamar tela para parametrização dos servos
                Toast.makeText(TelaConfBraco.this, "Ainda não implementado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
