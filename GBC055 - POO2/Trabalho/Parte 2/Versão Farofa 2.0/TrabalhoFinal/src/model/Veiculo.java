package model;

public class Veiculo {
    private String proprietario;
    private String modelo;
    private String placa;

    public Veiculo(String proprietario, String modelo, String placa)
    {
        this.proprietario = proprietario;
        this.modelo = modelo;
        this.placa = placa;
    }
    
    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
