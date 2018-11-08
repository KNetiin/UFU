package simple.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class SimpleCalc
{
    public SimpleCalc()
    {
        JFrame janela = new JFrame("Simple Calc");
        janela.setSize(300, 400);
        
        JLabel visor = new JLabel(" ");
        visor.setHorizontalAlignment(JLabel.RIGHT);
        
        JPanel painel1 = new JPanel(new GridLayout(4,3));
        JPanel painel2 = new JPanel(new GridLayout(5,1));
        JPanel painel3 = new JPanel();
        
        //((FlowLayout)painel3.getLayout()).setVgap(0);
        
        JButton clear = new JButton("Clear");
        painel3.add(clear);
        
        String[] numeros = {"1","2","3","4","5","6","7","8","9",null,"0",null};
        String[] op = {"+","-","*","/","="};
        
        //for (int i = 0; i < numeros.length; i++) painel1.add(new Button(numeros[i]));
        //for (int j = 0; j < op.length; j++) painel2.add(new Button(op[j]));    
        
        janela.add(visor, BorderLayout.NORTH);
        janela.add(painel1, BorderLayout.CENTER);
        janela.add(painel2, BorderLayout.EAST);
        janela.add(painel3, BorderLayout.SOUTH);
        
        janela.pack();
        
        ActionListener trataTecla = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton botaoClicado = (JButton)e.getSource();
                visor.setText(visor.getText()+ botaoClicado.getText());
        }};
        
        for(int i=0; i<numeros.length; i++)
        {
            ((JButton)painel1.add(new JButton(numeros[i]))).addActionListener(trataTecla); 
        }
        for(int j=0; j<op.length; j++)
        {
            ((JButton)painel2.add(new JButton(op[j]))).addActionListener(trataTecla); 
        }
        
        clear.addActionListener (new ActionListener() {
        public void actionPerformed (ActionEvent e) {
            visor.setText(" ");
        }
        });
         
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
    public static void main(String[] args)
    {
        new SimpleCalc();
        
    }
    
}
