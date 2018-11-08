
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.awt.event.*;

public class ControllerPrincipal
{
    Principal visao;
    
    public ControllerPrincipal(Principal view)
    {
        this.visao = view;
        this.visao.addListenerBotaoHospede(new HospedeListener());
    }
    
    class HospedeListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String numeroQuarto;
                
                numeroQuarto = visao.getTextoCampoQuarto();
                
                if((numeroQuarto == null) || (numeroQuarto.trim().equals("")))
                {
                    visao.mostrarMensagem("Digite o numero do quarto antes de entrar no sistema");
                }
                else
                {
                    CommunicateDAO dao = new CommunicateDAO();
                    Quarto quarto = dao.retornaQuarto(Integer.parseInt(numeroQuarto));
                    
                    if(quarto != null)
                    {
                        visao.dispose();
                        TelaQuarto telaQuarto = new TelaQuarto(numeroQuarto);
                    }
                    else
                    {
                        visao.mostrarMensagem("Este quarto nao existe");
                        visao.limparCampos();
                    }
                }
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
