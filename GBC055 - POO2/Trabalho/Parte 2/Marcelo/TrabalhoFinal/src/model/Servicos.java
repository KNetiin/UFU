package model;

public abstract class Servicos {
    private EnumCargo oferecido;
    private float preco;
    private int id;
    
    public void acrescentarPreco(Reserva reserva)
    {
        if(reserva == null) return;
        reserva.setPreco_total(reserva.getPreco_total() + this.getPreco());
    }

    public EnumCargo getOferecido() {
        return oferecido;
    }

    public void setOferecido(EnumCargo oferecido) {
        this.oferecido = oferecido;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
