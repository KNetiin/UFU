package model;

import java.util.ArrayList;

public abstract class Quarto {
    private int numero;
    private boolean disponibilidade;
    private int capacidade;
    private float valor_diaria;
    private ArrayList<Consumiveis> frigobar;
    private Vaga vaga;
    private Limpeza servico1;
    private Comida_Quarto servico2;
    
    /*public Quarto(int numero, boolean disponibilidade, int capacidade, float valor_diaria, ArrayList<Consumiveis> frigobar, Vaga vaga)
    {
        this.numero = numero;
        this.disponibilidade = disponibilidade;
        this.capacidade = capacidade;
        this.valor_diaria = valor_diaria;
        this.vaga = vaga;
        this.frigobar = frigobar;
    }*/

    public int getNumero() 
	{
        return numero;
    }

    public void setNumero(int numero) 
	{
        this.numero = numero;
    }

    public boolean isDisponibilidade() 
	{
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) 
	{
        this.disponibilidade = disponibilidade;
    }

    public int getCapacidade() 
	{
        return capacidade;
    }

    public void setCapacidade(int capacidade) 
	{
        this.capacidade = capacidade;
    }

    public float getValor_diaria() 
	{
        return valor_diaria;
    }

    public void setValor_diaria(float valor_diaria) 
	{
        this.valor_diaria = valor_diaria;
    }

    public ArrayList<Consumiveis> getFrigobar() 
	{
        return frigobar;
    }

    public void setFrigobar(ArrayList<Consumiveis> frigobar) 
	{
        this.frigobar = frigobar;
    }

    public Vaga getVaga() 
	{
        return vaga;
    }

    public void setVaga(Vaga vaga) 
	{
        this.vaga = vaga;
    }

    public Limpeza getServico1() 
	{
        return servico1;
    }

    public void setServico1(Limpeza servico1) 
	{
        this.servico1 = servico1;
    }

    public Comida_Quarto getServico2() 
	{
        return servico2;
    }

    public void setServico2(Comida_Quarto servico2) 
	{
        this.servico2 = servico2;
    }

    public final void solicitarLimpeza(Reserva reserva)
    {
	solicitarLimpezaNormal(reserva);
	solicitarLimpezaBanheira(reserva);
	solicitarLimpezaPiscina(reserva);
    }
    
    protected void solicitarLimpezaNormal(Reserva reserva) {}
    protected void solicitarLimpezaBanheira(Reserva reserva){}
    protected void solicitarLimpezaPiscina(Reserva reserva){}
	
    public void solicitaItemCardapio(int id, Reserva reserva)
    {
        this.servico2.solicitaItemCardapio(id, reserva);
    }
}
