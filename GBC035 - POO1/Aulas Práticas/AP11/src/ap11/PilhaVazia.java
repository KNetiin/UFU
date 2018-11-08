package ap11;

public class PilhaVazia extends Exception
{
    public PilhaVazia()
    {
        System.out.println("Pilha Vazia! Não foi possível remover um número");
    }
}