package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class forgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        Button btEnviar = (Button) findViewById(R.id.enviar);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView rNome = (TextView) findViewById(R.id.recNome);
                TextView rEmail = (TextView) findViewById(R.id.recEmail);
                TextView rTelefone = (TextView) findViewById(R.id.recTelefone);

                String nome = rNome.getText().toString();
                String email = rEmail.getText().toString();
                String telefone = rTelefone.getText().toString();

                alert("Solicitação enviada!");


            }
        });


    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
