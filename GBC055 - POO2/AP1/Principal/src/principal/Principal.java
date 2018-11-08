/*
NOMES: LUCAS ROSSI RABELO 11611BCC044
       ANTONIO CARLOS NETO 11611BCC054
 */
package principal;
import principal.Contas.*;
import principal.Padroes.*;


public class Principal {

    
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(123123,12354,"palmeiras","JAILSON",0.0f);
        c1.imprime_tudo();
        System.out.println("---------------------------------------------------------------------------------------------------");
        ContaSalario c2 = new ContaSalario(123132,12354,"nao","KENO",0.1f);
        c2.imprime_tudo();
        System.out.println("---------------------------------------------------------------------------------------------------");
        ContaPoupanca c3 = new ContaPoupanca(123312,12354,"tem","GUERRA",0.2f);
        c3.imprime_tudo();
        System.out.println("---------------------------------------------------------------------------------------------------");
        ContaInvestimento c4 = new ContaInvestimento(123321,12354,"mundial","BORJA",0.3f);
        c4.imprime_tudo();
        System.out.println("---------------------------------------------------------------------------------------------------");
        ContaUFU c5 = new ContaUFU(123213,12354,"!!!","SCARPA",0.4f);
        c5.imprime_tudo();
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
    
}