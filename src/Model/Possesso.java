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
	private int idPossesso;

	
	public Possesso() {}

	public Possesso(int id, int squadra,int idPossesso) {
		super();
		this.id = id;
		this.squadra = squadra;
		this.idPossesso=idPossesso;
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

	public int getIdPossesso() {
		return idPossesso;
	}

	public void setIdPossesso(int idPossesso) {
		this.idPossesso = idPossesso;
	}		
	
	@Override
	public String toString() {
		return "Id Nodo:"+id+" possesso squadra:"+squadra+" idPossesso:"+idPossesso;
	}
	
	
}
