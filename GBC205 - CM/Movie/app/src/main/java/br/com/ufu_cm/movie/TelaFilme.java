package br.com.ufu_cm.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TelaFilme extends AppCompatActivity {

    private Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_filme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent comunicacao = getIntent();

        //Seta de retorno à tela anterior
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                          //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);                               //Ativar o botão
        getSupportActionBar().setTitle(comunicacao.getStringExtra("FILME_NOME"));                                 //Titulo para ser exibido na sua Action Bar em frente à seta

        TextView duracao = (TextView) findViewById(R.id.tduracao);
        TextView genero = (TextView) findViewById(R.id.tgenero);
        TextView sinopse = (TextView) findViewById(R.id.tsinopse);

        duracao.setText(comunicacao.getStringExtra("FILME_DURACAO"));
        genero.setText(comunicacao.getStringExtra("FILME_GENERO"));
        sinopse.setText(comunicacao.getStringExtra("FILME_FK"));

        x = comunicacao;
       /*--------------------------------------------------------------------------------*/
        Button Comprar = (Button) findViewById(R.id.btnComprarIngresso);
        Comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent comp = new Intent(TelaFilme.this, ingresso.class);

                for(int i = 0; i < 5; i++)
                {
                    comp.putExtra("FILME" + i, x.getStringExtra("FILME"+i)  );
                }
                startActivity(comp);//new Intent(TelaFilme.this, ingresso.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { //Botão adicional na ToolBar
        switch (item.getItemId())
        {
            case android.R.id.home:                                                     //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(TelaFilme.this, TelaPrincipal.class));         //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();                                                       //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
