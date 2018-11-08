package model.decorator;

public class SorveteCreme extends Sorvete{
    public SorveteCreme(){
        super.setDescricao("SorveteCreme");
        super.setValor(4.5f);
    }
    
    @Override
    public float custo()
    {
        return super.getValor();
    }
}
