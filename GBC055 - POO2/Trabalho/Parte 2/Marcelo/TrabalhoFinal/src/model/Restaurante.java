package model;

public class Restaurante {
    private int codigo;
    private String descricao;
    private Restaurante_Pedido servico;
    
    public Restaurante(int codigo, String descricao)
    {
        this.servico = new Restaurante_Pedido();
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void solicitar_pedido(float valor, Reserva reserva)
    {
        this.servico.solicitar_valor(valor, reserva);
    }

    public Restaurante_Pedido getServico() {
        return servico;
    }

    public void setServico(Restaurante_Pedido servico) {
        this.servico = servico;
    }
    
}