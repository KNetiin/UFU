package model.decorator;

public abstract class Sorvete {
    private float valor;
    private String descricao;
    
    /*public Sorvete(String descricao, int valor)
    {
        this.descricao = descricao;
        this.valor = valor;
    }*/

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public abstract float custo();

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
