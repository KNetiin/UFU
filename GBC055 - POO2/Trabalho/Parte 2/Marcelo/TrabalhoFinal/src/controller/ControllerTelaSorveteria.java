
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaSorveteria
{
    TelaSorveteria visao;
    
    public ControllerTelaSorveteria (TelaSorveteria view)
    {
        this.visao = view;
        this.visao.addListenerJButton9(new ConfirmarSorveteListener());
    }
    
    class ConfirmarSorveteListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                int nroquarto = Integer.parseInt(visao.getNumeroQuarto());
                String sorvete = visao.getTextCampoProduto();
                
                String me[] = sorvete.split("+");

                Sorvete copo = null;

                switch(me[0]){
                    case "Sorvete Morango" : copo = new SorveteMorango();
                    case "Sorvete Chocolate" : copo = new SorveteChocolate();
                    case "Sorvete Creme" : copo = new SorveteCreme();
                }

                for(int i = 1;i < me.length;i++){
                    switch(me[i]){
                        case "Calda" : copo = new Calda(copo);
                        case "Chantily" : copo = new Chantily(copo);
                        case "Confete" : copo = new Chocolate(copo);
                    }
                }
                
                CommunicateDAO dao = new CommunicateDAO();

                Reserva reserva = dao.retornaReserva_2(nroquarto);
                reserva.setPreco_total(reserva.getPreco_total() + copo.custo());
                
                visao.mostrarMensagem("Foi adicionado R$" + copo.custo() + " ao valor da reserva");
                
                dao.updateValorReserva(reserva.getSerial(),reserva.getPreco_total());
            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
