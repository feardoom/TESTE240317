package controller;

import java.util.ArrayList;
import tools.easyIO;
import model.Exposicao;
import model.Obra;

public class GestaoObras {
	private ArrayList<Obra> obras;
	private static easyIO io = new easyIO();
	
	public GestaoObras() {
		this.obras = new ArrayList<Obra>();
	}
	
	public GestaoObras(ArrayList<Obra> obras) {
		this.obras = obras;
	}
	
	public void menuObras() {
		int op;
		do {
			io.writeL("Escolha uma opcao");
			io.writeL("1. Inserir Obra");
			io.writeL("2. Listar Obras");
			io.writeL("3. Eliminar Obra");
			io.writeL("0. Sair");
			op = io.readN();
			
			switch (op) {
				case 1:
					inserirObras();
					break;
				case 2:
					listarObras();
					break;
				case 3:
					eliminarObra();
					break;
			}
		}while(op!=0);
	}
	
	public void inserirObras() {
		char op = ' ';
		do {
			Obra ob =  new Obra();
		
			io.writeL("\nIntroduza o Nome do/a Artista"); 
			ob.setArtista(io.readS());
			
			io.writeL("Introduza o Titulo da Obra");
			ob.setTitulo(io.readS());
			
			io.writeL("Introduza a categoria/tema da Obra");
			ob.setCategoria(io.readS());
			
			io.writeL("Introduza o Tipo da Obra (pintura/esculptura)");
			ob.setTipo(io.readS());
			
			io.writeL("Introduza a data de criação desta Obra");
			ob.setData(io.readS());
			
			this.obras.add(ob);
			
			io.writeL("Deseja introduzir mais obras?");
			op = io.readC();
			
		}while(op!='N' && op!='n');
		
	}
	
	public void listarObras() {
		for (Obra o:this.obras) {
			mostrarObra(o);
		}
	}
	
	public void eliminarObra() {
		io.writeL("Introduza o titulo da obra que pretende eliminar");
		Obra o = this.getByString(io.readS());
		if (o!=null) {
			obras.remove(o);
			io.writeL("Obra eliminada\n");
		} else {
			io.writeL("Obra com esse titulo nao existe\n");
		}
	}
	
	public Obra getByString(String nome) {
		for(Obra o:this.obras) {
			if (o.getTitulo().equals(nome)) {
				return o;
			}
		}
		return null;
	}
	
	public void mostrarObra(Obra obra) {
		io.writeL("   Artista: " + obra.getArtista());
		io.writeL("   Titulo: " + obra.getTitulo() + " (" + obra.getTipo() + ")");
		io.writeL("   Categoria: " + obra.getCategoria());
		io.writeL("   Data produção: " + obra.getData() + "\n");
	}
	
	public ArrayList<Obra> getAll() {
		return this.obras;
	}
}
