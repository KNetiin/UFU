package model.decorator;

public class Confete extends AdicionalDecorator{
    public Confete(Sorvete sorvete)
    {
        super.setSorvete(sorvete);
        super.setDescricao("Confete");
        super.setValor(1f);
    }
    
    @Override
    public float custo()
    {
        return super.getSorvete().custo() + super.getValor();
    }
    
}