
package principal.Contas;
import principal.Padroes.*;

public class ContaInvestimento extends Conta {
 
    public ContaInvestimento(int numero,int agencia,String senha,String titular,float saldo){
        
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.titular = titular;
        this.saldo = saldo;
        this.rentabilidade = new R_normal();
        this.mensalidade = new M_baixa();
        this.movimentacao = new M_completa();
        this.limite = new Ch_liberado();
        
    }
}
