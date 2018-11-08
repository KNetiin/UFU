
package controller;

import trabalhofinal.*;
import model.*;
import model.decorator.*;
import view.*;
import dao.*;
import java.util.*;
import java.awt.event.*;

public class ControllerTelaAbrirReserva
{
    TelaAbrirReserva visao;
    
    public ControllerTelaAbrirReserva(TelaAbrirReserva view)
    {
        this.visao = view;
        this.visao.addListenerBotaoEfetuarReserva(new AbrirReservaListener());
    }
    
    class AbrirReservaListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String cpf = visao.getTextoCampoCpf();
                String numeroquarto = visao.getTextoCampoNumQuarto();
                String dataentrada = visao.getTextoCampoDataEntrada();
                String datasaida = visao.getTextoCampoDataSaida();
                String codigoreserva = visao.getTextoCampoCodigoReserva();
                String cpf1 = visao.getTextoCampoAC1();
                String cpf2 = visao.getTextoCampoAC2();
                String cpf3 = visao.getTextoCampoAC3();
                String cpf4 = visao.getTextoCampoAC4();
                
                CommunicateDAO dao = new CommunicateDAO();
                
                Reserva r;
                Hospede h;
                ArrayList<Hospede> a = new ArrayList<Hospede>();
                Quarto q = dao.retornaQuarto(Integer.parseInt(numeroquarto));

                if(cpf1 != null){
                    h = dao.retornaHospede(Integer.parseInt(cpf1));
                    a.add(h);
                }
                if(cpf2 != null){
                    h = dao.retornaHospede(Integer.parseInt(cpf2));
                    a.add(h);
                }
                if(cpf3 != null){
                    h = dao.retornaHospede(Integer.parseInt(cpf3));
                    a.add(h);
                }
                if(cpf4 != null){
                    h = dao.retornaHospede(Integer.parseInt(cpf4));
                    a.add(h);
                }

                h = dao.retornaHospede(Integer.parseInt(cpf));
                r = new Reserva(Integer.parseInt(codigoreserva),h,null,dataentrada,datasaida,a,(float) 0.00,null);

                String entrada[] = r.getData_entrada().split("/");
                String saida[]   = r.getData_saida().split("/");

                int dia_entrada = Integer.parseInt(entrada[0]);
                int dia_saida = Integer.parseInt(saida[0]);

                int mes_entrada = Integer.parseInt(entrada[1]);
                int mes_saida = Integer.parseInt(saida[1]);        

                if(mes_entrada == mes_saida){
                    r.setPreco_total(q.getValor_diaria()*(dia_saida - dia_entrada));
                } else {
                    r.setPreco_total(q.getValor_diaria()*(30 - dia_entrada + 30*(mes_saida - mes_entrada - 1) + dia_saida));
                }

                dao.registraReserva(r);
                visao.mostrarMensagem("Reserva registrada com sucesso");

            }
            catch (Exception erro)
            {
                visao.mostrarMensagem("Falha por causa do seguinte erro: " + erro);
            }
        }
    }
}
