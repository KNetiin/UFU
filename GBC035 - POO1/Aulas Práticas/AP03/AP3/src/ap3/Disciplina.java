package ap3;

public class Disciplina
{   
    String nome;
    boolean passou;
    float nota;
    float frequencia;
   
    public Disciplina(String ns , float nf , float ff)
    {
        this.nome = ns;
        this.nota = nf;
        this.frequencia = ff;
        this.passou = this.nota >= 60.0f && this.frequencia >= 75.0f;
    }
    public void Status()
    {
        System.out.println("Nome: " + this.nome);
        System.out.println("Nota: " + this.nota);
        System.out.println("Frequencia: " + this.frequencia);
        System.out.println("Passou: " + this.passou + "\n");
    }
}
