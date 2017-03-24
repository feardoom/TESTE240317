package model;

import java.util.ArrayList;

public class Exposicao {
	private String nome;
	private String data_inicio;
	private String data_fim;
	private int visitantes;
	private double preco;
	private ArrayList<Obra> obras;
	
	public Exposicao() {
		obras = new ArrayList<Obra>();
	}

	public Exposicao(String nome, String data_inicio, String data_fim, int visitantes, double preco, ArrayList<Obra> obras) {
		this.nome = nome;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.visitantes = visitantes;
		this.preco = preco;
		this.obras = obras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public int getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(int visitantes) {
		this.visitantes = visitantes;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public ArrayList<Obra> getObras() {
		return obras;
	}

	public void setObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}
	
	public double getLucro() {
		return this.getPreco()*this.getVisitantes();
	}
	
	public void visita() {
		this.visitantes++;
	}
	
	
}
