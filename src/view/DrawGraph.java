package view;


import javax.swing.JFrame;

import Model.Livello;


public class DrawGraph {
	//essendo che avremo piu thread che lavoreranno in parallelo allora ci serve un unica instanza che disegna il grafo
	
	
	//riceve un livello e lo disegna
	private JFrame f = new JFrame();
	private MainPanel j;
	private static DrawGraph instance;
	
	private DrawGraph() {
		j = new MainPanel();
		setFrame();
	}
	
	public static DrawGraph getInstance() {
		if(instance==null) {
			instance=new DrawGraph();
		}
		return instance;
	}

	public void run() {

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setFrame() {
		f.setSize(1300, 750);
		f.add(j);
		f.setResizable(false);
		
	}
	
	//aggiorna il livello(grafica)
	public void update(Livello livello) {
		j.update(livello);
	}



	
}
