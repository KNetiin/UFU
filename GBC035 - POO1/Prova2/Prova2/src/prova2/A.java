package prova2;


public class A
{
        void f(int i) throws Exception
        {
            try
            {
                System.out.println("Início de f");
                new B(i).g();
                System.out.println("Depois de g em f");
            }
            catch(SidelmawException e)
            {
                System.out.println(e.mensagem);
                throw e;
            }
            System.out.println("Fim de f");
            throw new Exception("Uma excecao generica");
        }
}