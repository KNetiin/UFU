package loja;

public abstract class Cliente {
    String nome;
    String endereco;
    
    public Cliente(String n, String e)
    {
        this.nome = n;
        this.endereco = e;
    }
    
    public abstract void mala_direta();
    
}
