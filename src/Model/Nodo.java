package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("nodo")
public class Nodo {

	@Param(0)
	private int id; //id nodo
	
	@Param(1)
	private int costo; //costo del nodo indica quante navi ha a disposizione
	
	@Param(2)
	private int livello; //livello del nodo
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	private int x;
	private int y;
	
	public Nodo() {	}
	
	public Nodo(int id,int costo, int livello) {
		this.id=id;
		this.costo=costo;
		this.livello=livello;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getLivello() {
		return livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nodo:"+id+" Costo:"+costo+" Livello:"+livello;
	}
	
	public void draw(Graphics g) {
		Font myFont = new Font ("Courier New", 1, 22);
		g.setFont(myFont);
		g.fillOval(x, y,60, 60);
		g.setColor(Color.white);
		g.drawString(Integer.toString(costo), x +20, y+35);
	}
	
}
