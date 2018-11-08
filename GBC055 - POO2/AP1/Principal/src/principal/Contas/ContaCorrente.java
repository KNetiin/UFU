
package principal.Contas;

import principal.Padroes.*;


public class ContaCorrente extends Conta {
   
    public ContaCorrente(int numero,int agencia,String senha,String titular,float saldo){
        
        this.numero = numero;
        this.agencia = agencia;
        this.senha = senha;
        this.titular = titular;
        this.saldo = saldo;
        this.rentabilidade = new R_baixa();
        this.mensalidade = new M_normal();
        this.movimentacao = new M_completa();
        this.limite = new Ch_liberado();  
        
    }
    
}
