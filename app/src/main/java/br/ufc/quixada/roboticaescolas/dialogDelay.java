package br.ufc.quixada.roboticaescolas;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.enoque_alves.roboticaescolas.R;

public class dialogDelay extends AppCompatDialogFragment {
    private EditText delay;
    private dialogDelayListener listener;

    // https://www.youtube.com/watch?v=ARezg1D9Zd0&t=408s

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog_delay, null);

        builder.setView(view)
                .setTitle("Atraso")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String pegardelay = delay.getText().toString();
                        listener.applyTexts(pegardelay);
                    }
                });

        delay = view.findViewById(R.id.edit_delay);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (dialogDelayListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "devo implementar dialogDelayListener");
        }

    }

    public interface dialogDelayListener{
        void applyTexts(String delay);
    }
}
