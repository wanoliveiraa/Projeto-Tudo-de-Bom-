/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.model;

/**
 *
 * @author ritha
 */

    public class Compra {
    
    private int cliente_id;
    private int cod_compra;
    private Double valorTotal;
    private String data_compra;

    public int getCliente_id() {
            return cliente_id;
    }
    public void setCliente_id(int cliente_id) {
            this.cliente_id = cliente_id;
    }
    public int getCod_compra() {
            return cod_compra;
    }
    public void setCod_compra(int cod_compra) {
            this.cod_compra = cod_compra;
    }
    public Double getValorTotal() {
            return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
            this.valorTotal = valorTotal;
    }
    public String getData_compra() {
            return data_compra;
    }
    public void setData_compra(String data_compra) {
            this.data_compra = data_compra;
    }
}

