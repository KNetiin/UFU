package academico.dominio.pessoas;

import academico.dominio.cursos.Disciplina;
import academico.dominio.cursos.GradeCurricular;
import academico.dominio.matriculas.Historico;

public class Aluno {
    private String nome;
    private GradeCurricular grade;
    private Historico historico;
    
    public Aluno (String n, GradeCurricular g)
    {
        nome = n;
        grade = g;
        historico = new Historico(this);
    }
    
    public boolean verificaSeFormou ()
    {
        for (Disciplina d:   grade.getdisciplinas()) {
            if (! historico.constaAprovacao(d))
                return false;
        }
        return true;
    }
    
    public String getNomes()
    {
        return this.nome;
    }
    
    public GradeCurricular getGrade()
    {
        return this.grade;
    }
    
    public Historico getHistorico()
    {
        return this.historico;
    }
    
}