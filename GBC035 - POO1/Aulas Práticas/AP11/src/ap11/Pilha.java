package ap11;

public class Pilha
{
    public int[] vetor;
    public int ponteiro;
    
    public Pilha(int tam)
    {
        this.ponteiro = -1;
        this.vetor = new int[tam];
    }
    
    public boolean isEmpty()
    {
        return this.ponteiro == -1;
    }
    
    public int pop() throws Exception
    {
        if(isEmpty())
        {
            throw new PilhaVazia();
        }
        return this.vetor[this.ponteiro--];
    }
    
    public void push(int valor) throws Exception
    {
        if(this.ponteiro >= this.vetor.length - 1)
        {
            throw new PilhaCheia(valor);
        }
        this.vetor[++ponteiro] = valor;
    }
}