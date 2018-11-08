package batalhanaval;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class Jogador
{
    final private String nome;
    private ArrayList<Navio> navios = new ArrayList<>();
    public Grade grade;
    
    public Jogador(String nome)
    {
         this.grade = new Grade("DEFESA");
        this.nome = nome;
        
    }
    
    public void adiciona_navio(Navio n)
    {
        navios.add(n);
    }
    
    public Navio getNavio(int posicao)
    {
        return this.navios.get(posicao);
    }
}
