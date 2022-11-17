package com.fernandobravo.cifradov1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txt1 = findViewById(R.id.editTextTextMultiLine3);
        final EditText txt2 = findViewById(R.id.editTextTextMultiLine4);

        final Button boton1 = findViewById(R.id.button);
        final Button boton2 = findViewById(R.id.button2);
        final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";




        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = String.valueOf(txt1.getText());

                txt2.setText(cifrar(letras,texto));
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = String.valueOf(txt2.getText());

                txt1.setText(descifrar(letras,texto));
            }
        });
    }

    public static String cifrar(String letras, String texto){
        String textoCodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if(pos == -1){
                textoCodificado += caracter;
            }else{
                textoCodificado += letras.charAt( (pos + 3) % letras.length() );
            }

        }

        return textoCodificado;
    }
    public static String descifrar(String letras, String texto){
        String textoDescodificado = "";

        texto = texto.toUpperCase();

        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);

            int pos = letras.indexOf(caracter);

            if(pos == -1){
                textoDescodificado += caracter;
            }else{
                if(pos - 3 < 0){
                    textoDescodificado += letras.charAt( letras.length() + (pos - 3) );
                }else{
                    textoDescodificado += letras.charAt( (pos - 3) % letras.length() );
                }
            }

        }

        return textoDescodificado;
    }
}