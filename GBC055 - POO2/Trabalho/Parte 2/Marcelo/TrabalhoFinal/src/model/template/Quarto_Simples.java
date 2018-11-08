package model.template;

import java.util.ArrayList;
import model.Comida_Quarto;
import model.Consumiveis;
import model.Limpeza;
import model.Quarto;
import model.Reserva;
import model.Vaga;

public class Quarto_Simples extends Quarto{
    
    public Quarto_Simples(int numero, boolean disponibilidade, float valor_diaria, ArrayList<Consumiveis> frigobar, Vaga vaga)
    {
        super.setNumero(numero);
        super.setDisponibilidade(disponibilidade);
        super.setCapacidade(2);
        super.setValor_diaria(valor_diaria);
        super.setVaga(vaga);
        super.setFrigobar(frigobar);
        super.setServico1(new Limpeza());
        super.setServico2(new Comida_Quarto());
    }
	
	protected void solicitarLimpezaNormal(Reserva reserva) {
            reserva.setPreco_total((float) (5.0 + reserva.getPreco_total()));
	}
}
