package dao;

import model.*;
import java.sql.*;
import java.util.*;
import model.template.*;

/*
* Hospede (armazenados sem problema)
* Endereco           ""
* Veiculo            ""
* Vaga (chave estrangeira de quarto)
* Acompanhantes (tabela acompanhantes depois so recuperar hospedes)

* Reserva (problema com estado e memento)
* Quarto (problema com qual o objeto de origem) só set 

* Restaurante (como lidar com Restaurante_pedido ?, tem que armazenar ?)
* Servicos (como lidar com os enum ?)
*/

public class CommunicateDAO {

    public Quarto retornaQuarto(int numeroquarto) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            Quarto quarto;
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Quarto where numero=?");
            ps.setInt(1,numeroquarto);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                switch(rs.getString("tipoquarto")){
                    case "Simples" : quarto = new Quarto_Simples(rs.getInt("numero"),false,(float) rs.getDouble("valor_diaria"),null,null); 
                    case "Familia" : quarto = new Quarto_Familia(rs.getInt("numero"),false,(float) rs.getDouble("valor_diaria"),null,null);
                }
                
                ArrayList<Consumiveis> consumiveis = this.retornaConsumiveis(numeroquarto);
            }
            
        } catch (SQLException ex) {
            System.out.println("Login error retorna quarto -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;
    }

    public ArrayList<Consumiveis> retornaConsumiveis(int numeroquarto){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            ArrayList<Consumiveis> consumiveis = this.retornaConsumiveis(numeroquarto);
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Consumiveis where quartoid=?");
            ps.setInt(1,numeroquarto);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Consumiveis c;
                
                c = new Consumiveis(rs.getInt("id"),rs.getString("nome"),rs.getString("descricao"),(float) rs.getDouble("preco_uni"),rs.getInt("quantidade"));
                consumiveis.add(c);
            }
            
            return consumiveis;

        } catch (SQLException ex) {
            System.out.println("Login error retorna quarto -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
      
    }
    
    public boolean registraReserva(Reserva reserva){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Reserva (serail,cliente,quarto,data_entrada,data_saida,preco_total) values (?,?,?,?,?,?)");
            ps.setInt(1,reserva.getSerial());
            ps.setInt(2,reserva.getCliente().getCpf());
            ps.setInt(3,reserva.getQuarto().getNumero());
            ps.setInt(3,0);
            ps.setString(4,reserva.getData_entrada());
            ps.setString(5,reserva.getData_saida());
            ps.setDouble(6,reserva.getPreco_total());
            
            int rs = ps.executeUpdate();

            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error registra reserva -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;
    }
    
    public boolean registraHospede(Hospede hospede){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Hospede (cpf,nome,codigo) values (?,?,?)");
            ps.setInt(1,hospede.getCpf());
            ps.setString(2,hospede.getNome());
            ps.setInt(3,hospede.getCodigo());
            
            int rs = ps.executeUpdate();    
            
            if(hospede.getEndereco() != null){
                this.registraEndereco(hospede.getCpf(),hospede.getEndereco());
            }

            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error registra hospede -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;        
    }
    
    public boolean registraEndereco(int cpf,Endereco endereco){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Endereco (clientecpf,numero,rua,bairro,cidade,cep,telefone) values (?,?,?,?,?,?,?)");
            ps.setInt(1,cpf);
            ps.setInt(2,endereco.getNumero());
            ps.setString(3,endereco.getRua());
            ps.setString(4,endereco.getBairro());
            ps.setString(5,endereco.getCidade());
            ps.setInt(6,endereco.getCep());
            ps.setInt(7,endereco.getTelefone());
            
            int rs = ps.executeUpdate();    
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error registra endereco -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;                
    }

    public boolean registraAcompanhante(int cpf,int cpfacompanhante){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Acompanhantes (cpf,cpfacompanhante) values (?,?)");
            ps.setInt(1,cpf);
            ps.setInt(2,cpfacompanhante);
                                    
            int rs = ps.executeUpdate();    
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error registra acompanhante -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }

    public boolean insereConsumiveis(int quarto, Consumiveis c) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Consumiveis (quartoid,id,nome,descricao,preco_uni,quantidade) values (?,?,?,?,?,?)");
            ps.setInt(1,quarto);
            ps.setInt(2,c.getId());
            ps.setString(3,c.getNome());
            ps.setString(4,c.getDescricao());
            ps.setDouble(5,c.getPreco_uni());
            ps.setInt(6,c.getQuantidade());

            int rs = ps.executeUpdate();
                        
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error insere consumiveis -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }

    public void deletaReserva(int codigo) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Reserva where serail=?");
            ps.setInt(1,codigo);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                this.deletaHospede(rs.getInt("cliente"));
                
                ps = con.prepareStatement("Delete from Reserva where serail=?");
                ps.setInt(1,codigo);
                ps.executeUpdate();
            }
     	} catch (SQLException ex) {
            System.out.println("Login error deleta reserva -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	} 
    }
    
    private void deletaHospede(int cpf) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Delete from Endereco where clientecpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();
            
            ps = con.prepareStatement("Delete from Acompanhante where cpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();
            
            ps = con.prepareStatement("Delete from Hospede where cpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();

     	} catch (SQLException ex) {
            System.out.println("Login error deleta hospede -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}     
    }
    
    public Reserva retornaReserva(int serial){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Reserva where serail=?");
            ps.setInt(1,serial);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reserva reserva = new Reserva(0,null,null,null,null,null,(float) 0.00,null);
                
                reserva.setSerial(rs.getInt("serail"));
                reserva.setData_entrada(rs.getString("data_entrada"));
                reserva.setData_saida(rs.getString("data_saida"));
                reserva.setPreco_total((float) rs.getDouble("preco_total"));               
                
                Hospede cliete = this.retornaHospede(rs.getInt("cliente"));
                
                reserva.setCliente(cliete);
                
                ArrayList<Hospede> acompanhantes = this.retornaAcompanhantes(rs.getInt("cliente"));
                
                reserva.setAcompanhantes(acompanhantes);
                
                return reserva;
            }
	} catch (SQLException ex) {
            System.out.println("Login error retorna reserva -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }    
 
    public Hospede retornaHospede(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Hospede where cpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Hospede cliente = new Hospede(null,0,0,null,null);
                
                cliente.setCpf(cpf);
                cliente.setNome(rs.getString("nome"));
                cliente.setCodigo(rs.getInt("codigo"));
                
                Endereco endereco = this.retornaEndereco(cpf);
                
                cliente.setEndereco(endereco);
                
                return cliente;
            }
	} catch (SQLException ex) {
            System.out.println("Login error retorna hospede -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public Endereco retornaEndereco(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Endereco where clientecpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Endereco endereco = new Endereco(0,null,null,null,0,0);
                
                endereco.setNumero(rs.getInt("numero"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setTelefone(rs.getInt("telefone"));
                
                return endereco;
            }
	} catch (SQLException ex) {
            System.out.println("Login error retorna endereco -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public ArrayList<Hospede> retornaAcompanhantes(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Acompanhante where cpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            ArrayList<Hospede> acompanhantes = new ArrayList<Hospede>();
            while (rs.next()) {
                Hospede h = this.retornaHospede(rs.getByte("cpfacompanhante"));
                acompanhantes.add(h);
            }
            return acompanhantes;
            
	} catch (SQLException ex) {
            System.out.println("Login error retorna acompanhantes -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}   
    }

    public void registraFuncionario(Funcionario funcionario) {
 	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Funcionario (nome,cpf,salario,senha,cargo) values (?,?,?,?,?)");
            ps.setString(1,funcionario.getNome());
            ps.setInt(2,funcionario.getCpf());
            ps.setDouble(3,funcionario.getSalario());
            ps.setInt(4,funcionario.getSenha());
            ps.setString(5,funcionario.getCargo().toString());
            
            int rs = ps.executeUpdate();    
            
            if(funcionario.getEndereco() != null){
                this.registraEndereco(funcionario.getCpf(),funcionario.getEndereco());
            }
                        
	} catch (SQLException ex) {
            System.out.println("Login error registra funcionario -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}       
    }

    public Funcionario retornaFuncionario(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Funcionario where cpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Funcionario f = null;
                EnumCargo c = null;
                
                switch(rs.getString("cargo")){
                    case "Gerente" : f = new Funcionario(rs.getString("nome"),rs.getInt("cpf"),(float) rs.getDouble("salario"),null,rs.getInt("senha"),c.Gerente);break;
                    case "Faxineiro" : f = new Funcionario(rs.getString("nome"),rs.getInt("cpf"),(float) rs.getDouble("salario"),null,rs.getInt("senha"),c.Faxineiro) ;break;
                    case "Recepcionista" : f = new Funcionario(rs.getString("nome"),rs.getInt("cpf"),(float) rs.getDouble("salario"),null,rs.getInt("senha"),c.Recepcionista);break;
                    case "Gerente Restaurante" : f = f = new Funcionario(rs.getString("nome"),rs.getInt("cpf"),(float) rs.getDouble("salario"),null,rs.getInt("senha"),c.Gerente_Restaurante);break;
                    case "Garcom" : f = new Funcionario(rs.getString("nome"),rs.getInt("cpf"),(float) rs.getDouble("salario"),null,rs.getInt("senha"),c.Garcom);break;

                }
                
                Endereco endereco = this.retornaEndereco(cpf);
                
                f.setEndereco(endereco);
                
                return f;
            }
	} catch (SQLException ex) {
            System.out.println("Login error retorn funcionario -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public void removeFuncionario(int cpf) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();

            ps = con.prepareStatement("Delete from Endereco where clientecpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();
            
            ps = con.prepareStatement("Delete from Funcionario where cpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();

     	} catch (SQLException ex) {
            System.out.println("Login error remover funcionario -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}     
    }

    
    public Reserva retornaReserva_2(int quarto){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Reserva where quarto=?");
            ps.setInt(1,quarto);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reserva reserva = new Reserva(0,null,null,null,null,null,(float) 0.00,null);
                
                reserva.setSerial(rs.getInt("serail"));
                reserva.setData_entrada(rs.getString("data_entrada"));
                reserva.setData_saida(rs.getString("data_saida"));
                reserva.setPreco_total((float) rs.getDouble("preco_total"));               
                
                Hospede cliete = this.retornaHospede(rs.getInt("cliente"));
                
                reserva.setCliente(cliete);
                
                ArrayList<Hospede> acompanhantes = this.retornaAcompanhantes(rs.getInt("cliente"));
                
                reserva.setAcompanhantes(acompanhantes);
                
                return reserva;
            }
	} catch (SQLException ex) {
            System.out.println("Login error retorna reserva -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }
    
    public void updateValorReserva(int serial,float novovalor){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Update Reserva Set preco_total=? where serail=?");
            ps.setDouble(1,novovalor);
            ps.setInt(2,serial);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            }
	} catch (SQLException ex) {
            System.out.println("Login error atualiza reserva valor -->" + ex.getMessage());

        } finally {
            DataConnect.close(con);
	}
    }
}
