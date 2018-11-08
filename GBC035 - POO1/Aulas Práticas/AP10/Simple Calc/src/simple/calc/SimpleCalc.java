package simple.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class SimpleCalc
{
    int registrador;
    String x;
    
    public SimpleCalc()
    {
        registrador = 0;
        JFrame janela = new JFrame("Simple Calc");
        janela.setSize(200, 300);
        
        JLabel visor = new JLabel("0");
        visor.setHorizontalAlignment(JLabel.RIGHT);
        
        JPanel painel1 = new JPanel(new GridLayout(4,3));
        JPanel painel2 = new JPanel(new GridLayout(5,1));
        JPanel painel3 = new JPanel();
        
        //((FlowLayout)painel3.getLayout()).setVgap(0);
        
        JButton clear = new JButton("Clear");
        /*
        JButton soma = new JButton("+");
        JButton subtracao = new JButton("-");
        JButton multiplicacao = new JButton("*");
        JButton divisao = new JButton("/");
        */
        JButton igual = new JButton("=");
        painel3.add(clear);
        
        String[] numeros = {"1","2","3","4","5","6","7","8","9",null,"0",null};
        String[] op = {"+","-","*","/"};
        
        //for (int i = 0; i < numeros.length; i++) painel1.add(new Button(numeros[i]));
        //for (int j = 0; j < op.length; j++) painel2.add(new Button(op[j]));    
        
        janela.add(visor, BorderLayout.NORTH);
        janela.add(painel1, BorderLayout.CENTER);
        janela.add(painel2, BorderLayout.EAST);
        janela.add(painel3, BorderLayout.SOUTH);
                
        ActionListener trataTecla = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton botaoClicado = (JButton)e.getSource();
                //visor.setText("" + Float.parseFloat(visor.getText()+ botaoClicado.getText()));
                visor.setText("" + Integer.parseInt(visor.getText()+ botaoClicado.getText()));
        }};
        
        ActionListener trataTecla2 = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton botaoClicado = (JButton)e.getSource();
                x = botaoClicado.getText();
                registrador = Integer.parseInt(visor.getText());
                visor.setText("0");
                
        }};
        
        for(int i=0; i<numeros.length; i++)
        {
            ((JButton)painel1.add(new JButton(numeros[i]))).addActionListener(trataTecla); 
        }
        for(int j=0; j<op.length; j++)
        {
            ((JButton)painel2.add(new JButton(op[j]))).addActionListener(trataTecla2); 
        }
        painel2.add(igual);
        
        
        igual.addActionListener (new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if("+".equals(x))
                {
                    //registrador = registrador + Float.parseFloat(visor.getText());
                    registrador = registrador + Integer.parseInt(visor.getText());
                    visor.setText("" + registrador);
                }else if("-".equals(x))
                {
                    //registrador = registrador - Float.parseFloat(visor.getText());
                    registrador = registrador - Integer.parseInt(visor.getText());
                    visor.setText("" + registrador);                    
                }else if("*".equals(x))
                {
                    //registrador = registrador * Float.parseFloat(visor.getText());
                    registrador = registrador * Integer.parseInt(visor.getText());
                    visor.setText("" + registrador);
                }else if("/".equals(x))
                {
                    if(Integer.parseInt(visor.getText()) == 0)
                    {
                        visor.setText("0");
                    }else
                    {
                        //registrador = registrador / Float.parseFloat(visor.getText());
                        registrador = registrador / Integer.parseInt(visor.getText());
                        visor.setText("" + registrador);                       
                    }
                }
                x = "";
            }
        });
        
        
        clear.addActionListener (new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                visor.setText("0");
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
