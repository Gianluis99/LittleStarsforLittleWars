package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Game;

public class MainClass {

	public MainClass() {
	}

	public static void main(String[] args) {

		// scelgo il livello
		Game.getGame().scegliLivello(4);
		Game.getGame().startGame();
		
		

	}

	
	

}
