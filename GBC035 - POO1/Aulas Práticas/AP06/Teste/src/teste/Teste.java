package teste;

import java.util.*;
public class Teste
{

    public static void main(String[] args)
    {
        System.out.println("Digite o numero de jogadores:");
        Scanner leitor = new Scanner(System.in);
        int i = leitor.nextInt();
        Jogo jo = new Jogo(i);      
    }
}
