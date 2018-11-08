package pratica3;

public class Catupiry extends Adicional {
    
    public Catupiry(Sanduiche x)
    {
        this.xx = x;
        this.descricao = xx.descricao + ", catupiry";
        this.preco = 3.0f;
    }
}
