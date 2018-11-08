package ap1;

import java.util.Vector;
public class Historico
{
    Vector<Disciplina> listaDisciplinas;

    public Historico ()
    {
        listaDisciplinas = new Vector<Disciplina>();
    }
    
    void matriculaDisciplina (Disciplina d) 
    {
        listaDisciplinas.add(d);
    }

    void imprime () 
    {
        System.out.println("Historico do Aluno");
        for (Disciplina d: listaDisciplinas)

            d.imprime();          
    } 
}
