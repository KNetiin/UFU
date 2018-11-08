package pratica3;

public class Salsicha extends Adicional{
    
    public Salsicha(Sanduiche x)
    {
        this.xx = x;
        this.descricao = xx.descricao + ", salsicha";
        this.preco = 1.0f;
    }
}
