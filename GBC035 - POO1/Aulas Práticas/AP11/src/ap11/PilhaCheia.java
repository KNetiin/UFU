package ap11;

public class PilhaCheia extends Exception {
    String Mensagem;
    PilhaCheia(int num)
    {
        System.out.println("Pilha Cheia! Número " + num + " não Colocado na Pilha!");
    }
}