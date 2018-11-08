package janelaagenda;

import java.util.*;

public class Agenda {

    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void insere_pessoa(String n, String e, int tell) {
        Pessoa pessoa = new Pessoa(n, e, tell);
        this.pessoas.add(pessoa);
    }

    public Pessoa procurar_pessoa(String n) 
    {
        for (int i = 0; i < this.pessoas.size(); i++) {
            if (this.pessoas.get(i).getNome().equals(n)) {
                return this.pessoas.get(i);
            }
        }
        return null;
    }

    public void deleta_pessoa(String n) {
        this.pessoas.remove(this.procurar_pessoa(n));
    }

}
