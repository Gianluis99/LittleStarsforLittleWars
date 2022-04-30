package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Arco;
import Model.Game;

import Model.Nodo;
import Model.Possesso;

import it.unical.mat.embasp.base.Output;

import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

import view.DrawGraph;

public class MainClass {

	public MainClass() {
	}

	public static void main(String[] args) {

		// scelgo il livllo
		Game.getGame().scegliLivello(1);

		Game.getGame().startGame();

		// il ciclo finirà quando una squadra avrà impossessato tutti i livelli
		while (!Game.getGame().getLivello().isFinito()) {
			// scorro tutti i nodi che hanno gia una squadra, in modo tale che posso
			// compiere delle scelte
			for (int idNodo = 0; idNodo < Game.getGame().getLivello().getNodi().size(); idNodo++) {

				Possesso possesso = Game.getGame().getLivello().getPossesso(idNodo);

				if (possesso != null) {

					// setto il nodo principale con -2 in modo che solo lui potrà compiere una
					// scelta
					Game.getGame().getLivello().setNodoPrincipale(possesso, -2);
					// aggiungo i fatti tramite codice grazie alla classe livello
					try {
						// prendo gli archi e poi prendo i nodi collegati
						for (Arco a : Game.getGame().getLivello().getArchi()) {

							Game.getGame().getProgram().addObjectInput(a);
							for (Nodo n : Game.getGame().getLivello().getNodi()) {
								Game.getGame().getProgram().addObjectInput(n);

							}
							for (Possesso p : Game.getGame().getLivello().getPossessoNodi()) {
								Game.getGame().getProgram().addObjectInput(p);

							}
						}

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Game.getGame().getHandler().addProgram(Game.getGame().getProgram());

					Output o = Game.getGame().getHandler().startSync();
					// prendiamo gli answerSet
					AnswerSets answers = (AnswerSets) o;
					for (AnswerSet a : answers.getOptimalAnswerSets()) {
						System.out.println("AS ragiona il nodo:" + idNodo);
						try {
							for (Object obj : a.getAtoms()) {
								// se è un oggetto della classe possesso
								if ((obj instanceof Possesso)) {

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
							DrawGraph.getInstance().update(Game.getGame().getLivello());

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// alla fine il nodo principale tornerà a -1
					Game.getGame().getLivello().setNodoPrincipale(possesso, -1);
				}
			}
		}
	}

}
