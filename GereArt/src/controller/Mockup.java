package controller;
import java.util.ArrayList;

import model.*;

public class Mockup {
	public static ArrayList<Exposicao> expos;
	
	public Mockup() {
		expos = new ArrayList<Exposicao>();
		
		ArrayList<Obra> obras = new ArrayList<Obra>();
		obras.add(new Obra("Artista HH", "Obra XX", "Arte moderna", "Pintura", "01/03/2017"));
		obras.add(new Obra("Artista XX", "Obra HH", "Arte contemporanea", "Esculptura", "01/01/2010"));
		expos.add(new Exposicao("Exposicao UJ", "24/03/2017", "25/03/2017", 0, 8.3, obras));
		
		obras.add(new Obra("ArtistaUU", "ObraUU", "Pinturas Rupestres", "Esculptura", "01/01/2010"));
		expos.add(new Exposicao("Exposicao GRAW", "24/03/2017", "26/03/2017", 0, 11.99, obras));
	}
}
