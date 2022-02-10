package mat.unical.it.embasp.LittleStarsforLittleWars;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class MainClass {

	public MainClass() {
	}

	private static String encodingResource;

	private static Handler handler;

	public static void main(String[] args) {

		//Windows:
		handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));

		//  su Linux 64bit :
		// handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2"));

	}

}
