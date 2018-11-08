package br.com.ufu_cm.movie;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class TelaCadastro extends AppCompatActivity
{
    private Button salvar;
    private UsuarioHelper helper;
    private String localArquivo;
    private static final int FAZER_FOTO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Seta de retorno à tela anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                          //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);                               //Ativar o botão
        getSupportActionBar().setTitle("Novo Usuário");                                 //Titulo para ser exibido na sua Action Bar em frente à seta

        helper = new UsuarioHelper(this);
        helper.getFoto().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //localArquivo = Environment.getDataDirectory() + "/" + System.currentTimeMillis() + ".jpg";
                localArquivo = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".jpg";
                File arquivo = new File(localArquivo);
                Uri localFoto = Uri.fromFile(arquivo);
                Intent irParaCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT,localFoto);
                startActivityForResult(irParaCamera,FAZER_FOTO);
            }
        });

        //Botão de salvar novo usuário
        salvar = (Button) findViewById(R.id.btnSalvar);
        salvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Usuario user = helper.getUsuario();
                UsuarioDAO dao = new UsuarioDAO(TelaCadastro.this);
                try
                {
                    if(user.getId() == null)
                    {
                        dao.cadastrarUsuario(user);
                        alert("Cadastro realizado com sucesso");
                    }
                    else
                    {
                        dao.alteraUsuario(user);
                        alert("Cadastro alterado com sucesso");

                    }
                }
                catch(SQLiteException e)
                {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(TelaCadastro.this);
                    dlg.setMessage("Erro na criação do banco: " + e.getMessage());
                    dlg.setNeutralButton("Ok", null);
                    dlg.show();
                }
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { //Botão adicional na ToolBar
        switch (item.getItemId())
        {
            case android.R.id.home:                                                     //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(TelaCadastro.this, TelaInicial.class));        //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();                                                               //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == FAZER_FOTO)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                helper.carregarFoto(this.localArquivo);
            }
            else
            {
                localArquivo = null;
            }
        }
    }

    private void alert (String s)
    {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
