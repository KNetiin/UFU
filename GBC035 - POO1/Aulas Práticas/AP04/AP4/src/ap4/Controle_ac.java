package ap4;
import java.util.*;

public class Controle_ac
{
    ArrayList<Aluno> alunos;
    ArrayList<Professor> professor;

    public Controle_ac()
    {
        this.alunos = new ArrayList<>();
        this.professor = new ArrayList<>();
    }
    public void add_aluno(Aluno a)
    {
        this.alunos.add(a);
    }
    public void re_aluno(Aluno a)
    {
        boolean b = this.alunos.remove(a);
        if(b == true)
        {
            System.out.println("Aluno removido com sucesso");
        }else
        {
            System.out.println("Erro ao remover aluno");
        }
    }
}