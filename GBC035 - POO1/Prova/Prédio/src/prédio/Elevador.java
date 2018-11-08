package prédio;

public class Elevador
{
    private int tandar;
    private int andar;
    
    public Elevador(int t)
    {
        this.tandar = t;
        this.andar = 0;
    }
    
    public void irParaAndar(int a)
    {
        this.andar = a;
        System.out.println("Andar: " + this.andar);
    }
    public int qualandar()
    {
        return this.andar;
    }
    
    public int numeroAndares()
    {
        return this.tandar;
    }
}
