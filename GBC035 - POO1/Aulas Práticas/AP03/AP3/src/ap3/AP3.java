package ap3;

public class AP3 
{

    public static void main(String[] args) 
    {
        Disciplina c1 = new Disciplina("POO1" , 80.5f , 80f);
        Disciplina c2 = new Disciplina("AOC" , 100f , 50f);
        Disciplina c3 = new Disciplina("C3" , 70f , 30f);
        Disciplina c4 = new Disciplina("AED2" , 30f , 100f);
        Disciplina c5 = new Disciplina("EST" , 59.9f , 95f);
        Disciplina c6 = new Disciplina("PF" , 60f , 80.9f);
        Disciplina c7 = new Disciplina("MCC" , 60f , 45.5f);
        Disciplina c8 = new Disciplina("GAAL" , 99.5f , 100f);
        Disciplina c9 = new Disciplina("C2" , 55f , 90f);
        Disciplina c10 = new Disciplina("C1" , 60f , 100f);
        Disciplina c11 = new Disciplina("PP" , 10f , 10f);
        Disciplina c12 = new Disciplina("PL" , 80f , 70f);
        Disciplina c13 = new Disciplina("AED1" , 70f , 75f);
        Disciplina c14 = new Disciplina("LC" , 60f , 25f);
        //c1.Status();
        
        Historico h1 = new Historico();
        Historico h2 = new Historico();
        Historico h3 = new Historico();
        Historico h4 = new Historico();
        
        h1.matriculaDisciplina(c1);
        h1.matriculaDisciplina(c2);
        h1.matriculaDisciplina(c3);
        
        h2.matriculaDisciplina(c4);
        h2.matriculaDisciplina(c5);
        h2.matriculaDisciplina(c6);
        h2.matriculaDisciplina(c7);
        
        h3.matriculaDisciplina(c8);
        h3.matriculaDisciplina(c9);
        h3.matriculaDisciplina(c10);
        
        h4.matriculaDisciplina(c11);
        h4.matriculaDisciplina(c12);
        h4.matriculaDisciplina(c13);
        h4.matriculaDisciplina(c14);
        //h1.imprime_historico();
        
        Aluno a1 = new Aluno("Antonio Carlos" , "11611BCC054" , 2016 , h1);
        Aluno a2 = new Aluno("Higor Emanuel" , "11611BCC016" , 2017 , h2);
        Aluno a3 = new Aluno("Lucas Rossi Rabelo" , "11611BCC044" , 2014 , h3);
        Aluno a4 = new Aluno("Marcelo Mendonça Borges" , "11611BCC020" , 1990 , h4);
        //a1.Mostrar();
        
        Controle_Academico ca = new Controle_Academico();
        ca.Adiciona_Aluno(a1);
        ca.Adiciona_Aluno(a2);
        ca.Adiciona_Aluno(a3);
        ca.Adiciona_Aluno(a4);
        ca.imprimir_ca();
        
    }
    
}
