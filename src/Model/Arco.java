package Model;


import java.awt.Graphics;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("arco")
public class Arco {

	@Param(0)
	private int id1; //id nodo 1
	
	@Param(1)
	private int id2; //id nodo 2

	
	//inseriamo  i Nodi collegati che ci servono per avere le coordinate 
	private Nodo nodo1;
	private Nodo nod2;
	
	public Nodo getNodo1() {
		return nodo1;
	}


	public void setNodo1(Nodo nodo1) {
		this.nodo1 = nodo1;
	}


	public Nodo getNod2() {
		return nod2;
	}


	public void setNod2(Nodo nod2) {
		this.nod2 = nod2;
	}


	public Arco() {}
	
	
	public Arco(int id1, int id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}


	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}
	
	public void draw(Graphics g) {
		
         g.drawLine(nodo1.getX()+30, nodo1.getY()+30, nod2.getX()+30, nod2.getY()+30);
	}
	
	
}
