
package principal.Contas;
import principal.Padroes.*;


public class ContaPoupanca extends Conta {
 
    public ContaPoupanca(int numero,int agencia,String senha,String titular,float saldo){
        
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.titular = titular;
        this.saldo = saldo;
        this.rentabilidade = new R_normal();
        this.mensalidade = new M_baixa();
        this.movimentacao = new M_simplificada();
        this.limite = new Ch_bloqueado();
        
        
    }
}
