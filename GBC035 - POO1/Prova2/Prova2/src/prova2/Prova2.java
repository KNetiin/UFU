package prova2;

public class Prova2
{
    /*
    public static void main(String args[]) throws Exception
    {
        try 
        {
            new A().f(1);
            System.out.println("Depois do f no main");
        }
        catch(TabajaraException e)
        {
            System.out.println(e.mensagem);
        }
        finally
        {
            System.out.println("Antes do fim do main");
        }
        System.out.println("Fim");
    }*/
   public static void main (String args[]) throws Exception
   {
        try
        {
            new A().f(2);
            System.out.println("Depois do f no main");
        }
        catch(TabajaraException e)
        {
            System.out.println(e.mensagem);
        }
        finally
        {
            System.out.println("Antes do fim do main");
        }
        System.out.println("Fim");
    }
}
