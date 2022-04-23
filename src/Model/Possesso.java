package Model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("possesso")
public class Possesso {

	@Param(0)
	private int id;
	@Param(1)
	private int squadra;
	@Param(2)
	private int istante;

	
	public Possesso() {}

	public Possesso(int id, int squadra,int istante) {
		super();
		this.id = id;
		this.squadra = squadra;
		this.istante=istante;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSquadra() {
		return squadra;
	}

	public void setSquadra(int squadra) {
		this.squadra = squadra;
	}

	public int getIstante() {
		return istante;
	}

	public void setIstante(int istante) {
		this.istante = istante;
	}		
	
	@Override
	public String toString() {
		return "Id Nodo:"+id+" possesso squadra:"+squadra+" istante:"+istante;
	}
	
	
}
