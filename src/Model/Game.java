package Model;

public class Game {

	private Livello livello;
	private static Game instance;
	
	private Game() {
		
	}
	
	public static Game getGame() {
		if(instance==null)
			instance=new Game();
		
		return instance;
	}
	
	
	public Livello getLivello() {
		return livello;
	}
	
	public   void scegliLivello(int type) {
		if (type == 1)
			this.livello=Livelli.livelloUno();

	}
}
