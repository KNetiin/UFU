package batalhanaval;
import java.util.ArrayList;

public class Navio
{
    final private int tamanho;
    private int qt_rest;
    final private String nome;
    private boolean destruido;
    ArrayList<String> posicao;
    
    public Navio(int tam, String nome)
    {
        this.tamanho = tam;
        this.nome = nome;
        this.qt_rest = tam;
        this.destruido = false;
    }
    
    public void acerto_navio()
    {
        this.qt_rest--;
        if(this.qt_rest == 0)
        {
            this.destruido = true;
        }
    }
    
    public int getQt_rest()
    {
        return this.qt_rest;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public boolean getDestruido()
    {
        return this.destruido;
    }
}
