package academico.dominio.cursos;

import java.util.*;

public class Disciplina
{
    private String nome;
    private ArrayList<Disciplina> prerequisitos;
    
    public Disciplina (String nome)
    {
        this.prerequisitos = new ArrayList<>();
        this.nome = nome;
    }
    
    public void criaPrerequisito (Disciplina d)
    {
        this.prerequisitos.add(d);
    }

    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public ArrayList<Disciplina> getPrerequisitos()
    {
        return this.prerequisitos;
    }
}