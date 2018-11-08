package prédio;

public class Botão
{
    private int andar;
    private boolean ligado;
    
    public Botão(int andar)
    {
        this.andar = andar;
        this.ligado = false;
    }
    
    public void ligar()
    {
        this.ligado = true;
    }
    public void desligar()
    {
        this.ligado = false;
    }
    public boolean estaLigado()
    {
        return this.ligado;
    }
    
    public int qualAndar()
    {
        return this.andar;
    }
}
