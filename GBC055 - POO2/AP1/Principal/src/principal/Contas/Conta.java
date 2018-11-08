
package principal.Contas;
import principal.Padroes.*;

public abstract class Conta {
    int numero;
    int agencia;
    String senha;
    String titular;
    float saldo;
    Rentabilidade rentabilidade;
    Mensalidade mensalidade;
    Movimentacao movimentacao;
    Limite limite;
    
    public void setRentabilidade(Rentabilidade rentabilidade){
        this.rentabilidade = rentabilidade;
    }
    public void setMensalidade(Mensalidade mensalidade){
        this.mensalidade = mensalidade;
    }
    public void setMovimentacao(Movimentacao movimentacao){
        this.movimentacao = movimentacao;
    }
    public void setLimite(Limite limite){
        this.limite = limite;
    }
    
    public void imprime_tudo()
    {
        System.out.println("Numero: " + this.numero);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Senha: " + this.senha);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo:" + this.saldo);
        this.rentabilidade.t_rentabilidade();
        this.mensalidade.t_mensalidade();
        this.movimentacao.t_movimentacao();
        this.limite.t_limite();
    }
}
