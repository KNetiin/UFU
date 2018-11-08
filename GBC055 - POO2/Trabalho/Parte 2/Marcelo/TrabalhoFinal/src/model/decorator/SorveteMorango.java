package model.decorator;

public class SorveteMorango extends Sorvete{
    public SorveteMorango(){
        super.setDescricao("SorveteMorango");
        super.setValor(5.5f);
    }
    
    @Override
    public float custo()
    {
        return super.getValor();
    }
}
