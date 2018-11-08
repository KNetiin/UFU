
package pratica3;

public class Pratica3 {
    
    public static void main(String[] args) {
        Sanduiche s1 = new Xtudo();
        Sanduiche s2 = new Xfrango();
        Sanduiche s3 = new Xfile();
        
        s1 = new Bacon(s1);
        s1 = new Bacon(s1);
        s1 = new Salsicha(s1);
        s1 = new Ovo(s1);
        s1 = new Ovo(s1);
        s1 = new Cheddar(s1);
        
        System.out.println( s1.descricao + " : R$" + s1.calcula_preco() );
        
        s2 = new Salsicha(s2);
        s2 = new Bacon(s2);
        s2 = new Ovo(s2);
        s2 = new Catupiry(s2);
        
        System.out.println( s2.descricao + " : R$" + s2.calcula_preco() );
        
        s3 = new Bacon(s3);
        s3 = new Ovo(s3);
    
        System.out.println( s3.descricao + " : R$" + s3.calcula_preco() );
        
        new Botao().setVisible(true);
    }
    
}
