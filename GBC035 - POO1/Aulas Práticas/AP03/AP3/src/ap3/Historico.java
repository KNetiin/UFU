package ap3;

import java.util.ArrayList;

public class Historico 
{
    ArrayList<Disciplina> listaDisciplinas;
    
    public Historico()
    {
        listaDisciplinas = new ArrayList<>();
    }
    public void matriculaDisciplina (Disciplina d)
    {
        listaDisciplinas.add(d);
    }
    public void imprime_historico ()
    {
        System.out.println("Disciplinas: ");
        listaDisciplinas.forEach((Disciplina d) -> 
        {
            d.Status();
        });
    }
    
}
