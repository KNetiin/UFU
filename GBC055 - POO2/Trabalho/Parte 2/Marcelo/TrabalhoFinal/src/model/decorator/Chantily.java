package model.decorator;

public class Chantily extends AdicionalDecorator{
    public Chantily(Sorvete sorvete)
    {
        super.setSorvete(sorvete);
        super.setDescricao("Chantily");
        super.setValor(1f);
    }
    
    @Override
    public float custo()
    {
        return super.getSorvete().custo() + super.getValor();
    }
    
}