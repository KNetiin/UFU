package teste;
import java.util.*;

public class Jogo
{
    ArrayList<Jogador> jogadores;
    boolean fim;
    int k;
    
    public Jogo(int n)
    {
        Scanner leitor = new Scanner(System.in);
        String ler;
        this.fim = false;
        this.jogadores = new ArrayList<>();
        this.k = 20;
        
        for(int i = 0; i<n; i++)
        {
            System.out.println("Digite o nome do jogador: ");
            ler = leitor.next();
            Jogador jo = new Jogador(ler);
            this.jogadores.add(jo);            
        }
        do
        {
            for(int j=0; j<n; j++)
            {
                //System.out.println("i : " + j);
                this.jogadores.get(j).aumenta((int)(Math.random()*6)+1);
                System.out.println("Jogador " + this.jogadores.get(j).getnome() + " tem " + this.jogadores.get(j).pontoT() + " pontos");
                //System.out.println("K ?:" + this.k);
                if(this.jogadores.get(j).pontoT() >= this.k) this.fim = true;
            }
        }while(notum());
        ArrayList<Jogador> vencedores = new ArrayList<>();
        vencedores = this.lista(n);
        for(int w = 0; w<vencedores.size(); w++)
        {
            System.out.println("Jogador " + (w+1) + " : Nome: " + vencedores.get(w).getnome() + " Pontos: " + vencedores.get(w).pontoT());
        }
        
    }
   
    public boolean notum()
    {
        if(this.fim) return false;
        else return true;
    }
    
    public boolean existe()
    {
        return this.fim;
    }
    
    public ArrayList<Jogador> lista(int n)
    {
        int i = 0;
        ArrayList<Jogador> lista = new ArrayList<>();
        for(int j=0; j<n; j++)
        {
            if(this.jogadores.get(j).pontoT() >= i)
            {
                i = this.jogadores.get(j).pontoT();
            }
        }
        for(int l=0; l<n; l++)
        {
            if(this.jogadores.get(l).pontoT() == i)
            {
                lista.add(this.jogadores.get(l));
            }
        }
        return lista;
    }