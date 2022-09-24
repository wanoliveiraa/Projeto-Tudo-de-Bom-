/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tudodebom.conexao.BancoDeDados;
import br.com.tudodebom.model.Produto;
import br.com.tudodebom.model.Produto;
import java.sql.SQLException;
/**
 *
 * @author Atlas
 */
public class ProdutosDAO {
    
    //	------------ CRUD PRODUTOS ------------

	public List<Produto> getProdutos(){
        PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset;

		List<Produto> produtos = new ArrayList<Produto>();
				
		try {
			String query = "Select * from produto";
                statement = connection.prepareStatement(query);
		resultset=statement.executeQuery(query);
			while(resultset.next()) {
				Produto produto = new Produto();
				produto.setId_produto(resultset.getInt("id_produto"));
				produto.setNome_produto(resultset.getString("nome_produto"));
				produto.setQtd_produto(resultset.getInt("qtd_produto"));
				produto.setTipo_medicamento(resultset.getBoolean("tipo_medicamento"));
				produto.setTipo_generico(resultset.getBoolean("tipo_generico"));
				produto.setPreco(resultset.getDouble("preco"));
				produtos.add(produto);
			}
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		return produtos;
	}
	
	// insercao
	public void InserirProdutos(Produto produto) {
            PreparedStatement statement=null;
            Connection connection = BancoDeDados.getConnection();
            ResultSet resultset;
		try {
			String query = "insert into produto values (null, '"+ produto.getNome_produto() +"'," + produto.getQtd_produto() +","+produto.isTipo_generico() + "," + produto.isTipo_medicamento() +", "+produto.getPreco()+");";

			System.out.println(query);
			statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	//Edicao
	public void ModificarProduto(Produto produto) {
                PreparedStatement statement=null;
            Connection connection = BancoDeDados.getConnection();
            ResultSet resultset;
		try {
			String query = "update produto set nome_produto ='" + produto.getNome_produto() + "', qtd_produto = '" + produto.getQtd_produto() + "', preco="+produto.getPreco()+"   where id_produto =" + produto.getId_produto()+ ";";
			System.out.println(query);

			statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	//Exclusao
	public void ExcluirProduto (Produto produto) {
            PreparedStatement statement=null;
            Connection connection = BancoDeDados.getConnection();
            ResultSet resultset;
		try {
			String query = "delete from produto where id_produto="+ produto.getId_produto() +" ;";
			statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
	
		}
		
	}
    public List<Produto> buscarPeloNomeProdutos(String nome) {
        List<Produto> lista = new ArrayList<>();
	PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset=null;
        
            try {
                // Tratando excecao do retorno selec
		statement = connection.prepareStatement("SELECT * FROM Produto WHERE nome_produto LIKE ?");
                statement.setString(1,"%"+nome+"%");
		resultset=statement.executeQuery();
		while (resultset.next()) {
                    Produto produto =new Produto();
                    produto.setId_produto(resultset.getInt("id_produto"));
                    produto.setNome_produto(resultset.getString("nome_produto"));
                    produto.setQtd_produto(resultset.getInt("qtd_produto"));
                    produto.setTipo_medicamento(resultset.getBoolean("tipo_medicamento"));
                    produto.setTipo_generico(resultset.getBoolean("tipo_generico"));
                    produto.setPreco(resultset.getDouble("preco"));
                    lista.add(produto);
		}
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
        return lista;
    }
    public Produto buscarPeloid(Integer id) {
        List<Produto> lista = new ArrayList<>();
	PreparedStatement statement=null;
	Connection connection = BancoDeDados.getConnection();
	ResultSet resultset=null;
        
            try {
                // Tratando excecao do retorno selec
		statement = connection.prepareStatement("SELECT * FROM Produto WHERE nome_produto LIKE ?");
                statement.setString(1,"%"+id+"%");
		resultset=statement.executeQuery();
		while (resultset.next()) {
                    Produto produto =new Produto();
                    produto.setId_produto(resultset.getInt("id_produto"));
                    produto.setNome_produto(resultset.getString("nome_produto"));
                    produto.setQtd_produto(resultset.getInt("qtd_produto"));
                    produto.setTipo_medicamento(resultset.getBoolean("tipo_medicamento"));
                    produto.setTipo_generico(resultset.getBoolean("tipo_generico"));
                    produto.setPreco(resultset.getDouble("preco"));
                    return produto;
		}
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
        return null;
    }
}