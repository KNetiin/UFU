package br.com.ufu_cm.movie;

import java.io.Serializable;

public class Filme implements Serializable
{
    private String fk;
    private long id;
    private int imagem;
    private String nome;
    private String sinopse;
    private int duracao;
    private String genero;
    private String[] horarios;

    public Filme (String fk, int imagem, String nome, String sinopse, int duracao, String genero)
    {
        this.fk = fk;
        this.imagem = imagem;
        this.nome = nome;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.genero = genero;
        this.horarios = new String[5];
    }

    public String getHorarios(int x){ return this.horarios[x]; }

    public  void setHorarios(String y1, String y2, String y3, String y4, String y5)
    {
        this.horarios[0] = y1;
        this.horarios[1] = y2;
        this.horarios[2] = y3;
        this.horarios[3] = y4;
        this.horarios[4] = y5;
    }

    public String getfk() {
        return fk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImagem()
    {
        return imagem;
    }

    public void setImagem(int imagem)
    {
        this.imagem = imagem;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSinopse()
    {
        return sinopse;
    }

    public void setSinopse(String sinopse)
    {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
