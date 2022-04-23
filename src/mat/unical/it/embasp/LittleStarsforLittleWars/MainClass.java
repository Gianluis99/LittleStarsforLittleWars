package mat.unical.it.embasp.LittleStarsforLittleWars;


import Model.Arco;
import Model.Livelli;
import Model.Livello;
import Model.Nodo;
import Model.Possesso;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
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
		Livello livello = scegliLivello(1);

		dg = new DrawGraph(livello);
		dg.run();

		// Windows:
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
		OptionDescriptor option = new OptionDescriptor("--no-facts");
		handler.addOption(option);

		// su Linux 64bit :
		// handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));

		InputProgram program = new ASPInputProgram();
		program.addFilesPath(encodingResource);

		//aggiungo i fatti tramite codice grazie alla classe livello
		try {
			ASPMapper.getInstance().registerClass(Nodo.class);
			ASPMapper.getInstance().registerClass(Arco.class);
			ASPMapper.getInstance().registerClass(Possesso.class);

			// prendo gli archi e poi prendo i nodi collegati
			for (Arco a : livello.getArchi()) {

				program.addObjectInput(a);
				for (Nodo n : livello.getNodi()) {
					program.addObjectInput(n);

				}
				for (Possesso p : livello.getPossessoNodi()) {
					program.addObjectInput(p);

				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		handler.addProgram(program);
		Output o = handler.startSync();

		//prendiamo gli answerSet
		AnswerSets answers = (AnswerSets) o;
		for (AnswerSet a : answers.getAnswersets()) {
			System.out.println("AS");
			try {
				for (Object obj : a.getAtoms()) {
					// se  è un oggetto della classe possesso
					if ((obj instanceof Possesso)) {

						Possesso po = (Possesso) obj;
						livello.addPossesso(po);
						System.out.println(po);
					} else if ((obj instanceof Nodo)) {

						Nodo no = (Nodo) obj;
						System.out.println(no);
						livello.setNodo(no);
					}

				}
				// aggiorna la grafica
				dg.update(livello);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
	
	private static Livello scegliLivello(int livello) {
		if (livello == 1)
			return Livelli.livelloUno();

		return null;
	}

}
