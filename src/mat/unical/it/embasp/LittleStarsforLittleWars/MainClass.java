package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Game;

public class MainClass {

	public MainClass() {
	}

	public static void main(String[] args) {

		// scelgo il livllo
		Game.getGame().scegliLivello(1);
		startGame();

	}

	public static void startGame() {
		Game.getGame().startGame();

		for (int i = 0; i < Game.getGame().getLivello().getNodi().size(); i++) {
			GameLoop gl = new GameLoop(i);
			Thread thread = new Thread(gl);
			thread.start();

		}
	}

}
