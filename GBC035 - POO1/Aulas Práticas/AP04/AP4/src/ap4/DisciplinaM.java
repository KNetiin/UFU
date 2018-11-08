package ap4;

public class DisciplinaM
{
    Disciplina d;
    Professor f;
    float nota;
    float frequencia;
    boolean aprovado;
    boolean cursando;
    boolean trancada;
    
    public DisciplinaM(Disciplina d, Professor f, Historico h)
    {
        if(f.p_verifica(d))
        {
            if(h.h_verifica(d))
            {
                this.d = d;
                this.f = f;
                this.nota = 0f;
                this.frequencia = 0f;
                this.aprovado = false;
                this.cursando = true;
                this.trancada = false;
            }else
            {
                System.out.println("Disciplina: " + d.nome);
                System.out.println("Não foi aprovado nos prerequesitos");
                this.nota = -10f;
            }
        }else System.out.println("ERRO!Professor não oferece essa disciplina");
    }
    
    public void add_nota(float n, float f)
    {
        this.nota = n;
        this.frequencia = f;
        this.cursando = false;
        if(n>=60 && f>=75)
        {
            this.aprovado = true;
        }
    }
    
    public void trancar()
    {
        this.cursando = false;
        this.trancada = true;
    }
    
    public void imprime()
    {
        if(this.nota != -5)
        {
            if(this.trancada)
            {            
                System.out.println("Disciplina: " + this.d.d_nome());
                System.out.println("TRANCADA\n");
            }else 
            {
                System.out.println("Disciplina: " + this.d.d_nome());
                System.out.println("Professor: " + this.f.nome);
                System.out.println("Nota: " + this.nota);
                System.out.println("Frequência: " + this.frequencia);
                if(this.aprovado) System.out.println("APROVADO\n");
                else if(this.cursando)
                {
                    System.out.println("CURSANDO\n");
                }else System.out.println("REPROVADO\n");             
            }
        }//else System.out.println("AKI");
    }
}