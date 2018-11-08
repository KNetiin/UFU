package pratica3;

public class Xfile extends Sanduiche {

    public Xfile(){
        this.descricao = "Xfile";
        this.preco = 14.0f;
    }
    
    @Override
    public float calcula_preco() {
    
        return this.preco;
    }
    
}
