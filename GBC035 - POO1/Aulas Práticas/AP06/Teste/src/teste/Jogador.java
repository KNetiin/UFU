package teste;
import java.util.*;

public class Jogador
{
    private int pontos;
    private String nome;
    
    public Jogador(String nome)
    {
        this.nome = nome;
        this.pontos = 0;
    }
    
    public void aumenta(int x)
    {
        this.pontos = this.pontos + x;
    }
    public int pontoT()
    {
        return this.pontos;
    }
    public String getnome()
    {
        return this.nome;
    }
    
}
