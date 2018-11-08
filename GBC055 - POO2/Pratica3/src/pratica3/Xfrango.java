package pratica3;

public class Xfrango extends Sanduiche {

    public Xfrango(){
        this.descricao = "Xfrango";
        this.preco = 12.0f;
    }
    
    @Override
    public float calcula_preco() {
    
        return this.preco;
    }
    
}
