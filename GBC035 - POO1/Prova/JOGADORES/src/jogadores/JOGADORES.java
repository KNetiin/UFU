package jogadores;

import java.util.Scanner;

public class JOGADORES {

    int jogo[];
    int dado;
    
    JOGADORES()
    {
        this.dado = 0;
        this.jogo = new int[10];
        for(int i = 0; i<10; i++) jogo[i] = 0;
    }
    
    void jogarDado()
    {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o numero do dado: ");
        this.dado = leitor.nextInt();
    }
    
    void imprime()
    {
        for(int i = 0; i< 10; i++) System.out.print(" "+ this.jogo[i]);
        System.out.println("");
    }
    
    boolean acerto(int i , JOGADOR J0)
    {
        if(this.jogo[i] == 0)
        {
            J0.add_acerto();
            this.jogo[i] = J0.n;
            System.out.println("Jogador " + J0.n + " acertou, total de " + J0.a);
            return true;
        }else return false;        
    }
    
    public static void main(String[] args)
    {
        JOGADOR J1 = new JOGADOR(1);
        JOGADOR J2 = new JOGADOR(2);
        JOGADORES JJ = new JOGADORES();
        
        JJ.imprime();
        for(int i = 0; i < 10 && J1.a < 6 && J2.a < 6; )
        {
            JJ.jogarDado();
            if(JJ.acerto(JJ.dado, J1)) i++;
            JJ.imprime();
            if(i < 10 && J1.a < 6 && J2.a < 6)
            {
                JJ.jogarDado();
                if(JJ.acerto(JJ.dado, J2)) i++;
                JJ.imprime();
            }
            
        }
        
    }
    
}
