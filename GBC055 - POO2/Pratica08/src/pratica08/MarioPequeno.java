package pratica08;


public class MarioPequeno extends Estado{
    
     public void escreve(Mario m){
        System.out.println("Mario Pequeno!");
         System.out.println(m.pontos);
    }
   @Override
   public void pegarCogumelo(Mario m){
        m.setstate(new MarioGrande());
    }
   @Override
    public void pegarFlor(Mario m){
        m.setstate(new MarioFogo());
    }
   @Override
    public void pegarPena(Mario m){
        m.setstate(new MarioVuador());
    }
   @Override
    public void sofrerAtaque(Mario m){
       m.setstate(new Morto()); 
    }
}
