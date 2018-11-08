package academico.dominio.matriculas;

import academico.dominio.cursos.Disciplina;
import academico.dominio.pessoas.Professor;
import academico.dominio.pessoas.Aluno;
import java.util.*;

public class OfertaTurma
{
    private int ano;
    private Semestre semestre;
    private Disciplina disciplina;
    private ArrayList<MatriculaAluno> alunosMatriculados;
    private Professor  professor;
    
    public OfertaTurma (int ano, Semestre s, Disciplina d)
    {
        this.ano = ano;
        this.semestre = s;
        this.disciplina = d; 
        alunosMatriculados = new ArrayList<>();
    }
    
    public void matriculaAluno (MatriculaAluno m)
    {
        alunosMatriculados.add(m);
    }
    
    public void cancelaMatricula (Aluno a)
    {
        alunosMatriculados.remove(a);
    }
    
    public void vinculaProfessor (Professor p)
    {
        professor = p;
        professor.ficaAlocadoTurma(this);
    }    

    public String nomeDisciplina()
    {
        return this.disciplina.getNome();
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public Semestre getSemestre()
    {
        return this.semestre;
    }
    
    public Disciplina getDisciplina()
    {
        return this.disciplina;
    }
    
    public ArrayList<MatriculaAluno> getAlunosMatriculados()
    {
        return this.alunosMatriculados;
    }
    
    public Professor getProfessor()
    {
        return this.professor;
    }
}
