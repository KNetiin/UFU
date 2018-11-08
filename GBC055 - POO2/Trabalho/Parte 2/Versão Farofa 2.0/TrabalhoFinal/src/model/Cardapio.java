package model;

import java.util.ArrayList;

public class Cardapio {
    static public ArrayList<Consumiveis> cardapio = new ArrayList<>();
    public ArrayList<Consumiveis> getCardapio() {
        return cardapio;
    }

    public void setCardapio(ArrayList<Consumiveis> cardapio) {
        Cardapio.cardapio = cardapio;
    }
    
   public void adiciona_item(Consumiveis x)
   {
       Cardapio.cardapio.add(x);
   }
   
   public Consumiveis seleciona_item(int id)
   {
       for(int i = 0; i < Cardapio.cardapio.size(); i++)
       {
           if(Cardapio.cardapio.get(i).getId() == id) return Cardapio.cardapio.get(i);
       }
       return null;
   }
}
