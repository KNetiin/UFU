package model;

import java.util.ArrayList;
import model.state.Estado_Reserva;

public class Memento {
    private int serial;
    private Hospede cliente;
    private Quarto quarto;
    private String data_entrada;
    private String data_saida;
    private ArrayList<Hospede> acompanhantes;
    private float preco_total;
    private Estado_Reserva estado;
    
    public Memento(int serial, Hospede cliente, Quarto quarto, String data_entrada, String data_saida, ArrayList<Hospede> acompanhantes, 
            float preco_total, Estado_Reserva estado)
    {
        this.serial = serial;
        this.cliente = cliente;
        this.quarto = quarto;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.acompanhantes = acompanhantes;
        this.preco_total = preco_total;
        this.estado = estado;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public Hospede getCliente() {
        return cliente;
    }

    public void setCliente(Hospede cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public ArrayList<Hospede> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(ArrayList<Hospede> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public float getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }

    public Estado_Reserva getEstado() {
        return estado;
    }

    public void setEstado(Estado_Reserva estado) {
        this.estado = estado;
    }
}