package ap7;

public abstract class Pessoa implements Contribuintes
{
    private final String nome;
    
    public Pessoa(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String certificado ()
    {
        return "";
    }
    
 
}
