package ap4;
import java.util.*;

public class Professor
{
    String nome;
    String departamento;
    ArrayList<Disciplina> materias;
    
    public Professor(String nome, String departamento)
    {
        this.materias = new ArrayList<>();
        this.nome = nome;
        this.departamento = departamento;
    }
    
    public boolean p_verifica (Disciplina d)
    {
        return this.materias.contains(d);
    }
    
    public void p_add_materias(Disciplina d)
    {
        if(this.p_verifica(d))
        {
            System.out.println("Matéria já ofertada!");
        }
        else this.materias.add(d);
    }
    
    public void p_add_disciplina6(Disciplina d1, Disciplina d2, Disciplina d3, Disciplina d4, Disciplina d5, Disciplina d6)
    {
        this.materias.add(d1);
        this.materias.add(d2);
        this.materias.add(d3);
        this.materias.add(d4);
        this.materias.add(d5);
        this.materias.add(d6);
    }
    public void p_limpa()
    {
        this.materias.clear();
    }
    
    public void p_mostrar()
    {
        if(this.materias.isEmpty())
        {
            System.out.println("Sem Matérias!");
        }else
        {
            this.materias.forEach((Disciplina d) -> System.out.println("" + d.d_nome()));
        }
    }
    
    public void p_imprime()
    {
        System.out.println("Professor: " + this.nome);
        System.out.println("Departamento: " + this.departamento);
        System.out.println("Matérias Ofertadas: ");
        this.p_mostrar();
        System.out.println("");
    }
}
