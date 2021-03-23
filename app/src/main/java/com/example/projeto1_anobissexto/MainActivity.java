package com.example.projeto1_anobissexto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ano_local, resultado;
    private Button btCalcular, btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ano_local = (TextView) findViewById(R.id.ano);
        resultado = (TextView) findViewById(R.id.resultado);

        btCalcular = (Button)findViewById(R.id.calcular);
        btLimpar  = (Button)findViewById(R.id.limpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularanobissexto(view);
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar(view);
            }
        });
    }

    public void calcularanobissexto(View view) {
        try {
                String anotxt = ano_local.getText().toString();
                int anoint = Integer.parseInt(anotxt);
                String rFinal;

                if (anoint % 400 == 0) {
                    // (ano + " é bissexto. ");
                    rFinal = anotxt + " é bissexto.";
                    // se o ano para menor que 400
                } else if ((anoint % 4 == 0) && (anoint % 100 != 0)) {
                    rFinal = anotxt + " é bissexto. ";
                } else {
                    rFinal = anotxt + " não é bissexto. ";
                }

                //resultado.setText(rFinal);

                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                intent.putExtra("resultado", rFinal);
                startActivity(intent);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resultado.setText("Por favor inserir um ano válido.");
        }

    }

    public void limpar(View view) {
        ano_local.setText("");
        resultado.setText("");
    }

    /*
    public void enviar(View view) {
        Intent intent = new Intent(getApplicationContext(), EnviarActivity.class);
        intent.putExtra("titulo", "TESTE TITULO");//((EditText)findViewById(R.id.idTitulo)).getText().toString());
        intent.putExtra("conteudo", "TESTE CONTEUDO"); //((EditText)findViewById(R.id.idConteudo)).getText().toString());
        startActivity(intent);
    }*/
}