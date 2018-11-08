package janelaagenda;

public class Pessoa
{
    private String nome;
    final private String end;
    final private int telefone;
    
    public Pessoa(String n, String e, int num)
    {
        this.nome = n;
        this.end = e;
        this.telefone = num;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public String getNome()
    {
        return this.nome;
    }
}
