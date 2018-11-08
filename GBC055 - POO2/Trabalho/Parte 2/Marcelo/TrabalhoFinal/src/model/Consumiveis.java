package model;

public class Consumiveis {
    private int id;
    private String nome;
    private String descricao;
    private float preco_uni;
    private int quantidade;
    
    public Consumiveis(int id, String nome, String descricao, float preco_uni, int quantidade)
    {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_uni = preco_uni;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco_uni() {
        return preco_uni;
    }

    public void setPreco_uni(float preco_uni) {
        this.preco_uni = preco_uni;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
