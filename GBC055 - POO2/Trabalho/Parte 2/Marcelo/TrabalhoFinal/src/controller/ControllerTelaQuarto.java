
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.awt.event.*;

public class ControllerTelaQuarto
{
    TelaQuarto visao;
    
    public ControllerTelaQuarto(TelaQuarto view)
    {
        this.visao = view;
        this.visao.addListenerSolicitaLimpeza(new SolicitarLimpezaListener());
    }
    
    class SolicitarLimpezaListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String nquarto = visao.getNumeroQuarto();
                int quarto = Integer.parseInt(nquarto);
                
                CommunicateDAO dao = new CommunicateDAO();

                Reserva reserva = dao.retornaReserva_2(quarto);
                reserva.getQuarto().solicitarLimpeza(reserva);
                
                dao.updateValorReserva(reserva.getSerial(),reserva.getPreco_total());
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
