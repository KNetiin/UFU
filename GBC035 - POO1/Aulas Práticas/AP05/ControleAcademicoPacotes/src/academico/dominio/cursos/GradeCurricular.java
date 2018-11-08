package academico.dominio.cursos;

import java.util.*;

public class GradeCurricular
{
    private ArrayList<Disciplina> disciplinas;
    
    public GradeCurricular()
    {
        disciplinas = new ArrayList<>();
    }
    
    public void incluiDisciplina (Disciplina d)
    {
        disciplinas.add(d);
    }
    
    public void removeDisciplina (Disciplina d)
    {
        disciplinas.remove(d);
    }

    public int nroDisciplinas()
    {
        return disciplinas.size();
    }
    
    public ArrayList<Disciplina> getdisciplinas()
    {
        return this.disciplinas;
    }
}