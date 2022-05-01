package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Arco;
import Model.Game;
import Model.Nodo;
import Model.Possesso;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class GameLoop implements Runnable {

	private int idNodo;

	public GameLoop(int n) {
		this.idNodo = n;
	}

	@Override
	public void run() {
		// il ciclo finirà quando una squadra avrà impossessato tutti i livelli
		while (!Game.getGame().finito()) {
		

			Possesso possesso = Game.getGame().getLivello().getPossesso(idNodo);

			//Se il nodo in questione ha una squadra allora potrà compiere una scelta
			if (possesso != null) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				synchronized (Game.getGame()) {
					try {
						Thread.sleep(1000);
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
					//questo permetterà anche di avere i  fatti aggiornati ogni volta
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
					// prendiamo l' answerSet ottimale
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
							Game.getGame().update();

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
		System.out.println("ho finito");
	}

}
