package controller;

import java.util.ArrayList;
import java.util.Random;
import model.Exposicao;
import model.Obra;
import tools.easyIO;

public class GestaoExposicoes {
	private ArrayList<Exposicao> exposicoes;
	private static easyIO io = new easyIO();
	
	public GestaoExposicoes() {
		//exposicoes = new ArrayList<Exposicao>();
		exposicoes = new Mockup().expos;
	}
	
	public void menuExposicoes() {
		int op;
		do {
			io.writeL("Escolha uma opcao");
			io.writeL("1. Inserir Exposicao");
			io.writeL("2. Listar Exposicoes");
			io.writeL("3. Detalhes Exposicao");
			io.writeL("4. Gerir Obras");
			io.writeL("5. Lucros");
			io.writeL("0. Sair");
			op = io.readN();
			
			switch (op) {
				case 1:
					inserirExposicao();
					break;
				case 2:
					listarExposicoes();
					break;
				case 3:
					detalheExposicao();
					break;
				case 4:
					gerirObras();
					break;
				case 5:
					mostrarLucros();
					break;
			}
		}while(op!=0);
	}
	
	public void inserirExposicao() {
		Exposicao ex =  new Exposicao();
		
		io.writeL("\nIntroduza o Nome da Exposicao"); 
		ex.setNome(io.readS());
		
		io.writeL("Introduza a data de inicio");
		ex.setData_inicio(io.readS());
		
		io.writeL("Introduza a data de fim");
		ex.setData_fim(io.readS());
		
		io.writeL("Introduza o preco");
		ex.setPreco(io.readD());
		
		io.write("Agora introduza os Obras para esta exposicao");
		GestaoObras GO = new GestaoObras();
		GO.inserirObras();
		ex.setObras(GO.getAll());
							
		this.exposicoes.add(ex);
	}	
	
	public void listarExposicoes() {
		io.writeL("\nExposicoes/Obras");
		for(Exposicao e:exposicoes) {
			io.writeL("\nNome da exposicao: " + e.getNome());
			io.writeL("Visitantes até agora: " + e.getVisitantes());
			if (e.getObras().size()>0) {
				io.writeL("-> tem as obras: ");
				GestaoObras GO = new GestaoObras(e.getObras());
				for(Obra o:GO.getAll()) {
					GO.mostrarObra(o);			
				}
				
			}
		}
	}
	
	public void detalheExposicao() {
		io.writeL("Introduza o nome da exposicao a detalhar");
		Exposicao ex = this.getByString(io.readS());
		if (ex!=null) {
			io.writeL("\nNome da exposicao: " + ex.getNome());
			io.writeL("Data de inicio: " + ex.getData_inicio());
			io.writeL("Data de fim: " + ex.getData_fim());
			io.writeL("Preco: " + ex.getPreco());
			io.writeL("Visitantes até agora: " + ex.getVisitantes());
			io.writeL("Já lucrou: " + ex.getLucro() + " €");
			io.writeL("-> tem as obras: ");
			GestaoObras GO = new GestaoObras(ex.getObras());
			for(Obra o:GO.getAll()) {
				GO.mostrarObra(o);			
			}
		} else {
			io.writeL("Exposicao com esse nome nao existe!\n");
		}
	}
	
	public void gerirObras() {
		io.writeL("Introduza o nome da exposicao que quer gerir");
		Exposicao ex = this.getByString(io.readS());
		int index = exposicoes.indexOf(ex);
		if (ex!=null) {
			io.writeL("A gerir Obras da exposicao " + ex.getNome() + "\n");
			GestaoObras GO = new GestaoObras(ex.getObras());
			GO.menuObras();
			exposicoes.get(index).setObras(GO.getAll());
		} else {
			io.writeL("Exposicao com esse nome nao existe!\n");
		}
	}
	
	public void mostrarLucros() {
		if (exposicoes.size()>0) {
			double total = 0;
			Exposicao maior = exposicoes.get(0);
			for(Exposicao e:exposicoes) {
				io.writeL("A exposicao " + e.getNome() + " lucrou " + e.getLucro() + " €");	
				total += e.getLucro();
				if (e.getLucro()>maior.getLucro()) {
					maior = e;
				}
			}
			io.writeL("A exposicao " + maior.getNome() + " foi a que lucrou mais com " + maior.getLucro() + " €");
			io.writeL("No total das exposicoes, houve um lucro de " + total + " €\n");
		}
	}
		
	public Exposicao getByString(String nome) {
		for(Exposicao expo:this.exposicoes) {
			if (expo.getNome().equals(nome)) {
				return expo;
			}
		}
		return null;
	}
		
	public void visita() {
		if (this.exposicoes.size()>0) {
			Random rnd = new Random();
			int pos;
			pos = rnd.nextInt(this.exposicoes.size());
			this.exposicoes.get(pos).visita();
		}		
	}
}
