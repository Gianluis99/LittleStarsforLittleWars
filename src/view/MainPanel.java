package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.Arco;
import Model.Livello;
import Model.Nodo;
import Model.Possesso;
import Model.Squadra;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2675341124466607264L;
	private Livello livello;

	public MainPanel(Livello livello) {

		setBackground(new Color(114, 220, 241));
		this.livello = livello;
	}

	
	//disegna gli archi in base al possesso
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Arco e : livello.getArchi()) {
			g.setColor(new Color(48, 45, 33));

			for (Possesso p : livello.getPossessoNodi()) {
				for (Possesso p2 : livello.getPossessoNodi()) {

					if (e.getId1() == p.getId() && e.getId2() == p2.getId()) {
						if (p.getSquadra() == Squadra.blu && p2.getSquadra()== Squadra.blu || p.getSquadra() == Squadra.blu && p2.getSquadra()== Squadra.nessuno || p.getSquadra() == Squadra.nessuno && p2.getSquadra()== Squadra.blu)
							g.setColor(new Color(34, 139, 214));

						else if (p.getSquadra() == Squadra.gialla && p2.getSquadra()== Squadra.gialla || p.getSquadra() == Squadra.gialla && p2.getSquadra()== Squadra.nessuno || p.getSquadra() == Squadra.nessuno && p2.getSquadra()== Squadra.gialla)
							g.setColor(new Color(159, 173, 21));
					

					}

				}
			}

			e.draw(g);

		}

		//disegna i  nodi in base al possesso
		for (Nodo n : livello.getNodi()) {
			g.setColor(new Color(151, 164, 154));

			for (Possesso p : livello.getPossessoNodi()) {
				if (n.getId() == p.getId()) {
					if (p.getSquadra() == Squadra.blu)
						g.setColor(new Color(34, 139, 214));

					else if (p.getSquadra() == Squadra.gialla)
						g.setColor(new Color(159, 173, 21));

					else if (p.getSquadra() == Squadra.nessuno)
						g.setColor(new Color(151, 164, 154));
				}

			}
			n.draw(g);
		}

	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}

	//aggiorna la grafica
	public void update() {
		repaint();
	}

}
