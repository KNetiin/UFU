package prédio;

import java.util.*;
public class Prédio
{
    private int na;
    private Elevador elevador;
    private ArrayList<Botão> botoes;
    
    public Prédio(int n)
    {
        this.na = n;
        Elevador l = new Elevador(n);
        this.elevador = l;
        this.botoes = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            Botão botao = new Botão(i);
            this.botoes.add(botao);
        }
        Scanner leitor = new Scanner(System.in);
        for(int j = 0; j <= n; )
        {
            System.out.println("Digite um andar para o elevador ir");
            j = leitor.nextInt();
            if(j>n || j<0)
            {
                System.out.println("Andar inválido");
                j = n+1;
            }
            else
            {
                this.botoes.get(j).ligar();
                System.out.println("O elevador saiu do andar " + this.elevador.qualandar() + " e foi para o andar " + j);
                this.elevador.irParaAndar(j);
                this.botoes.get(j).desligar();
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o numero de andares do prédio?");
        int i = leitor.nextInt();
        Prédio p = new Prédio(i);
    }
    
}
