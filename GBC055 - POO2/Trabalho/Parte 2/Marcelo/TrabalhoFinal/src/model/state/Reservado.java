package model.state;

import model.Reserva;

public class Reservado extends Estado_Reserva {
    public Reservado(Reserva reserva)
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
        //O CERTO SERIA BUSCAR NO BANCO DE DADOS
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        super.getReserva().setData_entrada(nv_data);
        return "Reserva comeca no dia " + nv_data;
    }
    
    @Override
    public String cancelarReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        super.getReserva().setEstado(new Fechada(super.getReserva()));
        return "Reserva Cancelada!";
    }
    
    @Override
    public String fecharReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva deve ser cancelada, pois não foi aberta!";
    }
    
    @Override
    public void passaDia()
    {
        
    }
}