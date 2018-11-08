package ap3;

import java.util.ArrayList;

public class Controle_Academico
{
   ArrayList<Aluno> ca;
   
   public Controle_Academico()
   {
       ca = new ArrayList<>();
   }
   public void Adiciona_Aluno(Aluno a)
   {
       ca.add(a);
   }
   public void imprimir_ca()
   {
       System.out.println("CONTROLE ACADÊMICO:\n");
       ca.forEach((Aluno a) -> 
       {
           a.Mostrar();
           System.out.println("\n");
       });
   }
}
