package model;

public class Vaga {
    private int id;
    private boolean ocupacao;
    private Veiculo veiculo;
    
    public Vaga(int id, boolean ocupacao, Veiculo veiculo)
    {
        this.id = id;
        this.ocupacao = ocupacao;
        this.veiculo = veiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(boolean ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
