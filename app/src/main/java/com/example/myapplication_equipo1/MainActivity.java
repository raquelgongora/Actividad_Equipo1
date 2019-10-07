package com.example.myapplication_equipo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PULSADO = "pulsado";
    private static final String TEXTO_INTRODUCIDO = "Texto";

    private EditText editText;
    private Button button;
    private TextView textView;

    private boolean pulsado;
    private String textoIntroducido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        restaurarCampos(savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                String texto = editText.getText().toString();
                if (!texto.isEmpty()) {
                    textoIntroducido =
                            editText.getText().toString();
                    pulsado = true;
                    mostrarTextView();
                }
            }
        });

        if (pulsado) {
            mostrarTextView();
        }
    }

    public void mostrarTextView(){
        editText.setText(textoIntroducido);
        editText.setVisibility(View.VISIBLE);
    }

    private void restaurarCampos(Bundle savedInstanceState){

        //Si hay algo en el bundle, es que se ha guardado algo y lo recuperaremos.

        if(savedInstanceState != null) {
            if(savedInstanceState.getBoolean(PULSADO, false)){
                this.pulsado = savedInstanceState.getBoolean(PULSADO);
                this.textoIntroducido =
                        savedInstanceState.getString(TEXTO_INTRODUCIDO, "");
            }

        }
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Metemos en el bundle lo que queremos conservar
        if (pulsado){
            outState.putBoolean(PULSADO, pulsado);
            outState.putString(TEXTO_INTRODUCIDO, textoIntroducido);
        }

    }
}

