package loja;

public class ClienteVIP extends Cliente
{
    public ClienteVIP(String nome, String end)
    {
        super(nome,end);
    }

    public void mala_direta() {
        String aviso = "Prezado(a) " + nome + ",\n   estaremos em promoção no dia 23/07 e convidamos você a aproveitar 30% de desconto em toda nossa loja.";
        System.out.println(nome + "\n" + endereco + "\n" + aviso);
    }
    
}
