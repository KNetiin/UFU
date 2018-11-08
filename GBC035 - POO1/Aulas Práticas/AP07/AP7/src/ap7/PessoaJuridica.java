package ap7;

public class PessoaJuridica extends Pessoa
{
    private final String cnpj;
    private final float ci;
    private final float fa;
    
    public PessoaJuridica(String n, String cnpj, float ci, float fa)
    {
        super(n);
        this.ci = ci;
        this.cnpj = cnpj;
        this.fa = fa;
    }
    
    public double imposto()
    {
        return 0.2*(this.fa - this.ci);
    }
    
    public String certificado ()
    {
        return "A Empresa " + getNome() + " tem que pagar R$" + imposto()+"0";
    }
}