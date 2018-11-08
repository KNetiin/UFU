package controller;

import dao.CommunicateDAO;
import model.Endereco;
import model.EnumCargo;
import model.Funcionario;

public class Gerente {
    
    public static void CadastraFuncionario(String nome,String cpf,String cargo,String senha,String salario,String rua,String numerocasa,String cidade,String cep,String bairro,String telefone){
        Endereco e;
        EnumCargo c = null;
        
        e = new Endereco(Integer.parseInt(numerocasa),rua,bairro,cidade,Integer.parseInt(cep),Integer.parseInt(telefone));
        
        Funcionario f = null;
        
        switch(cargo){
            case "Gerente" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),e,Integer.parseInt(senha),c.Gerente);break;
            case "Faxineiro" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),e,Integer.parseInt(senha),c.Faxineiro) ;break;
            case "Recepcionista" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),e,Integer.parseInt(senha),c.Recepcionista);break;
            case "Gerente Restaurante" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),e,Integer.parseInt(senha),c.Gerente_Restaurante);break;
            case "Garcom" : f = new Funcionario(nome,Integer.parseInt(cpf),(float) Double.parseDouble(salario),e,Integer.parseInt(senha),c.Garcom);break;
        }

        CommunicateDAO.registraFuncionario(f);
    }

    public static void RemoveFuncionario(String cpf){
        Funcionario f = null;

        CommunicateDAO.removeFuncionario(Integer.parseInt(cpf));
    }
}
