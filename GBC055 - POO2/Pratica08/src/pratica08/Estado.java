package pratica08;


public abstract class Estado {
    
    public abstract void escreve(Mario m);
    public abstract void pegarCogumelo(Mario m);
    public abstract void pegarFlor(Mario m);
    public abstract void pegarPena(Mario m);
    public abstract void sofrerAtaque(Mario m);
}
