package model.state;

import model.Reserva;

public class Fechada extends Estado_Reserva {
    
    public Fechada(Reserva reserva)
    {
        super.setReserva(reserva);
    }
    
    @Override
    public String prolongarReserva(int qt_dias, String nv_data)
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Não é possível, pois a reserva está fechada. Favor criar uma nova reserva";
    }
    
    @Override
    public String adiarReserva(String nv_data)
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Não é possível, pois a reserva está fechada. Favor criar uma nova reserva";
    }
    
    @Override
    public String cancelarReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Não é possível, pois a reserva já foi aberta. Favor selecionar uma nova reserva";
    }
    
    @Override
    public String fecharReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Não é possível, pois a reserva já está fechada. Favor selecionar uma nova reserva";
    }

    @Override
    public void passaDia()
    {
        
    }
}