package br.com.ufu_cm.movie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FilmeDAO extends SQLiteOpenHelper
{
    //Constantes para auxilio no controle de versoes
    private static final int VERSAO = 1;
    private static final String TABELA = "Filme";
    private static final String DATABASE = "Cinema";

    //Constante para logcat
    private static final String TAG = "CADASTRO_FILME";

    public FilmeDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        //Definicao do comando DDL a ser executado
        String ddl = "CREATE TABLE IF NOT EXITS" + TABELA + "( "
                + "id               INTEGER         PRIMARY KEY, "
                + "imagem           TEXT,"
                + "nome             TEXT, "
                + "sinopse          TEXT, "
                + "duracao          INTEGER, "
                + "genero           TEXT)";

        //EXECUCAO
        database.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Definicao do coamando para destruir a tabela cidade
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        Log.i(TAG,"TABELA DROPADA");

        //Execucao
        db.execSQL(sql);

        //Chamada ao metodo de construcao da base de dados
        onCreate(db);
    }




}
