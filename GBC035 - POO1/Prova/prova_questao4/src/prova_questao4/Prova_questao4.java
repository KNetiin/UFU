package prova_questao4;

public class Prova_questao4
{
    public static void main(String[] args)
    {
        Servidor s = new Servidor(2);
        Internauta i1 = new Internauta(s, "Joao");
        Internauta i2 = new Internauta(s, "Maria");
        i1.envia("Maria", "I love you!!!");
    }
    
}
