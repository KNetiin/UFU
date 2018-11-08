package academico.ui;

import academico.dominio.cursos.*;
import academico.dominio.matriculas.*;
import academico.dominio.pessoas.*;
import javax.swing.JOptionPane;

public class ControleAcademico
{

    public static void main(String[] args)
    {
        Disciplina pp = new Disciplina("PP");
        Disciplina aed1 = new Disciplina("AED1");
        Disciplina poo1 = new Disciplina("POO1");
        GradeCurricular grade = new GradeCurricular();
        grade.incluiDisciplina(pp);
        //pp.incluiNaGrade(grade); Seria um bad smell: feature envy
        grade.incluiDisciplina(aed1);
        grade.incluiDisciplina(poo1);
        Professor profMarcelo = new Professor("Marcelo", "FACOM");
        Aluno alunoSeverino = new Aluno(JOptionPane.showInputDialog("Entre com o nome do aluno:"), grade);
        
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        
        OfertaTurma ofertaPP = new OfertaTurma(2015, Semestre.SEGUNDO, pp);
        alunoSeverino.getHistorico().matriculaDisciplina(ofertaPP);
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));

        OfertaTurma ofertaAED1 = new OfertaTurma(2016, Semestre.PRIMEIRO, aed1);
        alunoSeverino.getHistorico().matriculaDisciplina(ofertaAED1);

        OfertaTurma ofertaPOO1 = new OfertaTurma(2016, Semestre.PRIMEIRO, poo1);
        alunoSeverino.getHistorico().matriculaDisciplina(ofertaPOO1);
        
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        
        alunoSeverino.getHistorico().registraResultado(pp, 60);
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        alunoSeverino.getHistorico().registraResultado(aed1, 60);       
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        alunoSeverino.getHistorico().registraResultado(poo1, 60);
        JOptionPane.showMessageDialog(null,"O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));
        //System.out.println("O aluno " + alunoSeverino.getNomes() + " está " + (alunoSeverino.verificaSeFormou() ? "formado!" : "ainda cursando"));

    }
    
}
