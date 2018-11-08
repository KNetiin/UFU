package prova_questao4;

import java.util.ArrayList;

public class Servidor
{
    ArrayList<Internauta> listai;
    int numero;
    
    public Servidor(int n)
    {
        this.listai = new ArrayList<>();
        this.numero = n;
    }
    
    public boolean verifica_on(String nome)
    {
        for(int i=0; i < this.listai.size(); i++)
        {
            if(nome.equals(this.listai.get(i).nome))
           {
               return(this.listai.get(i).online == EnumOnn.ON);
           }
        }
        return false;
    }
    
    public void enviapara(String nome, String nome1, String mensagem)
    {
        for(int i=0; i<this.listai.size(); i++)
        {
            if(nome.equals(this.listai.get(i).nome))
           {
               this.listai.get(i).recebe(nome1, mensagem);
           }
        }
    }
}
