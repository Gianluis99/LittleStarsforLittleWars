package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Game;


public class GameLoop implements Runnable {

	private int idNodo;

	public GameLoop(int n) {
		this.idNodo = n;
	}

	@Override
	public void run() {
		// il ciclo finir� quando una squadra avr� impossessato tutti i livelli
		while (!Game.getGame().finito()) {
			Game.getGame().startThread(idNodo);
		}
		System.out.println("ho finito");

	}

}
