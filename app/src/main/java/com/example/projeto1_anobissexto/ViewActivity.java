package com.example.projeto1_anobissexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    private TextView resultado2, nome_local, resultado3;
    private Button btCompartilhar;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        resultado3 = (TextView) findViewById(R.id.resultado3);

        resultado2 = (TextView) findViewById(R.id.resultado2);
        resultado = getIntent().getStringExtra("resultado");
        resultado2.setText(resultado);

        nome_local = (TextView) findViewById(R.id.nome);

        btCompartilhar  = (Button)findViewById(R.id.compartilhar);

        btCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartilhar(view);
            }
        });
    }

    public void compartilhar(View view) {

        if (nome_local.length() <= 0) {
            resultado3.setText("Por favor informe um nome!");
            return;
        } else {
            resultado3.setText("Ok!");

            String subject = "Ano Bissexto";
            String mensagem = nome_local.getText() + ", o ano " + resultado;
            String mensagem2 = nome_local.getText() + " que o ano " + resultado;
            resultado2.setText(mensagem);

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(intent.EXTRA_SUBJECT, subject);
            intent.putExtra(intent.EXTRA_TEXT, mensagem);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Compartilhar com " + mensagem2));
        }
    }
}