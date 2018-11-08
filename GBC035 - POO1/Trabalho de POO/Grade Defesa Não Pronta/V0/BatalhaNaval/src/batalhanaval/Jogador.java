package batalhanaval;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Jogador
{
    final private String nome;
    private ArrayList<Navio> navios = new ArrayList<>();
    
    public Jogador(String nome)
    {
        this.nome = nome;
        
        /************************************INTERFACE********************************/
        JFrame defesa = new JFrame("GRADE DE DEFESA");
        defesa.setSize(450,600);
        
        ImageIcon imgPesquisar = new ImageIcon("Imagens/A1.png");
        JLabel tecla = new JLabel("");
        JPanel p_defesa = new JPanel(new GridLayout(10,10));
        String[] posicao = {"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10",
                            "B1","B2","B3","B4","B5","B6","B7","B8","B9","B10",
                            "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10",
                            "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10",
                            "E1","E2","E3","E4","E5","E6","E7","E8","E9","E10",
                            "F1","F2","F3","F4","F5","F6","F7","F8","F9","F10",
                            "G1","G2","G3","G4","G5","G6","G7","G8","G9","G10",
                            "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10",
                            "I1","I2","I3","I4","I5","I6","I7","I8","I9","I10",
                            "J1","J2","J3","J4","J5","J6","J7","J8","J9","J10"};
        
        ActionListener descobreTecla = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton botaoClicado = (JButton)e.getSource();
                tecla.setText(botaoClicado.getText());
                //System.out.println(tecla.getText());
            }
        };
        
        for(int i=0; i<4; i++)
        {
            ((JButton)p_defesa.add(new JButton(posicao[i],new ImageIcon("Imagens/"+posicao[i]+".png")))).addActionListener(descobreTecla); 
        }
        
        for(int i=4; i<posicao.length; i++)
        {
            ((JButton)p_defesa.add(new JButton(posicao[i],imgPesquisar))).addActionListener(descobreTecla); 
        }
        /*
        for(int i=0; i<posicao.length; i++)
        {
            ((JButton)p_defesa.add(new JButton(posicao[i],imgPesquisar))).addActionListener(descobreTecla); 
        }*/
        
        defesa.add(p_defesa,BorderLayout.CENTER);
        
        defesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        defesa.setVisible(true);
        
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
