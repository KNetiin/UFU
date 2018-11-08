package ap7;

import javax.swing.JOptionPane;

public class AP7
{
    static int tam = 2;
    private static final String SEPARADOR = "\n=================================\n";

    
    public static void main(String[] args) 
    {
        Pessoa pessoas[] = new Pessoa[tam];
        String nome;
        String doc;
        float num;
        float ci;
        int opcao;
        
        for(int i = 0; i<tam; i++)
        {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Entre com opcao: 0 - Pessoa Física;  1 - Pessoa Jurídica;"));
            if(opcao == 0)
            {
                nome = JOptionPane.showInputDialog("Entre com o nome da Pessoa");
                doc = JOptionPane.showInputDialog("Entre com o cpf da Pessoa");
                num = Float.parseFloat(JOptionPane.showInputDialog(null, "Entre com o valor dos seus rendimentos "));
                pessoas[i] = new PessoaFisica(nome,doc,num);
                
            }else if(opcao == 1)
            {
                nome = JOptionPane.showInputDialog("Entre com o nome da Empresa");
                doc = JOptionPane.showInputDialog("Entre com o cnpj da Empresa");
                ci = Float.parseFloat(JOptionPane.showInputDialog(null, "Entre com o valor de contribuições isentas "));
                num = Float.parseFloat(JOptionPane.showInputDialog(null, "Entre com o valor do faturamento anual "));           
                pessoas[i] = new PessoaJuridica(nome,doc,ci,num);           
            }else
            {
                JOptionPane.showMessageDialog(null, "Opção Inválida!");
                i--;
            }
        }
        String resultado = "";
        resultado += SEPARADOR;
        for(int j = 0; j<tam; j++)
        {
            resultado += pessoas[j].certificado();
            resultado += SEPARADOR;
        }
        JOptionPane.showMessageDialog(null, resultado);
        
        
    }
    
}
