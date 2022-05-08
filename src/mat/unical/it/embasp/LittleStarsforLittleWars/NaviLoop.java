package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Game;

public class NaviLoop implements Runnable {

	private int frequency=2000;
	@Override
	public void run() {
		while (!Game.getGame().finito()) {
			
			Game.getGame().addShips();
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
