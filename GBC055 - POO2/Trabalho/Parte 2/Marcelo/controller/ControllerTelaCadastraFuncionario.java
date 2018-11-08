
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.awt.event.*;

public class ControllerTelaCadastraFuncionario
{
    TelaCadastraFuncionario visao;
    
    public ControllerTelaCadastraFuncionario(TelaCadastraFuncionario view)
    {
        this.visao = view;
        this.visao.addListenerBotaoCadastrar(new CadastraListener());
    }
    
    class CadastraListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String nome = visao.getTextoNomeFuncionario();
                String cpf = visao.getTextoCPFFuncionario();
                String cargo = visao.getCargoFuncionario();
                String senha = visao.getTextoCampoSenha();
                String salario = visao.getTextoCampoSalario();
                String rua = visao.getTextoCampoRua();
                String ncasa = visao.getTextoCampoNCasa();
                String cidade = visao.getTextoCampoCidade();
                String cep = visao.getTextoCampoCep();
                String bairro = visao.getTextoCampoBairro();
                String telefone = visao.getTextoCampoTelefone();
                
                Endereco endereco;
                
                EnumCargo c = null;
        
                endereco = new Endereco(Integer.parseInt(ncasa),rua,bairro,cidade,Integer.parseInt(cep),Integer.parseInt(telefone));
        
                Funcionario f = null;
        
                switch(cargo)
                {
                    case "Gerente" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),endereco,Integer.parseInt(senha),c.Gerente);break;
                    case "Faxineiro" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),endereco,Integer.parseInt(senha),c.Faxineiro) ;break;
                    case "Recepcionista" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),endereco,Integer.parseInt(senha),c.Recepcionista);break;
                    case "Gerente Restaurante" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),endereco,Integer.parseInt(senha),c.Gerente_Restaurante);break;
                    case "Garcom" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),endereco,Integer.parseInt(senha),c.Garcom);break;
                }
                
                CommunicateDAO dao = new CommunicateDAO();
                dao.registraFuncionario(f);
                
                visao.mostrarMensagem("Cadastro realizado com sucesso");
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
    
    
}
