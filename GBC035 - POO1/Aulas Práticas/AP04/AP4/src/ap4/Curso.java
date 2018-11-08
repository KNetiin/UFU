package ap4;

public class Curso
{
    String nome;
    Grade_Curricular grade;
    Controle_ac ca;
    
    public Curso(String n, Grade_Curricular g, Controle_ac ca)
    {
        this.nome = n;
        this.grade = g;
        this.ca = ca;
    }
    
}
