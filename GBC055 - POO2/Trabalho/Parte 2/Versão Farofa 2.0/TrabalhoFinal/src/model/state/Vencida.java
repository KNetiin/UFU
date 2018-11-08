package model.state;

import model.Reserva;

public class Vencida extends Estado_Reserva {
    public Vencida(Reserva reserva)
    {
        super.setReserva(reserva);
    }
    
    @Override
    public String prolongarReserva(int qt_dias, String nv_data)
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva Vencida. Favor Iniciar outra";
    }
    
    @Override
    public String adiarReserva(String nv_data)
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva Vencida. Favor Iniciar outra";
    }
    
    @Override
    public String cancelarReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Reserva Vencida. Ja cancelada";
    }
    
    @Override
    public String fecharReserva()
    {
        if(super.getReserva() == null) return "ERRO EM RESERVA!!!";
        return "Não é possível, pois a reserva esta vencida. Favor selecionar uma nova reserva";
    }
    
    @Override
    public void passaDia()
    {
        
    }
}