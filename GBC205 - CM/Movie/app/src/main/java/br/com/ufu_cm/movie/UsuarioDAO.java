package br.com.ufu_cm.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends SQLiteOpenHelper
{
    //Constantes para auxilio no controle de versoes
    private static final int VERSAO = 1;
    private static final String TABELA = "Usuario";
    private static final String DATABASE = "Cinema";

    //Constante para logcat
    private static final String TAG = "CADASTRO_USUARIO";

    public UsuarioDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        //Definicao do comando DDL a ser executado
        String ddl = "CREATE TABLE IF NOT EXIsTS " + TABELA + "( "
                + "id               INTEGER         PRIMARY KEY         AUTOINCREMENT, "
                + "foto             TEXT,"
                + "nome             TEXT, "
                + "telefone         TEXT, "
                + "cpf              TEXT, "
                + "nascimento       DATE, "
                + "email            TEXT            NOT NULL, "
                + "senha            TEXT            NOT NULL)";

        //EXECUCAO
        database.execSQL(ddl);
    }

    //Metodo responsavel pela atualizacao das estruturas das tabelas
    @Override
    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova)
    {
        // Definicao do coamando para destruir a tabela cidade
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        Log.i(TAG,"TABELA DROPADA");

        //Execucao
        database.execSQL(sql);

        //Chamada ao metodo de construcao da base de dados
        onCreate(database);
    }

    public void cadastrarUsuario(Usuario user)
    {
        //objeto para armazenar os valores dos campos
        ContentValues values = new ContentValues();

        //Definicao dos campos da tabela
        values.put("foto",user.getFoto());
        values.put("nome",user.getNome());
        values.put("telefone",user.getTelefone());
        values.put("cpf",user.getCpf());
        values.put("nascimento",user.getNascimento());
        values.put("email",user.getEmail());
        values.put("senha",user.getSenha());

        getWritableDatabase().insert(TABELA,null,values);
        Log.i(TAG,"Usuario cadastrado" + user.getNome());
    }

    public void alteraUsuario(Usuario user)
    {
        ContentValues values = new ContentValues();

        values.put("nome",user.getNome());
        values.put("telefone",user.getTelefone());
        values.put("cpf",user.getCpf());
        values.put("nascimento",user.getNascimento());
        values.put("email",user.getEmail());
        values.put("foto",user.getFoto());
        values.put("senha",user.getSenha());

        String[] args = {user.getId().toString()};

        getWritableDatabase().update(TABELA,values,"id=?",args);
        Log.i(TAG,"Usuario alterado: " + user.getNome());
    }

    public int validarLogin(String username, String password)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABELA + " WHERE email=? AND senha=?", new String[]{username, password});
        if(c.getCount() > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
