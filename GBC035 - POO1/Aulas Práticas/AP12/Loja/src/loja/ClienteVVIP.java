package loja;

public class ClienteVVIP extends Cliente
{
    String gerente;
    public ClienteVVIP(String nome, String end, String gerente)
    {
        super(nome,end);
        this.gerente = gerente;
    }
    
    public void mala_direta() {
        String aviso = nome + ",\n   Quanta alegria em te convidar a tomar um cafézinho com o nosso gerente " + gerente +". Estaremos em promoção no dia 23/07 e convidamos você a aproveitar 50% de desconto em toda nossa loja.";
        System.out.println(nome + "\n" + endereco + "\n" + aviso);
    }
}
