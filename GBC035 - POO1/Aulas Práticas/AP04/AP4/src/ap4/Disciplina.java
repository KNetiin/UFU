package ap4;

import java.util.*;

public class Disciplina
{
    String nome;
    ArrayList<Disciplina> requisitos;
    
    public Disciplina(String nome)
    {
        this.nome = nome;
        requisitos = new ArrayList<>();
    }
    
    public void d_cria_requisitos (Disciplina d)
    {
        if(this.d_verifica_requisitos(d))
        {
            System.out.println("Requisito já existe!");
        }
        else this.requisitos.add(d);
    }
    
    public boolean d_verifica_requisitos (Disciplina d)
    {
        return this.requisitos.contains(d);
    }
        
    public void d_re_requisitos (Disciplina d)
    {
        if(this.requisitos.remove(d))
        {
            System.out.println("Prerequisito removido com sucesso!");
        }
        else System.out.println("ERRO! Não foi possível remover prerequisito!");
    }
    
    public String d_nome()
    {
        return this.nome;
    }
    
    public void d_imprimir()
    {
        System.out.println("" + this.nome);
    }
    
    public void d_mostrar()
    {
        if(this.requisitos.isEmpty())
        {
            System.out.println("Não possui requisitos!");
        }else
        {
            this.requisitos.forEach((Disciplina d) -> System.out.println("" + d.d_nome()));
        }
    }
}