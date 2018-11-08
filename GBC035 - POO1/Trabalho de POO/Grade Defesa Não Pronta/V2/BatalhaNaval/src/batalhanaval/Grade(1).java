package batalhanaval;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Grade {
    String tipo;
    
    public Grade(String tipo){
        this.tipo = tipo;
        /************************************INTERFACE********************************/
        
        JFrame defesa = new JFrame("GRADE DE " + tipo); //Criação da janela 
        defesa.setSize(650,600);
        defesa.setResizable(false);
        Container contentPane = defesa.getContentPane(); 
        
        ImageIcon imgPesquisar = new ImageIcon("Imagens/A1.png");
        JLabel tecla = new JLabel("");
        JPanel p_defesa = new JPanel(new GridLayout(10,10));
        JPanel amostra = new JPanel (new GridLayout(12,1));
        contentPane.add(amostra,
BorderLayout.EAST); 
        amostra.setSize(200,600);
        amostra.add(new JLabel ("Aqui vai ficar a coluna zika lá!"));

        String[] posicao1 = {"A","A","A","A","A","A","A","A","A","A",
                            "B","B","B","B","B","B","B","B","B","B",
                            "C","C","C","C","C","C","C","C","C","C",
                            "D","D","D","D","D","D","D","D","D","D",
                            "E","E","E","E","E","E","E","E","E","E",
                            "F","F","F","F","F","F","F","F","F","F",
                            "G","G","G","G","G","G","G","G","G","G",
                            "H","H","H","H","H","H","H","H","H","H",
                            "I","I","I","I","I","I","I","I","I","I",
                            "J","J","J","J","J","J","J","J","J","J"};
        
        String[] posicao2 = {"1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10",
                            "1","2","3","4","5","6","7","8","9","10"};
        
        
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
            ((JButton)p_defesa.add(new JButton(posicao1[i]+posicao2[i],new ImageIcon("Imagens/"+posicao1[i]+posicao2[i]+".png")))).addActionListener(descobreTecla); 
        }
        
        for(int i=4; i<posicao1.length; i++)
        {
            ((JButton)p_defesa.add(new JButton(posicao1[i]+posicao2[i],imgPesquisar))).addActionListener(descobreTecla); 
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
    
}
