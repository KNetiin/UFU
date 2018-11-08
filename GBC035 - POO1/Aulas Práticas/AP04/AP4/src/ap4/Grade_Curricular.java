package ap4;
import java.util.*;

public class Grade_Curricular
{
    ArrayList<Disciplina> grade;
    
    public Grade_Curricular()
    {
        grade = new ArrayList<>();
    }
    
    public boolean verifica_dis (Disciplina d)
    {
        return this.grade.contains(d);
    }
    
    public void add_disciplina(Disciplina d)
    {
        if(this.verifica_dis(d))
        {
            System.out.println("Disciplina já existe!");
        }
        else this.grade.add(d);
    }
    
    public void add_disciplina6(Disciplina d1, Disciplina d2, Disciplina d3, Disciplina d4, Disciplina d5, Disciplina d6)
    {
        this.grade.add(d1);
        this.grade.add(d2);
        this.grade.add(d3);
        this.grade.add(d4);
        this.grade.add(d5);
        this.grade.add(d6);
    }
    
    public void re_disciplina(Disciplina d)
    {
        boolean b = this.grade.remove(d);
        if(b == true)
        {
            System.out.println("Disciplina removida com sucesso");  
        }
        else
        {
            System.out.println("Falha ao remover disciplina");
        }
    }
    
    public void mostrar_grade()
    {
        //System.out.println("Grade Curricular Necessária:");
        this.grade.forEach((Disciplina d) -> System.out.println("" + d.d_nome()));
    }
}
