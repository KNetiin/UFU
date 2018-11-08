
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaGerenteRestaurante
{
    TelaGerenteRestaurante visao;
    
    public ControllerTelaGerenteRestaurante(TelaGerenteRestaurante view)
    {
        this.visao = view;
    }
    
    class ConfirmarListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                int numeroQuarto = Integer.parseInt(visao.getNumeroQuarto());
                    
                CommunicateDAO dao = new CommunicateDAO();
                
                Reserva reserva = dao.retornaReserva_2(numeroQuarto);
                reserva.setPreco_total(reserva.getPreco_total() + (float) Double.parseDouble(visao.getPrecoItem()));
                
                visao.mostrarMensagem("Foi adicionado R$" + visao.getPrecoItem() + " ao valor da reserva");
                
                dao.updateValorReserva(reserva.getSerial(),reserva.getPreco_total());/*VERIFICAR*/
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
