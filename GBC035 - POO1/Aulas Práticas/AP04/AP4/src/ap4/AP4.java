package ap4;

import java.util.ArrayList;


public class AP4 
{
    public static void main(String[] args)
    {
        /***************************************CRIANDO DISCIPLINAS***********************************/
        Disciplina d0 = new Disciplina("Emp");
        Disciplina d1 = new Disciplina("C1");
        Disciplina d2 = new Disciplina("GA");
        Disciplina d3 = new Disciplina("PP");
        Disciplina d4 = new Disciplina("ICC");
        Disciplina d5 = new Disciplina("LC");
        Disciplina d6 = new Disciplina("PCI");
        Disciplina d7 = new Disciplina("C2");
        d7.d_cria_requisitos(d1);
        Disciplina d8 = new Disciplina("MCC");
        Disciplina d9 = new Disciplina("AED1");
        d9.d_cria_requisitos(d3);
        Disciplina d10 = new Disciplina("PL");
        d10.d_cria_requisitos(d5);
        Disciplina d11 = new Disciplina("SD");
        Disciplina d12 = new Disciplina("C3");
        d12.d_cria_requisitos(d7);
        Disciplina d13 = new Disciplina("PF");
        d13.d_cria_requisitos(d10);
        Disciplina d14 = new Disciplina("AED2");
        d14.d_cria_requisitos(d9);
        Disciplina d15 = new Disciplina("POO");
        Disciplina d16 = new Disciplina("AOC");
        Disciplina d17 = new Disciplina("Est");
        
        //d12.d_cria_requisitos(d1);
        //d12.d_cria_requisitos(d7);
        //d12.d_cria_requisitos(d1);
        //d12.d_re_requisitos(d7);
        //d12.d_imprimir();
        //d8.d_imprimir();
        //d12.d_mostrar();
        //d8.d_mostrar();
        /****************************FIM CRIANDO DISCIPLINAS*********************************/
        
        /****************************CRIANDO GRADE DO CURSO**********************************/
        Grade_Curricular g = new Grade_Curricular();
        g.add_disciplina6(d0,d1,d2,d3,d4,d5);
        g.add_disciplina6(d6,d7,d8,d9,d10,d11);
        g.add_disciplina6(d12,d13,d14,d15,d16,d17);
        //g.mostrar_grade();
        /****************************FIM CRIANDO GRADE DO CURSO******************************/
        
        /********************************CRIANDO PROFESSOR***********************************/
        Professor p0 = new Professor("Matheus","Matemática");
        Professor p1 = new Professor("Claudio","Computação");
        Professor p2 = new Professor("Marcelo","Matemática");
        Professor p3 = new Professor("Lucas","Computação");
        Professor p4 = new Professor("Renata","Computação");
        
        p0.p_add_disciplina6(d0, d1, d2, d3, d4, d5);
        p1.p_add_materias(d6);
        p1.p_add_materias(d7);
        p2.p_add_disciplina6(d8, d9, d10, d11, d12, d13);
        p3.p_add_materias(d14);
        p3.p_add_materias(d15);
        p4.p_add_disciplina6(d16, d17, d4, d7, d2, d11);
        
        //p0.p_imprime();
        //p1.p_imprime();
        //p2.p_imprime();
        /*******************************FIM CRIANDO PROFESSOR********************************/
        
        /*************************MATRICULANDO ALUNO NA DISCIPLINA***************************/
        System.out.println("GRADE DO CURSO BCC:\n");
        g.mostrar_grade();
        
        System.out.println("\nDISCIPLINAS DO ALUNO:\n");
        Historico h0 = new Historico(); 
        DisciplinaM dm0 = new DisciplinaM(d0,p0,h0);
        dm0.add_nota(100, 75);
        h0.add_disciplina(dm0);
        dm0.imprime();
        DisciplinaM dm1 = new DisciplinaM(d1,p0,h0);
        dm1.add_nota(90, 80);
        h0.add_disciplina(dm1);
        dm1.imprime();
        DisciplinaM dm2 = new DisciplinaM(d2,p0,h0);
        dm2.add_nota(80, 90);
        h0.add_disciplina(dm2);
        dm2.imprime();
        DisciplinaM dm21 = new DisciplinaM(d3,p0,h0);
        dm21.add_nota(80, 75);
        h0.add_disciplina(dm21);
        dm21.imprime();
        DisciplinaM dm3 = new DisciplinaM(d14,p3,h0);
                
        /*
        DisciplinaM dm3 = new DisciplinaM(d6,p1,h0);
        dm3.add_nota(50, 75);
        h0.add_disciplina(dm3);
        //DisciplinaM dm4 = new DisciplinaM(d7,p1,h0);
        DisciplinaM dm4 = new DisciplinaM(d5,p0,h0);
        dm4.add_nota(70, 85);
        h0.add_disciplina(dm4);
        DisciplinaM dm5 = new DisciplinaM(d9,p2,h0);
        h0.add_disciplina(dm5);
        DisciplinaM dm6 = new DisciplinaM(d10,p2,h0);
        dm6.add_nota(90, 75);
        h0.add_disciplina(dm6);
        DisciplinaM dm7 = new DisciplinaM(d13,p2,h0);
        dm7.add_nota(100, 90);
        h0.add_disciplina(dm7);
        DisciplinaM dm8 = new DisciplinaM(d14,p3,h0);
        dm8.add_nota(20, 85);
        h0.add_disciplina(dm8);
        DisciplinaM dm9 = new DisciplinaM(d15,p3,h0);
        dm9.add_nota(100, 100);
        h0.add_disciplina(dm9);
        DisciplinaM dm10 = new DisciplinaM(d17,p4,h0);
        dm10.add_nota(100, 75);
        h0.add_disciplina(dm10);
        DisciplinaM dm11 = new DisciplinaM(d4,p4,h0);
        dm11.add_nota(99, 75);
        h0.add_disciplina(dm11);
        //DisciplinaM dm12 = new DisciplinaM(d17,p3,h0);
        /*
        dm0.imprime();
        dm1.imprime();
        dm2.imprime();
        dm3.imprime();
        dm4.imprime();
        //dm4.imprime();
        */
        
        Aluno a = new Aluno("Antonio Carlos", "11611BCC054", 2016 , h0);
        
        
        
        Grade_Curricular g2 = new Grade_Curricular();
        a.falta_dis(g, g2);
        
        //g.mostrar_grade();
        System.out.println("\nGrade Curricular Necessária Para Formar:\n");
        g2.mostrar_grade();
        /****************************CRIANDO CONTROLE ACADEMICO******************************/
        
        /*********************************CRIANDO CURSO**************************************/
        //Curso curso = new Curso("BCC",g,ca);
        /****************************MENU****************************************************/
        /*System.out.println("Bem vindo ao controle de cursos");
        boolean bo = true;
        if(bo)
        {
            System.out.println("Escolha uma opção: \n");
            System.out.print("1.");
            
        }
        */
    }
    
}
