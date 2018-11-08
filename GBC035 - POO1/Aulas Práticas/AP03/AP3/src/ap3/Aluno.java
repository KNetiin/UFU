package ap3;
        
public class Aluno
{
    String nome;
    String matricula;
    int anoingresso;
    Historico historico;
    
    public Aluno(String ns, String ms , int ai , Historico hh)
    {
        this.nome = ns;
        this.matricula = ms;
        this.anoingresso = ai;
        this.historico = hh;
    }
    
    public void Mostrar()
    {
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Ano de Ingresso: " + this.anoingresso);
        System.out.println("Historico Escolar:");
        this.historico.imprime_historico();
        //Historico hn = new Historico();
        //hn = this.historico;
        //hn.imprime_historico();
    }
}
