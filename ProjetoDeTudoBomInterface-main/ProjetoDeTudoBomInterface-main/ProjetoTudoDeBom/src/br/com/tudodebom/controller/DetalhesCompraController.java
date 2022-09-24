/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.controller;

import br.com.tudodebom.DAO.DetalhesComprasDAO;
import br.com.tudodebom.model.DetalhesCompras;
import java.util.List;

/**
 *
 * @author walderney
 */
public class DetalhesCompraController {
       //Inserir
    public static String inserir(DetalhesCompras dc){
        String resp=null;
        
        try{
            DetalhesComprasDAO.inserirDetalhes(dc);
        }catch(Exception e){
            e.printStackTrace();
            resp="erro na fonte de dados";
        }
       return resp;
    }
    
    //obeter 
    public static List<DetalhesCompras> obterDb(int idCompra) {
      List<DetalhesCompras> listaDC = null;
        try{
           listaDC=DetalhesComprasDAO.obterItens(idCompra);
        }catch(Exception e){ 
            System.out.println("erro na fonte de dados " + e.getMessage());
        }
        return listaDC;
    }
}
