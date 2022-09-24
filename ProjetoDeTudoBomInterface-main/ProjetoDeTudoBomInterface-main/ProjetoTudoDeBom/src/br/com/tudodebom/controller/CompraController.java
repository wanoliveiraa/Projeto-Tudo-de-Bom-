/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.controller;

import br.com.tudodebom.DAO.CompraDAO;
import br.com.tudodebom.model.Compras;

/**
 *
 * @author walderney
 */
public class CompraController {
    
    //Inserir
    public static String inserir(Compras compras){
        String resp=null;
        
        try{
            CompraDAO.inserirCompras(compras);
        }catch(Exception e){
            e.printStackTrace();
            resp="erro na fonte de dados";
        }
       return resp;
    }
    
    //obeter 
    public static Compras getUltima() {
        Compras compras = new Compras();
        try{
           compras=CompraDAO.getUltima();
        }catch(Exception e){ 
            System.out.println("erro na fonte de dados " + e.getMessage());
        }
        return compras;
    }
}   
