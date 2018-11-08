package model.decorator;

public class Chocolate extends AdicionalDecorator{
    public Chocolate(Sorvete sorvete)
    {
        super.setSorvete(sorvete);
        super.setDescricao("Chocolate");
        super.setValor(1f);
    }
    
    @Override
    public float custo()
    {
        return super.getSorvete().custo() + super.getValor();
    }
    
}