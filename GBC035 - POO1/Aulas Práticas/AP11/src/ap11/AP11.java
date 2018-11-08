package ap11;

public class AP11
{
    public static void main(String[] args) throws Exception
    {
        Pilha pilha = new Pilha(10);
        for(int i = 1; i < 11; i++)
        {
            pilha.push(i);
        }
        
        try
        {
            //pilha.push(11); // TENTAR COLOCAR O ELEMENTE DE NUMERO 11;
            
            for(int i = 1; i < 11; i++)
            {
                System.out.print(pilha.pop()+",");
            }
            System.out.println("");
            pilha.pop();
        }
        catch(PilhaCheia e)
        {
            System.out.println("Exception PilhaCheia pega!");
        }
        catch(PilhaVazia e)
        {
            System.out.println("Exception PilhaVazia pega!");          
        }
        /*
        for(int i = 1; i < 11; i++)
        {
            System.out.print(pilha.pop()+",");
        }
        pilha.pop();
        /*
        while(pilha.isEmpty() == false)
        {
            System.out.println(pilha.pop());
        }*/
    }
    
    
}
