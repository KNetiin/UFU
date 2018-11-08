
package controller;

import trabalhofinal.*;
import model.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaSolicitaItem
{
    TelaSolicitaItem visao;
    
    public ControllerTelaSolicitaItem(TelaSolicitaItem view)
    {
        this.visao = view;
        this.visao.addListenerBotaoEfetuaPedido(new EfetuaPedidoListener());
    }
    
    class EfetuaPedidoListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String cod = visao.getTextoCampoCod();
                
                if(cod==null || cod.trim().equals(""))
                {
                    visao.mostrarMensagem("Digite o codigo do item para efetuar o pedido");
                }
                else
                {
                    int quarto = Integer.parseInt(visao.getNumeroQuarto());
                    int consumivel = Integer.parseInt(visao.getTextoCampoCod());

                    CommunicateDAO dao = new CommunicateDAO();
                    Reserva reserva = dao.retornaReserva_2(quarto);
                    ArrayList<Consumiveis> frigobar = dao.retornaConsumiveis(0);

                    for(Consumiveis item:frigobar){
                        if(consumivel == item.getId()){
                            dao.updateValorReserva(reserva.getSerial(),reserva.getPreco_total() + item.getPreco_uni());
                        }
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



    