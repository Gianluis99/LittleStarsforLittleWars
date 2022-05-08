package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Game;


public class GameLoop implements Runnable {

	private int idNodo;
	private int frequency=3000;
	public GameLoop(int n) {
		this.idNodo = n;
	}

	@Override
	public void run() {
		// il ciclo finirà quando una squadra avrà impossessato tutti i livelli
		while (!Game.getGame().finito()) {
			Game.getGame().startThread(idNodo);
			
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("ho finito");

	}

}
