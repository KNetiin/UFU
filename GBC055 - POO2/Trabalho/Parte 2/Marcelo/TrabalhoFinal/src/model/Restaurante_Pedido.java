package model;

public class Restaurante_Pedido extends Servicos{
    public Restaurante_Pedido()
    {
        super.setId(3);
        super.setOferecido(EnumCargo.Gerente_Restaurante);
    }
    
    public void solicitar_valor(float valor, Reserva reserva)
    {
        super.setPreco(valor);
        super.acrescentarPreco(reserva);
    }
}
