package mat.unical.it.embasp.LittleStarsforLittleWars;

import Model.Arco;
import Model.Game;

import Model.Nodo;
import Model.Possesso;
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
import view.DrawGraph;

public class MainClass {

	public MainClass() {
	}

	private static String encodingResource = "encodings/LittleStarsforLittleWars";
	private static Handler handler;
	private static DrawGraph dg;

	public static void main(String[] args) {

		// scelgo il livllo
		Game.getGame().scegliLivello(1);

		// Windows:
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
		OptionDescriptor option = new OptionDescriptor("--no-facts");
		handler.addOption(option);

		// su Linux 64bit :
		// handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));

		InputProgram program = new ASPInputProgram();
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

		dg = new DrawGraph(Game.getGame().getLivello());
		dg.run();

		
		// il ciclo finirà quando una squadra avrà impossessato tutti i livelli
		while (!Game.getGame().getLivello().isFinito()) {
			// scorro tutti i nodi che hanno gia una squadra, in modo tale che posso
			// compiere delle scelte
			for (int idNodo = 0; idNodo < 6; idNodo++) {

				Possesso possesso = Game.getGame().getLivello().getPossesso(idNodo);

				if (possesso != null) {

					// setto il nodo principale con -2 in modo che solo lui potrà compiere una
					// scelta
					Game.getGame().getLivello().setNodoPrincipale(possesso, -2);
					// aggiungo i fatti tramite codice grazie alla classe livello
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
						System.out.println("AS ragiona il nodo:"+idNodo);
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
							dg.update(Game.getGame().getLivello());

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
