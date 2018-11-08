package model.template;

import java.util.ArrayList;
import model.Comida_Quarto;
import model.Consumiveis;
import model.Limpeza;
import model.Quarto;
import model.Vaga;

public class Quarto_Cobertura_Singleton extends Quarto{
    private static Quarto_Cobertura_Singleton instancia;
    
    private Quarto_Cobertura_Singleton(int numero, boolean disponibilidade, float valor_diaria, ArrayList<Consumiveis> frigobar, Vaga vaga)
    {
        super.setNumero(numero);
        super.setDisponibilidade(disponibilidade);
        super.setCapacidade(4);
        super.setValor_diaria(valor_diaria);
        super.setVaga(vaga);
        super.setFrigobar(frigobar);
        super.setServico1(new Limpeza());
        super.setServico2(new Comida_Quarto());
    }

    public static Quarto_Cobertura_Singleton getInstancia() {
        if(instancia == null) return null;
        return instancia;
    }
    
    public static void newInstancia(int numero, boolean disponibilidade, float valor_diaria, ArrayList<Consumiveis> frigobar, Vaga vaga) {
        if(instancia == null) instancia = new Quarto_Cobertura_Singleton(numero, disponibilidade, valor_diaria, frigobar, vaga);
    }
    
    
}
