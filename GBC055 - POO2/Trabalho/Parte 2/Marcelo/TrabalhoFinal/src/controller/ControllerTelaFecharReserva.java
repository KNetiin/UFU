
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaFecharReserva
{
    TelaFecharReserva visao;
    
    public ControllerTelaFecharReserva(TelaFecharReserva view)
    {
        this.visao = view;
        this.visao.addListenerBotaoPesquisaReserva(new PesquisarReservaListener());
        this.visao.addListenerBotaoFecharReserva(new FecharReservaListener());
    }
    
    class PesquisarReservaListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String codigo = visao.getTextoCampoCodigoReserva();
                CommunicateDAO dao = new CommunicateDAO();
                Reserva reserva;
        
                reserva = dao.retornaReserva(Integer.parseInt(codigo));
                visao.atualizaValorTela("" + reserva.getPreco_total());
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
    
    class FecharReservaListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String codigo = visao.getTextoCampoCodigoReserva();
                CommunicateDAO dao = new CommunicateDAO();
                Reserva reserva;
        
                reserva = dao.retornaReserva(Integer.parseInt(codigo));
                dao.deletaReserva(Integer.parseInt(codigo));
                visao.mostrarMensagem("Reserva fechada com sucesso");
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
