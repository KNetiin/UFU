package model.decorator;

public class Calda extends AdicionalDecorator{
    public Calda(Sorvete sorvete)
    {
        super.setSorvete(sorvete);
        super.setDescricao("Calda");
        super.setValor(1f);
    }
    
    @Override
    public float custo()
    {
        return super.getSorvete().custo() + super.getValor();
    }
    
}