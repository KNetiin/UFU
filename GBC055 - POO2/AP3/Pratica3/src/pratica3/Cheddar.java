package pratica3;

public class Cheddar extends Adicional {
    public Cheddar(Sanduiche x)
    {
        this.xx = x;
        this.descricao = xx.descricao + ", cheddar";
        this.preco = 1.5f;
    }
}
