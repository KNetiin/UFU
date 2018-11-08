package model;

public class Comida_Quarto extends Servicos{
    public Comida_Quarto()
    {
        super.setId(2);
        super.setOferecido(EnumCargo.Gerente_Restaurante);
    }
    public void solicitaItemCardapio(int id, Reserva reserva)
    {
        Cardapio x = new Cardapio();
        x.setCardapio(Cardapio.cardapio);
        if(x == null) return;
        super.setPreco(x.seleciona_item(id).getPreco_uni());
        super.acrescentarPreco(reserva);
    }
    
}
