package janelaagenda;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaAgenda
{
    Agenda agenda = new Agenda();
    
    public JanelaAgenda()
    {
        
        final JLabel titulo = new JLabel("*                              INSIRA OS DADOS                             *");
        final JLabel nome = new JLabel("Nome:        ");
        final JLabel telefone = new JLabel("Telefone:  ");
        final JLabel endereco = new JLabel("Endereço:");
        final JButton procurar = new JButton("Procurar");
        final JButton apagar = new JButton("Apagar");
        final JButton cadastrar = new JButton("Cadastrar");
        final JButton mostrar = new JButton("Mostrar");
        final JTextField contato = new JTextField(30);
        final JTextField campoNome = new JTextField(20);
        final JTextField campoTelefone = new JTextField(20);
        final JTextField campoEndereco = new JTextField(20);
        final JFrame janela = new JFrame("AGENDA TELEFÔNICA");
        final JFrame janelacontato = new JFrame("CONTATO");
        
        janela.setSize(330, 210);
        janelacontato.setSize(500, 100);
        
        JPanel painel = new JPanel();

        painel.add(titulo);
        painel.add(nome);
        painel.add(campoNome);
        painel.add(telefone);
        painel.add(campoTelefone);
        painel.add(endereco);
        painel.add(campoEndereco);
        painel.add(procurar);
        painel.add(apagar);
        painel.add(cadastrar);
        painel.add(mostrar);
        
        procurar.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String n;
                n = campoNome.getText();
                boolean baum = false;
                for(int i = 0; i < agenda.pessoas.size(); i++)
                {
                    if(n.equals(agenda.pessoas.get(i).getNome()))
                    {
                        contato.setText("Nome: " + agenda.pessoas.get(i).getNome() + " | End: " + agenda.pessoas.get(i).getEnd() + " | Telefone: " + agenda.pessoas.get(i).geTelefone() );
                        janelacontato.setVisible(true);
                        baum = true;
                    }
                    
                }
                if(baum == false)
                {
                    contato.setText("Contato não cadastrado!");
                    janelacontato.setVisible(true);
                }
            }
        });
        
        cadastrar.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String n = campoNome.getText();
                String n1 = campoEndereco.getText();
                int n2 = Integer.parseInt(campoTelefone.getText());
                Pessoa p = new Pessoa(n,n1,n2);
                agenda.pessoas.add(p);
            }
        });
        
        apagar.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String n;
                n = campoNome.getText();
                boolean baum = false;
                for(int i = 0; i < agenda.pessoas.size(); i++)
                {
                    if(n.equals(agenda.pessoas.get(i).getNome()))
                    {
                        agenda.pessoas.remove(agenda.pessoas.get(i));
                        baum = true;
                        JOptionPane.showMessageDialog(null, "REMOÇÃO BEM SUCEDIDA");
                    }
                    
                }
                if(baum == false)
                {
                    JOptionPane.showMessageDialog(null, "CONTATO INEXISTENTE");
                }
            }
        });
        
        mostrar.addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String resultado = "";
                for(int i = 0; i < agenda.pessoas.size(); i++)
                {
                    resultado += agenda.pessoas.get(i).getNome() + "\n";
                }
                JOptionPane.showMessageDialog(null, resultado);
            }
        });
        
        
        janelacontato.getContentPane().add(contato);
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelacontato.dispose();
        janela.setVisible(true);
    }


    public static void main(String[] args) 
    {
        new JanelaAgenda();
    }
    
}
