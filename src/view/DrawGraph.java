package view;


import javax.swing.JFrame;

import Model.Livello;


public class DrawGraph {

	//riceve un livello e lo disegna
	private Livello livello;
	private JFrame f = new JFrame();
	private MainPanel j;

	public DrawGraph(Livello livello) {
		this.setLivello(livello);
		 j = new MainPanel(livello);
		setFrame();
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
		this.setLivello(livello);
		j.update();
	}

	public Livello getLivello() {
		return livello;
	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}

	
}
