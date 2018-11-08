
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaCadastraHospede
{
    TelaCadastraHospede visao;
    
    public ControllerTelaCadastraHospede(TelaCadastraHospede view)
    {
        this.visao = view;
        this.visao.addListenerBotaoCadastrar(new CadastrarHospedeListener());
    }
    
    class CadastrarHospedeListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String nome = visao.getTextoCampoNome();
                String cpf = visao.getTextoCampoCPF();
                String telefone = visao.getTextoCampoTelefone();
                String cep = visao.getTextoCampoCep();
                String rua = visao.getTextoCampoRua();
                String numeroCasa = visao.getTextoCampoNumeroCasa();
                String bairro = visao.getTextoCampoBairro();
                String cidade = visao.getTextoCampoCidade();
                
                CommunicateDAO dao = new CommunicateDAO();
                
                Hospede h;
                Endereco end;
        
                end = new Endereco(Integer.parseInt(numeroCasa),rua,bairro,cidade,Integer.parseInt(cep),Integer.parseInt(telefone));
                h = new Hospede(nome,Integer.parseInt(cpf),0,end,null);
        
                dao.registraHospede(h);
                
                visao.mostrarMensagem("Hospede cadastrado com sucesso");
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
