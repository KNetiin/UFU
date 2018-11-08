package pratica08;


public class Morto extends Estado{
    
    public void escreve(Mario m){
        System.out.println("Mario Morreu!");
        System.out.println(m.pontos);
    }
    @Override
   public void pegarCogumelo(Mario m){
        System.out.println("Mario Morreu!");
    }
   @Override
    public void pegarFlor(Mario m){
       System.out.println("Mario Morreu!");
    }
   @Override
    public void pegarPena(Mario m){
        System.out.println("Mario Morreu!");
    }
   @Override
    public void sofrerAtaque(Mario m){
      System.out.println("Mario Morreu!");
    }
    
}
