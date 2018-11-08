package batalhanaval;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;


public class Grade {
    String tipo;
    
    public Grade(String tipo){
        this.tipo = tipo;
        /************************************INTERFACE********************************/
        
        JFrame defesa = new JFrame("GRADE DE " + tipo); //Criação da janela 
        defesa.setSize(730,600);
        defesa.setResizable(false);
        Container contentPane = defesa.getContentPane(); 
       
        JLabel tela = new JLabel("Escolha a posicao para o barco");
        JPanel norte = new JPanel(new FlowLayout(FlowLayout.CENTER));
        norte.add(tela);
        defesa.add(norte,BorderLayout.NORTH);
        
        JLabel tecla = new JLabel("");
        JPanel p_defesa = new JPanel(new GridLayout(10,10));
        JPanel amostra = new JPanel (new GridLayout(5,1));
        contentPane.add(amostra,BorderLayout.EAST); 
        amostra.setSize(200,600);
        String concluido1 = new String("Concluido");
        JButton concluido = new JButton(concluido1);
        concluido.setBackground(new Color(242, 242, 242));      //Botão de concluido embaixo da janela
        concluido.setFont(new Font("HEINEKEN", Font.PLAIN, 22));
        defesa.add(concluido, BorderLayout.SOUTH);

        /*********************************************LAYOUT**************************************************/
        //tela.setBackground(Color.white);
        Color cinzaclaro = new Color(242, 242, 242);
        
        tela.setForeground(new Color(13, 13, 13));
        //p_defesa.setBackground(new Color(176,196,222));
        p_defesa.setBackground(new Color(102,111,224));
        amostra.setBackground(new Color(192,192,192));
        norte.setBackground(cinzaclaro);
        
        Font novaFonte = null;
        try
        {
            novaFonte = Font.createFont(Font.TRUETYPE_FONT, new File("Fontes/HEINEKEN.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fontes/HEINEKEN.ttf")));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(FontFormatException e)
        {
         e.printStackTrace();
        }
        
        Border border = BorderFactory.createLineBorder(new Color(192,192,192), 2);
        norte.setBorder(border);
        tela.setFont(new Font("HEINEKEN", Font.PLAIN, 22));
        
        Border border1 = BorderFactory.createLineBorder(new Color(192,192,192), 3);
        p_defesa.setBorder(border1);
        amostra.setBorder(border1);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        String[] barcos = {"um","dois","tres","quatro","cinco"};
        
        Font barco = new Font("SansSerif", Font.BOLD, 15);
        
        JPanel cinco1 = new JPanel(new GridLayout(2,1));
        JLabel cinco = new JLabel(" 1 x Encouraçado:");
        cinco1.add(cinco);
        cinco.setFont(barco);
        cinco1.add(new JLabel(new ImageIcon("Imagens/Barco/cinco.png")));
        cinco1.setBorder(border1);
        cinco1.setBackground(new Color(255,237,120));
        amostra.add(cinco1);
        
        JPanel quatro1 = new JPanel(new GridLayout(2,1));
        JLabel quatro = new JLabel(" 1 x Cruzador:");
        quatro.setFont(barco);
        quatro1.add(quatro);
        quatro1.add(new JLabel(new ImageIcon("Imagens/Barco/quatro.png")));
        quatro1.setBorder(border1);
        quatro1.setBackground(new Color(255,237,120));
        amostra.add(quatro1);
        
        JPanel tres1 = new JPanel(new GridLayout(2,1));
        JLabel tres = new JLabel(" 2 x Contra Torpedo:");
        tres.setFont(barco);
        tres1.add(tres);
        tres1.add(new JLabel(new ImageIcon("Imagens/Barco/tres.png")));
        tres1.setBorder(border1);
        tres1.setBackground(new Color(255,237,120));
        amostra.add(tres1);
        
        JPanel dois1 = new JPanel(new GridLayout(2,1));
        JLabel dois = new JLabel(" 3 x Destroyer:");
        dois.setFont(barco);
        dois1.add(dois);
        dois1.add(new JLabel(new ImageIcon("Imagens/Barco/dois.png")));
        dois1.setBorder(border1);
        dois1.setBackground(new Color(255,237,120));
        amostra.add(dois1);
        
        JPanel um1 = new JPanel(new GridLayout(2,1));
        JLabel um = new JLabel(" 4 x Submarino:");
        um.setFont(barco);
        um1.add(um);
        um1.add(new JLabel(new ImageIcon("Imagens/Barco/um.png")));
        um1.setBorder(border1);
        um1.setBackground(new Color(255,237,120));
        amostra.add(um1);
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        
        for(int i=0; i<posicao1.length; i++)
        {
            ((JButton)p_defesa.add(new JButton(posicao1[i]+posicao2[i],new ImageIcon("Imagens/Mar/"+posicao1[i]+posicao2[i]+".png")))).addActionListener(descobreTecla); 
        }
        
        defesa.add(p_defesa,BorderLayout.CENTER);
        
        defesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        defesa.setVisible(true);
    }
    
}
