package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import model.Consumiveis;
import model.Endereco;
import model.EnumCargo;
import model.Funcionario;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.Restaurante;
import model.Vaga;
import model.Veiculo;
import model.state.Estado_Reserva;

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
        
    public static boolean registraReserva(Reserva reserva){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Reserva (serail,cliente,quarto,data_entrada,data_saida,preco_total) values (?,?,?,?,?,?)");
            ps.setInt(1,reserva.getSerial());
            ps.setInt(2,reserva.getCliente().getCpf());
            ps.setInt(3,reserva.getQuarto().getNumero());
            ps.setString(4,reserva.getData_entrada());
            ps.setString(5,reserva.getData_saida());
            ps.setDouble(6,reserva.getPreco_total());
            
            int rs = ps.executeUpdate();

            CommunicateDAO.registraHospede(reserva.getCliente());
            
            if(reserva.getAcompanhantes() != null){
                for(Hospede h: reserva.getAcompanhantes()){
                    CommunicateDAO.registraAcompanhante(reserva.getCliente().getCpf(),h.getCpf());
                    CommunicateDAO.registraHospede(h);
                }
            }
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;
    }
    
    public static boolean registraHospede(Hospede hospede){
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
                CommunicateDAO.registraEndereco(hospede.getCpf(),hospede.getEndereco());
            }
            
            if(hospede.getVeiculo() != null) {
                CommunicateDAO.registraVeiculo(hospede);
            }
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;        
    }
    
    public static boolean registraEndereco(int cpf,Endereco endereco){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Endereco (cpf,numero,rua,bairro,cidade,cep,telefone) values (?,?,?,?,?,?,?)");
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
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
	return false;                
    }

    public static boolean registraVeiculo(Hospede hospede){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Veiculo (clientecpf,proprietario,modelo,placa) values (?,?,?,?)");
            ps.setInt(1,hospede.getCpf());
            ps.setString(2,hospede.getVeiculo().getProprietario());
            ps.setString(3,hospede.getVeiculo().getModelo());
            ps.setString(4,hospede.getVeiculo().getPlaca());
                                    
            int rs = ps.executeUpdate();    
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;
    }
    
    public static boolean registraAcompanhante(int cpf,int cpfacompanhante){
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
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }

    public static boolean insereQuarto(Quarto quarto){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Quartos (numero,disponibilidade,capacidade,valor_diaria,vaga) values (?,?,?,?,?)");
            ps.setInt(1,quarto.getNumero());
            ps.setBoolean(2,true);
            ps.setInt(3,quarto.getCapacidade());
            ps.setDouble(4,quarto.getValor_diaria());
            ps.setInt(5,quarto.getVaga().getId());
            
            int rs = ps.executeUpdate();
            
            CommunicateDAO.insereVaga(quarto.getVaga());
            if(quarto.getFrigobar() != null){
                for(Consumiveis c : quarto.getFrigobar()){
                    CommunicateDAO.insereConsumiveis(quarto.getNumero(),c);
                }
            }
            
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }
/*    
    public static Quarto retornaQuarto(int numeroquarto) {

    }
*/
    
    public static boolean insereVaga(Vaga vaga) { // veiculo na vaga e recuperado por ocupacao + reserva.cliente.veiculo
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Vaga (id,ocupacao) values (?,?)");
            ps.setInt(1,vaga.getId());
            ps.setBoolean(2,false);

            int rs = ps.executeUpdate();
                        
            if (rs == 0) {
		//result found, means valid inputs
		return true;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }

    public static boolean insereConsumiveis(int quarto, Consumiveis c) {
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
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
	}
        return false;        
    }

    public static void deletaReserva(int codigo) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Acompanhante where serail = ?");
            ps.setInt(1,codigo);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                CommunicateDAO.deletaHospede(rs.getInt("cliente"));
                ps = con.prepareStatement("Delete from Acompanhante where serail = ?");
                ps.setInt(1,codigo);
                ps.executeUpdate();
            }
     	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	} 
    }
    
    private static void deletaHospede(int cpf) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();

            ps = con.prepareStatement("Delete from Veiculo where clientecpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();

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
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}     
    }
    
    public static Reserva retornaReserva(int cpfcliente){
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Reserva where cliente=?");
            ps.setInt(1,cpfcliente);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reserva reserva = new Reserva(0,null,null,null,null,null,(float) 0.00,null);
                
                reserva.setSerial(rs.getInt("serail"));
                reserva.setData_entrada(rs.getString("data_entrada"));
                reserva.setData_saida(rs.getString("data_saida"));
                reserva.setPreco_total((float) rs.getDouble("preco_total"));               
                
                Hospede cliete = CommunicateDAO.retornaHospede(rs.getInt("cliente"));
//                Quarto quarto  = CommunicateDAO.retornaQuarto(rs.getInt("quarto"));
                
                reserva.setCliente(cliete);
//                reserva.setQuarto(quarto);
                
                ArrayList<Hospede> acompanhantes = CommunicateDAO.retornaAcompanhantes(rs.getInt("cliente"));
                
                reserva.setAcompanhantes(acompanhantes);
                
                return reserva;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }    
    
    public static Hospede retornaHospede(int cpf) {
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
                
                Endereco endereco = CommunicateDAO.retornaEndereco(cpf);
                Veiculo veiculo   = CommunicateDAO.retornaVeiculo(cpf);
                
                cliente.setEndereco(endereco);
                cliente.setVeiculo(veiculo);
                
                return cliente;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public static Endereco retornaEndereco(int cpf) {
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
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public static Veiculo retornaVeiculo(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Veiculo where clientecpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Veiculo veiculo = new Veiculo(null,null,null);
                
                veiculo.setProprietario(rs.getString("proprietario"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                
                return veiculo;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;    
    }

    public static ArrayList<Hospede> retornaAcompanhantes(int cpf) {
	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Acompanhante where cpf=?");
            ps.setInt(1,cpf);
            
            ResultSet rs = ps.executeQuery();

            ArrayList<Hospede> acompanhantes = new ArrayList<Hospede>();
            while (rs.next()) {
                Hospede h = CommunicateDAO.retornaHospede(rs.getByte("cpfacompanhante"));
                acompanhantes.add(h);
            }
            return acompanhantes;
            
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}   
    }

    public static void registraFuncionario(Funcionario funcionario) {
 	Connection con = null;
	PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Insert into Funcionario (nome,cpf,salario,senha,cargo) values (?,?,?)");
            ps.setString(1,funcionario.getNome());
            ps.setInt(2,funcionario.getCpf());
            ps.setDouble(3,funcionario.getSalario());
            ps.setInt(4,funcionario.getSenha());
            ps.setString(5,funcionario.getCargo().toString());
            
            int rs = ps.executeUpdate();    
            
            if(funcionario.getEndereco() != null){
                CommunicateDAO.registraEndereco(funcionario.getCpf(),funcionario.getEndereco());
            }
                        
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}       
    }

    public static Funcionario retornaFuncionario(int cpf) {
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
                
                Endereco endereco = CommunicateDAO.retornaEndereco(cpf);
                
                f.setEndereco(endereco);
                
                return f;
            }
	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return null;
        } finally {
            DataConnect.close(con);
	}
	return null;        
    }

    public static void removeFuncionario(int cpf) {
        Connection con = null;
	PreparedStatement ps = null;
        
        try {
            con = DataConnect.getConnection();

            ps = con.prepareStatement("Delete from Endereco where clientecpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();
            
            ps = con.prepareStatement("Delete from Hospede where cpf = ?");
            ps.setInt(1,cpf);
            ps.executeUpdate();

     	} catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close(con);
	}     
    }

}
