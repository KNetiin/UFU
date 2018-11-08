package model.state;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Reserva;

public class Aberta extends Estado_Reserva{
    
    public Aberta(Reserva reserva)
    {
        super.setReserva(reserva);
    }
    
    @Override
    public String prolongarReserva(int qt_dias, String nv_data)
    {
        //O CERTO SERIA BUSCAR NO BANCO DE DADOS
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        super.getReserva().setData_saida(nv_data);
        super.getReserva().setPreco_total(super.getReserva().getPreco_total() + (super.getReserva().getQuarto().getValor_diaria() * qt_dias));
        return "Reserva termina em " + super.getReserva().getData_saida() + ". Com um valor total de R$" + super.getReserva().getPreco_total();
    }
    
    @Override
    public String adiarReserva(String nv_data)
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva ja iniciada. Não é possível adiar";
    }
    
    @Override
    public String cancelarReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva ja iniciada. Não é possível cancelar";
    }
    
    @Override
    public String fecharReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        super.getReserva().setEstado(new Fechada(super.getReserva()));
        return "Reserva Fechada, favor pagar R$" + super.getReserva().getPreco_total();
    }
    
    @Override
    public void passaDia()
    {
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
           LocalDateTime now = LocalDateTime.now();
           String data = now.format(dtf);

           String[] dataataul = data.split("/");
           String[] datareserva = reserva.getData_saida().split("/");
           
           for(int i = 0;i < 3;i++){
               
           }
    }
}