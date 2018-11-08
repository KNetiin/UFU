package model.template;

import java.util.ArrayList;
import model.Comida_Quarto;
import model.Consumiveis;
import model.Limpeza;
import model.Quarto;
import model.Vaga;

public class Quarto_Familia extends Quarto{
    
    public Quarto_Familia(int numero, boolean disponibilidade, float valor_diaria, ArrayList<Consumiveis> frigobar, Vaga vaga)
    {
        super.setNumero(numero);
        super.setDisponibilidade(disponibilidade);
        super.setCapacidade(3);
        super.setValor_diaria(valor_diaria);
        super.setVaga(vaga);
        super.setFrigobar(frigobar);
        super.setServico1(new Limpeza());
        super.setServico2(new Comida_Quarto());
    }
    
}
