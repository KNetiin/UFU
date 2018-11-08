package prova_questao4;

public class Internauta
{
    String nome;
    Servidor s;
    EnumOnn online;
    
    public Internauta(Servidor s , String nome)
    {
        this.nome = nome;
        this.online = EnumOnn.ON;
        s.listai.add(this);
        this.s = s;
        
    }
    
    public void envia(String nome, String mensagem)
    {
        if(s.verifica_on(nome))
        {
            System.out.println("Envio:\n" + this.nome + " envia para " + nome + "a mensagem:\n" + mensagem);
            this.s.enviapara(nome,this.nome,mensagem);
        }else
        {
             System.out.println("Internauta ofline");
        }
    }
    
    public void recebe(String nome, String mensagem)
    {
        System.out.println("\nRecebimento:\n" + this.nome + " recebeu de " + nome + "a mensagem:\n" + mensagem);
    }
}