package janelaagenda;

import javax.swing.*;

public class JanelaAgenda
{
    public JanelaAgenda()
    {
        final JLabel titulo = new JLabel("INSIRA OS DADOS");
        final JLabel nome = new JLabel("Nome:");
        final JLabel telefone = new JLabel("Telefone:");
        final JLabel endereco = new JLabel("Endereço:");
        final JButton procurar = new JButton("Procurar");
        final JButton apagar = new JButton("Apagar");
        final JButton cadastrar = new JButton("Cadastrar");
        final JTextField campoNome = new JTextField(20);
        final JTextField campoTelefone = new JTextField(20);
        final JTextField campoEndereco = new JTextField(20);
        final JFrame janela = new JFrame("AGENDA TELEFÔNICA");
        janela.setSize(500, 300);
        
        JPanel painel = new JPanel();



        //painel.add(titulo);
        painel.add(nome);
        painel.add(campoNome);
        painel.add(telefone);
        painel.add(campoTelefone);
        painel.add(endereco);
        painel.add(campoEndereco);
        painel.add(procurar);
        painel.add(apagar);
        painel.add(cadastrar);
        
        janela.getContentPane().add(painel);
        
        janela.setVisible(true);
    }


    public static void main(String[] args) 
    {
        new JanelaAgenda();
    }
    
}
