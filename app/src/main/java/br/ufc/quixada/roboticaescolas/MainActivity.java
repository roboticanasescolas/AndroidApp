package br.ufc.quixada.roboticaescolas;


import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

//import com.example.enoque_alves.roboticaescolas.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter BA;
    private  String nomeDispositivo = "Motoggg"; //Mude o valor para o nome do seu módulo Bluetooth.
    private final int REQUEST_ENABLE_BT = 1; // Código padrão para o requerimento em tempo de execuxão.
    private ConexaoBlue conexao;
    private IntentFilter it = null;
    private final String[] PermissionsLocation = {Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION}; //Array de permissões relacionadas ao Bluetooth no Android 6.0 ou maior
    private final int ResquestLocationId = 0; // Código padrão para o requerimento em tempo de execução.
    private List<String> textos;
    private Set<BluetoothDevice> pairedDevices;
    private ListView listaDeDispositivos;
    private ArrayAdapter<String> adapter;
    private String robo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dispositivos);
        //Log.i("asd", "qwe");

        Bundle extra = getIntent().getExtras();
        robo = extra.getString("key");
        Log.i("asd", "Key: " + robo);
        //Toast.makeText(MainActivity.this, "-> " + robo, Toast.LENGTH_SHORT).show();

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        pairedDevices = mBluetoothAdapter.getBondedDevices();

        textos = new ArrayList<String>();
        for (BluetoothDevice device : pairedDevices) {
            textos.add(device.getName() + "\n" + device.getAddress());
        }

        listaDeDispositivos = (ListView) findViewById(R.id.id_lista);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, textos);
        listaDeDispositivos.setAdapter(adapter);

        listaDeDispositivos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = listaDeDispositivos.getItemAtPosition(position);
                String str=(String)o;//As you are using Default String Adapter
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                String a[] = str.split("\n");
                nomeDispositivo = a[0];
                Log.i("asd", "Nome = " + nomeDispositivo);
                try{
                    Log.i("asd", "deu bom");
                    Toast.makeText(MainActivity.this, "Conectando...", Toast.LENGTH_SHORT).show();
                    for (BluetoothDevice device : pairedDevices) {
                        // Add the name and address to an array adapter to show in a ListView
                        if (nomeDispositivo.equals(device.getName())) {
                            try {
                                conexao = ConexaoBlue.getInstance(device, true);
                                if (conexao.isConnected()) {
                                    Toast.makeText(MainActivity.this, "Conectado ao " + device.getName(), Toast.LENGTH_SHORT).show();
                                    if (robo.equals("braco")){
                                        Intent i = new Intent(MainActivity.this, joystickk.class);
                                        startActivity(i);
                                    }else if (robo.equals("aranha")){
                                        Intent i = new Intent(MainActivity.this, joyAranha.class);
                                        startActivity(i);
                                    }
//                                    else if (robo.equals("carro")){
//                                        Intent i = new Intent(MainActivity.this, joyCarro.class);
//                                        startActivity(i);
//                                    }
                                }
                                else
                                    Toast.makeText(MainActivity.this, "Dispositivo fora de alcance", Toast.LENGTH_SHORT).show();
                            }
                            catch (Exception e){
                                Log.i("asd", "e");
                            }
                            break;
                        }
                    }
                    //}

                }catch (Exception e) {
                    Log.i("asd", e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        BA = BluetoothAdapter.getDefaultAdapter();
        BtEnable();
        }

    private void changeActivity() {

        Intent i = new Intent(this,ReceivingData.class);
        startActivity(i);
    }

    public void BtEnable(){
        //liga o bluetooth
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, REQUEST_ENABLE_BT);
            Toast.makeText(MainActivity.this, "Bluetooth Ligado", Toast.LENGTH_SHORT).show();
        } else {
            lookFor();
        }
        // Essa if em especial, verifica se a versão Android é 6.0 ou maior, pois caso seja, uma permissão para localização, além das relacionadas ao Bluetooth, sao necessárias.
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(PermissionsLocation,ResquestLocationId);
            }
        }
    }

    protected void lookFor() { // Procura por dispositivos
        if(BA.startDiscovery()){}
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == MainActivity.this.RESULT_OK && requestCode == REQUEST_ENABLE_BT) {
            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            pairedDevices = mBluetoothAdapter.getBondedDevices();
            for (BluetoothDevice device : pairedDevices) {
                textos.add(device.getName() + "\n" + device.getAddress());
            }
            listaDeDispositivos.setAdapter(adapter);
            Log.i("asd", "passou");
        }
    }

}