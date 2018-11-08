package pratica08;


public class Mario {
    Estado state;
    int pontos;
    
    
    public void setstate(Estado s){
        this.state = s;
    }
    public Mario(){
        this.pontos = 0;
        this.state = new MarioPequeno();
    }
    public void adicionaPts(){
        this.pontos += 1000;
    }
    
    public void pegarCogumelo(){
        this.state.pegarCogumelo(this);
        this.state.escreve(this);
    }
    public void pegarFlor(){
        this.state.pegarFlor(this);
        this.state.escreve(this);
    }
    public void pegarPena(){
        this.state.pegarPena(this);
        this.state.escreve(this);
    }
    public void sofrerAtaque(){
        this.state.sofrerAtaque(this);
        this.state.escreve(this);
    }
}
