package controller;

import dao.CommunicateDAO;
import java.util.ArrayList;
import model.Endereco;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.Veiculo;

/**
 *
 * @author Adriano
 */
public class Recepcao {

    public static void cadastraHospede(String nome,String cpf,String telefone,String cep,String rua,String numerocasa,String bairro,String cidade){
        Hospede h;
        Endereco e;
        
        e = new Endereco(Integer.parseInt(numerocasa),rua,bairro,cidade,Integer.parseInt(cep),Integer.parseInt(telefone));
        h = new Hospede(nome,Integer.parseInt(cpf),0,e,null);
        
        CommunicateDAO.registraHospede(h);
    }
    
    public static void abrirReserva(String cpf,String numeroquarto,String dataentrada,String datasaida,String codigoreserva,String cpf1,String cpf2,String cpf3,String cpf4, Boolean alugavaga){
        Reserva r;
        Hospede h;
        ArrayList<Hospede> a = new ArrayList<Hospede>();
//        Quarto q = CommunicateDAO.retornaQuarto(Integer.parseInt(numeroquarto));
        
        if(cpf1 != null){
            h = new Hospede(null,Integer.parseInt(cpf1),Integer.parseInt(codigoreserva),null,null);
            a.add(h);
        }
        if(cpf2 != null){
            h = new Hospede(null,Integer.parseInt(cpf1),Integer.parseInt(codigoreserva),null,null);
            a.add(h);
        }
        if(cpf3 != null){
            h = new Hospede(null,Integer.parseInt(cpf1),Integer.parseInt(codigoreserva),null,null);
            a.add(h);
        }
        if(cpf4 != null){
            h = new Hospede(null,Integer.parseInt(cpf1),Integer.parseInt(codigoreserva),null,null);
            a.add(h);
        }
        
        h = new Hospede(null,Integer.parseInt(cpf),Integer.parseInt(codigoreserva),null,null);
        r = new Reserva(Integer.parseInt(cpf),h,null,dataentrada,datasaida,a,(float) 0.00,null);
    }
    
    public static void editaReserva(String codigo,String dataentrada,String datasaida){
        Reserva reserva;
            
        reserva = CommunicateDAO.retornaReserva(Integer.parseInt(codigo));
        CommunicateDAO.registraReserva(reserva);
            
        if(dataentrada != null){
            reserva.setData_entrada(dataentrada);
        }
        
        if(datasaida != null){
            reserva.setData_saida(datasaida);
        }
    }
    
    public static void fechaReserva(String codigo){
        Reserva reserva;
        
        reserva = CommunicateDAO.retornaReserva(Integer.parseInt(codigo));
        reserva.getPreco_total();// Faz o que com isso
        CommunicateDAO.deletaReserva(Integer.parseInt(codigo));
    }

    public static void cadastraVeiculo(String cpf,String modelo,String placa){//prescisava do cpf
        Veiculo v;
        Hospede h = CommunicateDAO.retornaHospede(Integer.parseInt(cpf));
        
        v = new Veiculo(h.getNome(),modelo,placa);
        h.setVeiculo(v);
        CommunicateDAO.registraVeiculo(h);
    }

}