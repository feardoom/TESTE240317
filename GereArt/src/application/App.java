package application;

import controller.GestaoExposicoes;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
public class App {

	public static void main(String[] args) {
		GestaoExposicoes GE = new GestaoExposicoes();
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				    boolean visita = false; 
					Random rnd = new Random();
					visita = rnd.nextInt((1 - 0) + 1)==1?true:false;
					if (visita) {
						GE.visita();
					}
					
			  }
		}, 0, 2000);
		
		GE.menuExposicoes();
		
		
		
		

	}

}
