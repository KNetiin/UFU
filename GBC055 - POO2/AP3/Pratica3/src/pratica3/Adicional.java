
package pratica3;


public abstract class Adicional extends Sanduiche {
    
    Sanduiche xx;
    
    public float calcula_preco()
    {
        return this.preco + xx.calcula_preco();
    }
}
