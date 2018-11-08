package model.decorator;

public abstract class AdicionalDecorator extends Sorvete {
    private Sorvete sorvete;

    public Sorvete getSorvete() {
        return sorvete;
    }

    public void setSorvete(Sorvete sorvete) {
        this.sorvete = sorvete;
    }
    
    @Override
    public String getDescricao()
    {
        if(this.sorvete == null) return this.getSorvete().getDescricao();
        else return this.getSorvete().getDescricao() + super.getDescricao();
    }
    
}
