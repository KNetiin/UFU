package questao2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Questao2
{

    public static void main(String[] args)
    {
        JFrame janela = new JFrame();
        janela.setSize(250,80);
        JPanel panel = new JPanel();
        JButton menos = new JButton("--");
        JButton mais = new JButton("++");
        JTextField num = new JTextField(8);
        num.setText("0");
        panel.add(menos);
        panel.add(num);
        panel.add(mais);
        
        ActionListener decremento = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                num.setText("" + (Integer.parseInt(num.getText()) - 1));
            }
        };
        
        ActionListener incremento = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                num.setText("" + (Integer.parseInt(num.getText()) + 1));
            }
        };        
        
        menos.addActionListener(decremento);
        mais.addActionListener(incremento);
        janela.add(panel,BorderLayout.CENTER);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
