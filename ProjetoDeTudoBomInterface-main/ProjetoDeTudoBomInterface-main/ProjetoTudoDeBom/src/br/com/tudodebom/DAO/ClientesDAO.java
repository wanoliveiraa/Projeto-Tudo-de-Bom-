package br.com.tudodebom.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tudodebom.conexao.BancoDeDados;
import br.com.tudodebom.model.Clientes;
import java.sql.SQLException;

public class ClientesDAO {
    public List<Clientes> listaClientes() {
        List<Clientes> lista = new ArrayList<>();
	PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset=null;
        
            try {
                // Tratando excecao do retorno select
		String query = "select * from clientes";
		statement = connection.prepareStatement(query);
		resultset=statement.executeQuery(query);
		while (resultset.next()) {
                    Clientes cliente =new Clientes();
                    cliente.setIdCliente(resultset.getInt("id_cliente"));
                    cliente.setNomeCliente(resultset.getString("nome_cliente"));
                    cliente.setDataNascimento(resultset.getString("data_nascimento"));
                    cliente.setCpf(resultset.getString("cpf_cliente"));
                    cliente.setSexo(resultset.getString("sexo_cliente"));
                    cliente.setTelefone(resultset.getString("telefone_cliente"));
                    lista.add(cliente);
		}
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
        return lista;
    }
    public List<Clientes> buscarPeloNomeClientes(String nome) {
        List<Clientes> lista = new ArrayList<>();
	PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset=null;
        
            try {
                // Tratando excecao do retorno selec
		statement = connection.prepareStatement("SELECT * FROM clientes WHERE nome_cliente LIKE ?");
                statement.setString(1,"%"+nome+"%");
		resultset=statement.executeQuery();
		while (resultset.next()) {
                    Clientes cliente =new Clientes();
                    cliente.setIdCliente(resultset.getInt("id_cliente"));
                    cliente.setNomeCliente(resultset.getString("nome_cliente"));
                    cliente.setDataNascimento(resultset.getString("data_nascimento"));
                    cliente.setCpf(resultset.getString("cpf_cliente"));
                    cliente.setSexo(resultset.getString("sexo_cliente"));
                    cliente.setTelefone(resultset.getString("telefone_cliente"));
                    lista.add(cliente);
		}
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
        return lista;
    }
    
    
    
    
    
    //inserir registros	
    public void inserirCliente(Clientes cliente){
        Connection con = BancoDeDados.getConnection();
	PreparedStatement stmt = null;
	try {
            //String query="INSERT INTO clientes1 (nome_cliente,data_nascimento,cpf_cliente,telefone_cliente) VALUES (`?`,`?`,`?`,`?`);";
            stmt=con.prepareStatement("INSERT INTO clientes (nome_cliente,data_nascimento,cpf_cliente,sexo_cliente,telefone_cliente) VALUES (?,?,?,?,?);");
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4,cliente.getSexo());
            stmt.setString(5, cliente.getTelefone());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}catch (SQLException e) {
            System.out.println("Erro:"+e.getMessage());
	} finally {
            BancoDeDados.closeConnection(con, stmt);
        }
    }

	public void AtualizarCliente(Clientes cliente) {
            PreparedStatement statement=null;
            Connection connection = BancoDeDados.getConnection();
            try {
                // linha de execucao da sinxtaxe update em sql
		String query = ("update clientes SET nome_cliente = ? ,telofone_cliente = ? WHERE id_cliente = ?;");
		statement = connection.prepareStatement("update clientes SET nome_cliente = ? ,telefone_cliente = ? WHERE id_cliente = ?;");
		statement.setString(1, cliente.getNomeCliente());
		statement.setString(2, cliente.getTelefone());
		statement.setInt(3, cliente.getIdCliente());
		statement.execute();
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro em atualizar " + e);
            } finally {
                BancoDeDados.closeConnection(connection, statement);
            }
	}

	public void deletarCliente(Clientes cliente) {
            PreparedStatement statement=null;
            Connection connection = BancoDeDados.getConnection();
            try {
		// linha de execucao da sintaxe delete em sql
                String query = "delete from clientes where id_cliente = ? ;";
		statement=connection.prepareStatement("delete from clientes where id_cliente = ? ;");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement);
            }
	}
        
        
        
        
     public static Clientes buscarPeloCpf (String cpf) {
      
	PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset=null;
        
            try {
                // Tratando excecao do retorno selec
		statement = connection.prepareStatement("SELECT * FROM clientes WHERE cpf_cliente LIKE ?");
                statement.setString(1,"%"+cpf+"%");
		resultset=statement.executeQuery();
		while (resultset.next()) {
                    Clientes cliente =new Clientes();
                    cliente.setIdCliente(resultset.getInt("id_cliente"));
                    cliente.setNomeCliente(resultset.getString("nome_cliente"));
                    cliente.setDataNascimento(resultset.getString("data_nascimento"));
                    cliente.setCpf(resultset.getString("cpf_cliente"));
                    cliente.setSexo(resultset.getString("sexo_cliente"));
                    cliente.setTelefone(resultset.getString("telefone_cliente"));
                    return cliente;
		}
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
        return null;
    }
}
