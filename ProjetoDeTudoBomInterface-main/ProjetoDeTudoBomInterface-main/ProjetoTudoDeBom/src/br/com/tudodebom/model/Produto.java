/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tudodebom.model;

/**
 *
 * @author walderneyy
 */
public class Produto {
    
    	private Integer id_produto;
	private String nome_produto;
	private Integer qtd_produto;
	private Boolean tipo_medicamento;
	private Boolean tipo_generico;
	private Double preco;
       
	
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public int getQtd_produto() {
		return qtd_produto;
	}
	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
	}
	public boolean isTipo_medicamento() {
		return tipo_medicamento;
	}
	public void setTipo_medicamento(Boolean tipo_medicamento) {
		this.tipo_medicamento = tipo_medicamento;
	}
	public boolean isTipo_generico() {
		return tipo_generico;
	}
	public void setTipo_generico(Boolean tipo_generico) {
		this.tipo_generico = tipo_generico;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
    
}
