package ap1;

public class AP1 {


    public static void main(String[] args) 
    {
        Historico h = new Historico();
        Disciplina d1 = new Disciplina("C3");
        Disciplina d2 = new Disciplina("POO1");
        Disciplina d3 = new Disciplina("AOC");
        
        d1.atualizaResultado(100);
        d2.atualizaResultado(50);
        
        d1.imprime();
        d2.imprime();
        d3.imprime();
        
        h.matriculaDisciplina(d1);
        h.matriculaDisciplina(d2);
        h.matriculaDisciplina(d3);
        h.imprime();
    }
    
}
