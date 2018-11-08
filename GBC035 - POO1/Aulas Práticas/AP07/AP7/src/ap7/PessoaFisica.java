package ap7;

public class PessoaFisica extends Pessoa
{
    private final String cpf;
    private final float ra;
        
    public PessoaFisica(String n, String cpf, float ra)
    {
        super(n);
        this.cpf = cpf;
        this.ra = ra;
    }
    
    public double imposto()
    {
        return this.ra*0.15;
    }
    
    public String certificado ()
    {
        return "A pessoa " + getNome() + " tem que pagar R$" + imposto()+"0";
    }
}