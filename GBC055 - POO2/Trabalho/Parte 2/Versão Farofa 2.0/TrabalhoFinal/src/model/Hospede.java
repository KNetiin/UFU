package model;

public class Hospede {
    private String nome;
    private int cpf;
    private int codigo;
    private Endereco endereco;
    private Veiculo veiculo;
    
    public Hospede(String nome, int cpf, int codigo, Endereco endereco, Veiculo veiculo)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigo;
        this.endereco = endereco;
        this.veiculo = veiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}
