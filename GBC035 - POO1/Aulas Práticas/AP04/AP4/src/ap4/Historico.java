package ap4;
import java.util.*;

public class Historico
{
    ArrayList<DisciplinaM> dmatriculadas;
    
    public Historico()
    {
        dmatriculadas = new ArrayList();
    }
    
    public boolean h_verifica(Disciplina d)
    {
        if(d.requisitos.isEmpty())
        {
            return true;
        }
        else
        {
            //System.out.println("" + d.requisitos.size() + this.dmatriculadas.size());
            for(int i = 0; i < d.requisitos.size(); i++)
            {
                for(int j = 0; j < this.dmatriculadas.size(); j++)
                {
                    Disciplina d1 = d.requisitos.get(i);
                    DisciplinaM dm = this.dmatriculadas.get(j);
                    if(dm.d.nome.equals(d1.nome))
                    {
                        return dm.aprovado;
                    }
                }
            }
        }
        return false;
    }
    
    public void add_disciplina(DisciplinaM d)
    {
        this.dmatriculadas.add(d);
    }
    
  
}
