package Model;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import mat.unical.it.embasp.LittleStarsforLittleWars.GameLoop;
import view.DrawGraph;

public class Game {

	//la classe Game si occupaerà di avere una sola instanza di livello, di gestire il programma e le opzioni 
	//si occuperà quindi della logica e fungerà anche da controller(poiche abbiamo poche cose da gestire)
	
	private Livello livello;
	private static Game instance;
	private static String encodingResource = "encodings/LittleStarsforLittleWars";
	private static Handler handler;
	private InputProgram program;
	


	private Game() {

	}

	public static Game getGame() {
		if (instance == null)
			instance = new Game();

		return instance;
	}

	public Livello getLivello() {
		return livello;
	}

	public void scegliLivello(int type) {
		if (type == 1)
			this.livello = Livelli.livelloUno();

	}

	public void startProgram() {
		// Windows:
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
		OptionDescriptor option = new OptionDescriptor("--no-facts");
		handler.addOption(option);

		// su Linux 64bit :
		// handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));

		program = new ASPInputProgram();
		program.addFilesPath(encodingResource);

		try {
			ASPMapper.getInstance().registerClass(Nodo.class);
			ASPMapper.getInstance().registerClass(Arco.class);
			ASPMapper.getInstance().registerClass(Possesso.class);
		} catch (ObjectNotValidException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAnnotationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public void startGame() {

		DrawGraph.getInstance().run();
	}
	
	public void play() {
		DrawGraph.getInstance().playGame();
		for (int i = 0; i < Game.getGame().getLivello().getNodi().size(); i++) {
			GameLoop gl = new GameLoop(i);
			Thread thread = new Thread(gl);
			thread.start();

		}
	}
	
	
	

	public void update() {
		DrawGraph.getInstance().update();

	}
	
	
	
	
	public boolean finito() {
		if(livello.isFinito()) {
			DrawGraph.getInstance().endGame();
			return true;
		}
		
		return false;
	}
	
	
	//il thread inizia a ragionare  e lo farà fin quando una squadra non avrà vinto
	public void startThread(int idNodo) {
		
		while (!Game.getGame().getLivello().isFinito()) {
			// scorro tutti i nodi che hanno gia una squadra, in modo tale che posso
			// compiere delle scelte

			Possesso possesso = Game.getGame().getLivello().getPossesso(idNodo);

			if (possesso != null) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				synchronized (Game.getGame()) {
					try {
						Thread.sleep(1300);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					Game.getGame().startProgram();
					InputProgram program = Game.getGame().getProgram();
					Handler handler = Game.getGame().getHandler();

					// setto il nodo principale con -2 in modo che solo lui potrà compiere una
					// scelta
					Game.getGame().getLivello().setNodoPrincipale(possesso, -2);
					
					// aggiungo i fatti tramite codice grazie alla classe livello
					//il mettiamo ad ogni ciclo poiche si aggiorneranno
					try {
						// prendo gli archi e poi prendo i nodi collegati
						for (Arco a : Game.getGame().getLivello().getArchi()) {

							program.addObjectInput(a);
							for (Nodo n : Game.getGame().getLivello().getNodi()) {
								program.addObjectInput(n);

							}
							for (Possesso p : Game.getGame().getLivello().getPossessoNodi()) {
								program.addObjectInput(p);

							}
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					handler.addProgram(program);

					Output o = handler.startSync();
					// prendiamo gli answerSet
					AnswerSets answers = (AnswerSets) o;
					for (AnswerSet a : answers.getOptimalAnswerSets()) {
						System.out.println("AS ragiona il nodo:" + idNodo);
						try {
							for (Object obj : a.getAtoms()) {

								// se è un oggetto della classe possesso
								if ((obj instanceof Possesso)) {
									System.out.println("fatto nuovo");
									Possesso po = (Possesso) obj;
									po.setIdPossesso(-1);

									Nodo nodo = Game.getGame().getLivello().getNodo(possesso.getId());

									// aggiorniamo il costo del nodo impossessato
									Nodo nodo1 = Game.getGame().getLivello().getNodo(po.getId());
									int costo = -nodo1.getCosto();
									nodo1.setCosto(nodo.getCosto() + costo);
									Game.getGame().getLivello().setNodo(nodo);

									// aggiorniamo il costo del nodo principale
									nodo.setCosto(0);
									Game.getGame().getLivello().setNodo(nodo);

									// aggiungiamo il nodo impossessato al livello
									Game.getGame().getLivello().addPossesso(po);
									System.out.println(po);
								} else if ((obj instanceof Nodo)) {

									Nodo no = (Nodo) obj;
									System.out.println(no);
									Game.getGame().getLivello().setNodo(no);
								}

							}
							// aggiorna la grafica
							DrawGraph.getInstance().update();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// alla fine il nodo principale tornerà a -1
					Game.getGame().getLivello().setNodoPrincipale(possesso, -1);
					program.clearAll();
				}
			}
		}

	}

	public Handler getHandler() {
		return handler;
	}

	public static void setHandler(Handler handler) {
		Game.handler = handler;
	}

	public InputProgram getProgram() {
		return program;
	}

	public void setProgram(InputProgram program) {
		this.program = program;
	}
}
