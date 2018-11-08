package model.decorator;

public class SorveteChocolate extends Sorvete{
    public SorveteChocolate(){
        super.setDescricao("SorveteChocolate");
        super.setValor(6.25f);
    }
    
    @Override
    public float custo()
    {
        return super.getValor();
    }
}
