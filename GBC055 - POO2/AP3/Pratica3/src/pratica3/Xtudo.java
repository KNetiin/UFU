package pratica3;

public class Xtudo extends Sanduiche{

    public Xtudo(){
        this.descricao = "Xtudo";
        this.preco = 10.0f;        
    }
    
    @Override
    public float calcula_preco() {
    
        return this.preco;
    }
    
    
}
