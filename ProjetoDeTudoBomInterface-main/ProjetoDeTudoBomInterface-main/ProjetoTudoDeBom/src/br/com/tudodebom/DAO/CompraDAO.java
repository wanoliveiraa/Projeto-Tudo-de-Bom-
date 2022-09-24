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

import br.com.tudodebom.model.Compras;
import java.sql.SQLException;
/**
 *
 * @author walderney
 */
public class CompraDAO {

    /**
     *
     * @return
     */
    public static List<Compras> getCompras(){
		List<Compras> compras = new ArrayList<>();
                PreparedStatement statement=null;
                Connection connection = BancoDeDados.getConnection();
                ResultSet resultset=null;	
		try {
			String query = "select * from tbcompra";
                        statement = connection.prepareStatement(query);
                         resultset=statement.executeQuery(query);
    			while(resultset.next()) {
				Compras compra = new Compras();
				compra.setIdCompra(resultset.getInt("id"));
                                compra.setQtdItens(resultset.getInt("qqtdVendas"));
                                compra.setPagamento(resultset.getDouble("pagamento"));
                                compra.setSubtotal(resultset.getDouble("subtotal"));
                                compra.getClientes().setNomeCliente(resultset.getString("cpfCliente"));
			}
		}catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                BancoDeDados.closeConnection(connection, statement, resultset);
            }
            return compras;
	}
    
    public static void inserirCompras(Compras compras) {
           
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = BancoDeDados.getConnection();
           
            statement = connection.prepareStatement("INSERT INTO TBCOMPRA(id,qtdVendas, pagamento,subtotal,cpfCliente)"
                + "VALUES(?, ?, ?, ?, ?);");
            
            statement.setInt(1,compras.getIdCompra());
            statement.setInt(2, compras.getQtdItens());
            statement.setDouble(3, compras.getPagamento());
            statement.setDouble(4,compras.getSubtotal());
            statement.setString(5, compras.getClientes().getNomeCliente());
            statement.execute();
        }catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            BancoDeDados.closeConnection(connection, statement);
        }   
    }
     public static Compras getUltima() 
        throws SQLException, Exception {
        
        String sql = "SELECT MAX(id) qtdVendas FROM tbcompra";
        
        Connection connection = null;
        PreparedStatement statement=  null;
        ResultSet result = null;
        
        try {
            connection = BancoDeDados.getConnection();
            statement= connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            if(result.next()){
                Compras compras = new Compras();
                compras.setIdCompra(result.getInt("qtdVendas"));
                
                return compras;
            } 
        }catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            BancoDeDados.closeConnection(connection, statement,result);
        }  
        
        return null;
    }
}
