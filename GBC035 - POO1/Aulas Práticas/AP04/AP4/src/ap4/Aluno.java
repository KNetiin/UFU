package ap4;

import java.util.ArrayList;

public class Aluno 
{
    String nome;
    String matricula;
    float anoingresso;
    Historico h1;
    
    public Aluno(String n, String m, float a, Historico h)
    {
        this.nome = n;
        this.matricula = m;
        this.anoingresso = a;
        this.h1 = h;
    }
    
    public void falta_dis(Grade_Curricular g, Grade_Curricular g2)
    {
        for(int i = 0; i < g.grade.size(); i++) g2.grade.add(g.grade.get(i));
        for(int i = 0; i < g.grade.size(); i++)
        {
            for(int j = 0; j < this.h1.dmatriculadas.size(); j++)
            {
                Disciplina d1 = g.grade.get(i);
                DisciplinaM dm = this.h1.dmatriculadas.get(j);
                if(dm.d.nome.equals(d1.nome))
                {
                    if(dm.aprovado)
                    {
                        g2.grade.remove(d1);
                    }
                }
            }
        }
    }
}
