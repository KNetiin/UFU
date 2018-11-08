package model;

public enum EnumCargo {
    Gerente("Gerente"),
    Faxineiro("Faxineiro"),
    Recepcionista("Recepcionista"),
    Gerente_Restaurante("Gerente Restaurante"),
    Garcom("Garcom")
    ;
    
    private final String text;
    
    EnumCargo(final String text)
    {
        this.text = text;
    }
      
    @Override
    public String toString() {
        return text;
    }

    public void criaReserva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
