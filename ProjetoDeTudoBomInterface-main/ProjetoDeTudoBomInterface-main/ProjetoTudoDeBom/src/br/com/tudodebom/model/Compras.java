/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.model;

import java.util.ArrayList;

/**
 *
 * @author walderney
 */
public class Compras {
    private Integer idCompra;
    private Integer qtdItens;
    private Integer cpfCliente;
    private Double pagamento;
    private Double subtotal;
    private Clientes clientes;
    private ArrayList<DetalhesCompras> DetalhesCompras = new ArrayList<>();

    
     public Compras() {
        clientes = new Clientes();
        DetalhesCompras = new ArrayList<>();
    }
    
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }

    public Integer getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Integer cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
    public Double getPagamento() {
        return pagamento;
    }

    public void setPagamento(Double pagamento) {
        this.pagamento = pagamento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public ArrayList<DetalhesCompras> getDetalhesCompras() {
        return DetalhesCompras;
    }

    public void setDetalhesCompras(ArrayList<DetalhesCompras> DetalhesCompras) {
        this.DetalhesCompras = DetalhesCompras;
    }
     public void adicionarItem(DetalhesCompras dc){
        this.DetalhesCompras.add(dc);
    }
    
}
