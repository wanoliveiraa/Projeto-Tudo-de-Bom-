/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.DAO;

import br.com.tudodebom.conexao.BancoDeDados;
import br.com.tudodebom.model.DetalhesCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author  walderney
 */
public class DetalhesComprasDAO {
    public static void inserirDetalhes(DetalhesCompras dc){
            Connection connection = BancoDeDados.getConnection();
            PreparedStatement statement = null;
        
        try {
            
            statement = connection.prepareStatement("INSERT INTO tbtdetalhescompras(idCompra, idItem, "
                + "nomeProduto, idProduto, qtdItens,valorTotal,valor) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?);");
            
            statement.setInt(1, dc.getIdVenda());
            statement.setInt(2, dc.getIdItem());
            statement.setString(3, dc.getNome_produto());
            statement.setInt(4, dc.getId_produto());
            statement.setInt(5, dc.getQtd_produto());
            statement.setDouble(6, dc.getValorTotal());
            statement.setDouble(7, dc.getPreco());
            
            statement.execute();
        }catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
        } finally {
            BancoDeDados.closeConnection(connection, statement);
        }
    }

    public static List<DetalhesCompras> obterItens(Integer id){
        
        List<DetalhesCompras> listaDetalhesCompra = null;
        
        Connection connection = BancoDeDados.getConnection();
        PreparedStatement statement=null;

        ResultSet result = null;
        
        try {
            statement = connection.prepareStatement("SELECT * from idVenda =?;");
            statement.setInt(1, id);
            result = statement.executeQuery();
            
           while (result.next()) {
                if (listaDetalhesCompra == null) {
                    listaDetalhesCompra = new ArrayList<>();
                }
                DetalhesCompras dc = new DetalhesCompras();
                dc.setIdVenda(result.getInt("idCompra"));
                dc.setIdItem(result.getInt("idItem"));
                dc.setNome_produto(result.getString("nomeProduto"));
                dc.setId_produto(result.getInt("idProduto"));
                dc.setQtd_produto(result.getInt("qtdItens"));
                dc.setValorTotal(result.getDouble("valorTotal"));
                dc.setPreco(result.getDouble("valor"));
                
                listaDetalhesCompra.add(dc);
            }
        }catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
       } finally {
            BancoDeDados.closeConnection(connection, statement, result);
       }
        return listaDetalhesCompra;
    } 
}
