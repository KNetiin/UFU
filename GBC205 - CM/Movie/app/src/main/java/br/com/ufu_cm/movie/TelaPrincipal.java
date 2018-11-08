package br.com.ufu_cm.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private ListView listaFimes;
    private ArrayAdapter<Filme> adapter;
    private Filme filmeSelecionado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listaFimes = (ListView) findViewById(R.id.lstFilmes);
        adapter = new FilmeAdapter(this, adicionaFilmes());
        listaFimes.setAdapter(adapter);

        listaFimes.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id)
            {
                Intent form = new Intent(TelaPrincipal.this, TelaFilme.class);
                filmeSelecionado = (Filme) listaFimes.getItemAtPosition(posicao);
                //String teste = filmeSelecionado.getfk();
                form.putExtra("FILME_FK", filmeSelecionado.getfk() );
                form.putExtra("FILME_NOME", filmeSelecionado.getNome() );
                form.putExtra("FILME_DURACAO", "" + filmeSelecionado.getDuracao() );
                form.putExtra("FILME_GENERO", filmeSelecionado.getGenero() );

                for(int i = 0; i < 5; i++) {form.putExtra("FILME" + i, filmeSelecionado.getHorarios(i) ); };

                startActivity(form);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<Filme> adicionaFilmes()
    {
        ArrayList<Filme> filmes = new ArrayList<Filme>();

        Filme f = new Filme("A saga da família Skywalker continua quando os heróis de Despertar da Força se unem a lendas da galáxia em uma aventura épica que desvenda antigos mistérios da Força e revelações surpreendentes do passado.", R.drawable.um, "Star Wars: Os Últimos Jedi", "Sinopse: A saga da família Skywalker continua...", 150, "Ação");
        f.setHorarios("15:45 - SALA 4(3D, DUB)", "19:00 - SALA 4(3D, DUB)", "15:00 - SALA 5(3D, DUB)", "21:30 - SALA 5(LEG)", "14:00 - SALA 6(3D, LEG)" );
        filmes.add(f);

        f = new Filme("Thor (Chris Hemsworth) está preso do outro lado do universo. Ele precisa correr contra o tempo para voltar a Asgard e parar Ragnarok, a destruição de seu mundo, que está nas mãos da poderosa e implacável vilã Hela (Cate Blanchett).", R.drawable.dois, "Thor: Ragnarok", "Sinopse: Thor (Chris Hemsworth) está preso do outro lado do universo....", 131, "Ação");
        f.setHorarios("22:15 - SALA 4(3D, DUB)", "18:50 - SALA 5(DUB)", "17:15 - SALA 6(3D, LEG)", "20:30 - SALA 5(3D, LEG)", "18:40 - SALA 2(DUB)" );
        filmes.add(f);

        f = new Filme("Impulsionado pela restauração de sua fé na humanidade e inspirado pelo ato altruísta do Superman (Henry Cavill), Bruce Wayne (Ben Affleck) convoca sua nova aliada Diana Prince (Gal Gadot) para o combate contra um inimigo ainda maior, recém-despertado. Juntos, Batman e Mulher-Maravilha buscam e recrutam com agilidade um time de meta-humanos, mas mesmo com a formação da liga de heróis sem precedentes - Batman, Mulher-Maraviha, Aquaman (Jason Momoa), Cyborg (Ray Fisher) e The Flash (Ezra Miller), poderá ser tarde demais para salvar o planeta de um catastrófico ataque.", R.drawable.tres, "Liga da Justiça", "Sinopse: Impulsionado pela restauração de sua fé na humanidade...", 120, "Ação");
        f.setHorarios("14:45 - SALA 1(DUB)", "17:30 - SALA 1(DUB)", "20:15 - SALA 1(DUB)", "18:40 - SALA 2(LEG)", "21:15 - SALA 2(3D, DUB)" );
        filmes.add(f);

        f = new Filme("Várias pessoas estão fazendo uma viagem longa em um luxuoso trem. A paz, entretanto, é perturbada por um acontecimento sinistro: um terrível assassinato. À bordo da composição está ninguém menos que o mundialmente reconhecido detetive Hercule Poirot (Kenneth Branagh) que se voluntaria para iniciar uma varredura no local, ouvindo testemunhas e possíveis suspeitos para descobrir o que de fato aconteceu.", R.drawable.quatro, "Assassinato no Expresso do Oriente", "Sinopse: Várias pessoas estão fazendo uma...", 114, "Crime");
        f.setHorarios("17:00 - SALA 8(DUB)", "19:00 - SALA 3(3D, DUB)", "16:40 - SALA 3(3D, DUB)", "20:30 - SALA 3(LEG)", "22:00 - SALA 6(3D, LEG)" );
        filmes.add(f);

        f = new Filme("Na mais nova animação da Sony Pictures Animation, A Estrela, um pequeno e destemido burro chamado Bo anseia por uma vida que vá além da cota diária de trabalho no moinho da vila. Um dia ele encontra coragem para fugir, e finalmente viver as aventuras que tanto sonhou. Em sua jornada, ele logo se alia à Ruth, uma ovelha adorável que se perdeu de seu bando; e à Dave, um pombo com aspirações grandiosas. E junto com 3 sábios camelos e outros animais excêntricos de um estábulo, Bo e seus novos amigos seguem A Estrela e se tornam heróis improváveis na maior história já contada – o primeiro Natal.", R.drawable.cinco, "A Estrela de Belém", "Sinopse: Na mais nova animação da Sony Pictures Animation...", 86, "Animação");
        f.setHorarios("15:15 - SALA 7(3D, DUB)", "18:00 - SALA 7(3D, DUB)", "19:45 - SALA 7(3D, DUB)", "21:30 - SALA 6(LEG)", "23:00 - SALA 6(3D, LEG)" );
        filmes.add(f);

        f = new Filme("Auggie Pullman (Jacob Tremblay) é um garoto que nasceu com uma deformação facial. Pela primeira vez, ele irá frequentar uma escola regular, como qualquer outra criança. No quinto ano, ele irá precisar se esforçar para conseguir se encaixar em sua nova realidade.", R.drawable.seis, "Extraordinário", "Sinopse: Auggie Pullman (Jacob Tremblay) é um garoto que nasceu...", 113, "Drama");
        f.setHorarios("13:30 - SALA 2(DUB)", "16:00 - SALA 2(DUB)", "14:30 - SALA 8(DUB)", "19:40 - SALA 8(DUB)", "22:30 - SALA 8(LEG)" );
        filmes.add(f);

        f = new Filme("Corpos estão surgindo pela cidade, cada um encontrando um desaparecimento horrível. Enquanto a investigação continua, as evidências apontam para um homem: John Kramer. Mas como isso é possível? O homem conhecido como Jigsaw está morto há mais de uma década. Será que algum aprendiz assumiu o manto de Jigsaw, talvez até mesmo alguém de dentro da investigação?", R.drawable.sete, "Jogos Mortais: Jigsaw", "Sinopse: Corpos estão surgindo pela cidade, cada um encontrando um...", 92, "Terror");
        f.setHorarios("00:00 - SALA 1(3D, DUB)", "23:15 - SALA 2(3D, DUB)", "20:00 - SALA 9(3D, DUB)", "23:30 - SALA 9(LEG)", "14:00 - SALA 9(3D, LEG)" );
        filmes.add(f);

        return filmes;
    }
}
