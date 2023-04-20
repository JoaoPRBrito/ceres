package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin); //localizando o login
                TextView tSenha = (TextView) findViewById(R.id.tSenha); //localizando a senha
                String login = tLogin.getText().toString(); // armazendando o login em uma variavel
                String senha = tSenha.getText().toString(); // armazenando a senha em uma variavel
                if(login.equals("joao")&&senha.equals("lindo")){ //comparando o digitado com o banco de dados
                    Intent intent = new Intent(MainActivity.this, main_menu.class);
                    startActivity(intent);
                }else{
                    alert("LOGIN INCORRETO");
                }
            }
        });
        TextView recText = findViewById(R.id.recSenha);
        SpannableString recuSenha = new SpannableString("Esqueceu sua senha?");// instância de SpannableString, que é uma string que permite a adição de spans
        ClickableSpan recSenha = new ClickableSpan() { // instância de ClickableSpan e sobrescreva o método onClick()
            @Override
            public void onClick(@NonNull View view) {
                //Toast.makeText(MainActivity.this, "solicitada senha", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, forgetPassword.class);
                startActivity(intent);
            }
        };
        recuSenha.setSpan(recSenha, 0, recuSenha.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // Adicione o ClickableSpan ao SpannableString usando o método setSpan()
        recText.setText(recuSenha);
        recText.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
