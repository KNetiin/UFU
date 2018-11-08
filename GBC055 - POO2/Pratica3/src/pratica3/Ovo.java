package pratica3;

public class Ovo extends Adicional{
    public Ovo(Sanduiche x)
    {
        this.xx = x;
        this.descricao = xx.descricao + ", ovo";
        this.preco = 0.5f;
    }
}
