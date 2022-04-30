package Model;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import view.DrawGraph;

public class Game {

	private Livello livello;
	private static Game instance;
	private static String encodingResource = "encodings/LittleStarsforLittleWars";
	private static Handler handler;
	private InputProgram program;
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
	
	
	public void startGame() {
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

				DrawGraph.getInstance().update(Game.getGame().getLivello());
				DrawGraph.getInstance().run();
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
