package pratica08;


public class MarioVuador extends Estado{
    
     public void escreve(Mario m){
        System.out.println("Mario Avua!");
        System.out.println(m.pontos);
    }
     @Override
   public void pegarCogumelo(Mario m){
        m.adicionaPts();
    }
   @Override
    public void pegarFlor(Mario m){
        m.setstate(new MarioFogo());
    }
   @Override
    public void pegarPena(Mario m){
        m.adicionaPts();
    }
   @Override
    public void sofrerAtaque(Mario m){
       m.setstate(new MarioGrande()); 
    }
}
