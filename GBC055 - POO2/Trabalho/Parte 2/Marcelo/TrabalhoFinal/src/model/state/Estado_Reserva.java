package model.state;

import model.Reserva;

public abstract class Estado_Reserva {

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
//    private Reserva reserva;
     protected Reserva reserva;
    
    public abstract String prolongarReserva(int qt_dias, String nv_data);
    public abstract String adiarReserva(String nv_data);
    public abstract String cancelarReserva();
    public abstract String fecharReserva();
    public abstract void passaDia();
}
