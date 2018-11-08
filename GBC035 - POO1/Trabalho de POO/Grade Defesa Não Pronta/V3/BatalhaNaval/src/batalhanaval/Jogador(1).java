package batalhanaval;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Jogador
{
    final private String nome;
    private ArrayList<Navio> navios = new ArrayList<>();
    public Grade grade;
    
    public Jogador(String nome)
    {
        this.grade = new Grade("DEFESA");
        this.nome = nome;
        
        /**********************************CONF DA TELA DE MENSAGEM*************
        JFrame notificacao = new JFrame("Mensagem");
        notificacao.setSize(300,50);
        JPanel not = new JPanel(new GridLayout(1,1));
        JLabel tela = new JLabel("POHAAAAA");
        not.add(tela);
        notificacao.add(not,BorderLayout.CENTER);
        /////////////////////////////////////////////////////////////////////////
        
        tela.setText("Escolha uma posição para seu navio");
        notificacao.setVisible(true);*/
        
        
        
        
    }
    
    public void adiciona_navio(Navio n)
    {
        navios.add(n);
    }
    
    public Navio getNavio(int posicao)
    {
        return this.navios.get(posicao);
    }
}
