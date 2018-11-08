package pratica3;

public class Bacon extends Adicional{
    public Bacon(Sanduiche x)
    {
        this.xx = x;
        this.descricao = xx.descricao + ", bacon";
        this.preco = 2.0f;
    }
    
}
