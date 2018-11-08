
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaEditarReserva
{
    TelaEditarReserva visao;
    
    public ControllerTelaEditarReserva(TelaEditarReserva view)
    {
        this.visao = view;
        this.visao.addListenerBotaoConfirma(new ConfirmarEdicaoListener());
        this.visao.addListenerBotaoCancelaReserva(new CancelarReservaListener());
    }
    
    class ConfirmarEdicaoListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String codigo = visao.getTextoCampoCodReserva();
                String dataentrada = visao.getTextoCampoAdiaReserva();
                String datasaida = visao.getTextoCampoProlongaReserva();
                Reserva reserva;

                CommunicateDAO dao = new CommunicateDAO();
                
                reserva = dao.retornaReserva(Integer.parseInt(codigo));

                if(dataentrada != null){
                    reserva.setData_entrada(dataentrada);
                }

                if(datasaida != null){
                    reserva.setData_saida(datasaida);
                }

                dao.deletaReserva(Integer.parseInt(codigo));
                dao.registraReserva(reserva);
                
                visao.mostrarMensagem("Reserva editada com sucesso");
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
    
    class CancelarReservaListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                /*COMO CANCELAR A RESERVA*/
                visao.mostrarMensagem("Reserva cancelada com sucesso");
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
