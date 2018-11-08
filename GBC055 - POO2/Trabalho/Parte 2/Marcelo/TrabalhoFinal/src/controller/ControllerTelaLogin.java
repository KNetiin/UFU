
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.awt.event.*;

public class ControllerTelaLogin
{
    TelaLogin visao;
    
    public ControllerTelaLogin(TelaLogin view)
    {
        this.visao = view;
        this.visao.addListenerBotaoEntrar(new EntrarListener());
    }
    
    class EntrarListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String cpf = visao.getTextoCampoCPF();
                String senha = visao.getTextoCampoSenha();
                String cargoFuncionario;
                
                CommunicateDAO dao = new CommunicateDAO();
                Funcionario funcionario = dao.retornaFuncionario(Integer.parseInt(cpf));
                
                cargoFuncionario = funcionario.getCargo().toString();
                
                if(cargoFuncionario == "Gerente")
                {
                    visao.dispose();
                    TelaGerente telagerente = new TelaGerente();
                    visao.mostrarMensagem("Login efetuado com sucesso para Gerente");
                }
                else if (cargoFuncionario == "Gerente Restaurante")
                {
                    visao.dispose();
                    TelaGerenteRestaurante telagerestaurante = new TelaGerenteRestaurante();
                    visao.mostrarMensagem("Login efetuado com sucesso para Gerente do Restaurante");
                }
                else if(cargoFuncionario == "Recepcionista")
                {
                    visao.dispose();
                    TelaRecepcionista telarecepcionista = new TelaRecepcionista();
                    visao.mostrarMensagem("Login efetuado com sucesso para Recepcionista");
                }
                else
                {
                    visao.limparCampos();
                    visao.mostrarMensagem("Esse funcionario nao possui login");
                }
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
