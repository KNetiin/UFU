package prova2calc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Prova2Calc
{
   
    public static void main(String[] args)
    {
        JFrame janela = new JFrame("MiniCalc");
        janela.setSize(500,120);
        JPanel panel = new JPanel();
        JTextField espaco1 = new JTextField(10);
        JTextField espaco2 = new JTextField(10);
        JTextField espaco3 = new JTextField(10);
        JTextField espaco4 = new JTextField(10);
        JTextField resultado1 = new JTextField(10);
        JTextField resultado2 = new JTextField(10);
        JButton igual1 = new JButton("=");
        JButton igual2 = new JButton("=");
        JLabel mult = new JLabel("*");
        JLabel som = new JLabel("+");
        
        ActionListener multiplicacao = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    resultado1.setText("" + Integer.parseInt(espaco1.getText()) * Integer.parseInt(espaco2.getText()));
                }
                catch(NumberFormatException f)
                {
                    resultado1.setText("ERROR");
                }
            }
        };
        
        ActionListener soma = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    resultado2.setText("" + (Integer.parseInt(espaco3.getText()) + Integer.parseInt(espaco4.getText())));
                }
                catch(NumberFormatException ef)
                {
                    resultado2.setText("ERROR");
                }
            }
        };
        
        igual1.addActionListener(multiplicacao);
        igual2.addActionListener(soma);
        
        panel.add(espaco1);
        panel.add(mult);
        panel.add(espaco2);
        panel.add(igual1);
        panel.add(resultado1);
        panel.add(espaco3);
        panel.add(som);
        panel.add(espaco4);
        panel.add(igual2);
        panel.add(resultado2);
        
        janela.add(panel,BorderLayout.CENTER);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
        
        
    }
    
    
}
