
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.awt.event.*;

public class ControllerTelaRemoveFuncionario
{
    TelaRemoveFuncionario visao;
    
    public ControllerTelaRemoveFuncionario(TelaRemoveFuncionario view)
    {
        this.visao = view;
        this.visao.addListenerBotaoConfirmar(new ConfirmarListener());
    }
    
    class ConfirmarListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String cpf = visao.getTextoCampoCPF();
                
                CommunicateDAO dao = new CommunicateDAO();
                dao.removeFuncionario(Integer.parseInt(cpf));
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
