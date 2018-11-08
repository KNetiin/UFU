package br.com.ufu_cm.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.*;

public class TelaInicial extends AppCompatActivity
{
    private Button cadastrar, fazer_login;
    private final Intent[] intecao = new Intent[1];

    private SQLiteDatabase con;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        //Ação do botão "Cadastrar"
        cadastrar = (Button) findViewById(R.id.btnCadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intecao[0] = new Intent(TelaInicial.this, TelaCadastro.class);
                startActivity(intecao[0]);
            }
        });

        //Ação do botão "Fazer Login"
        fazer_login = (Button) findViewById(R.id.btnFazerLogin);
        fazer_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intecao[0] = new Intent(TelaInicial.this, TelaLogin.class);
                startActivity(intecao[0]);
            }
        });
    }
}
