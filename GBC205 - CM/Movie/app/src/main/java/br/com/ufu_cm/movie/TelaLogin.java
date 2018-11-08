package br.com.ufu_cm.movie;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity
{
    private EditText editEmail, editSenha;
    private Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Seta de retorno à tela anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                  //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);                       //Ativar o botão
        getSupportActionBar().setTitle("Login");                                //Titulo para ser exibido na sua Action Bar em frente à seta

        //Ações do botão "Login"
        logar = (Button) findViewById(R.id.btnLogar);
        logar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editEmail = (EditText) findViewById(R.id.editLoginEmail);
                editSenha = (EditText) findViewById(R.id.editLoginSenha);

                String login = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                UsuarioDAO dao = new UsuarioDAO(TelaLogin.this);
                try
                {
                    int aux = dao.validarLogin(login,senha);
                    if(aux == 1)
                    {
                        alert("Login realizado com sucesso!");

                        Intent intecao = new Intent(TelaLogin.this, TelaPrincipal.class);
                        startActivity(intecao);
                    }
                    else
                    {
                        alert("Usuário não encontrado");

                        editEmail.setText("");
                        editSenha.setText("");
                    }
                }
                catch(SQLException e)
                {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(TelaLogin.this);
                    dlg.setMessage("Erro na criação do banco: " + e.getMessage());
                    dlg.setNeutralButton("Ok", null);
                    dlg.show();
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { //Botão adicional na ToolBar
        switch (item.getItemId())
        {
            case android.R.id.home:                                                 //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(TelaLogin.this, TelaInicial.class));       //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();                                                           //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    private void alert (String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
