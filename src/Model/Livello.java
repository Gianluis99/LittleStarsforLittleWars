package Model;

import java.util.ArrayList;
import java.util.List;

public class Livello {

	//composto da archi nodi 
	private List<Arco>archi=new ArrayList<Arco>();
	private List<Nodo>nodi=new ArrayList<Nodo>();
	private List<Possesso> possessoNodi= new ArrayList<Possesso>();
	
	public List<Arco> getArchi() {
		return archi;
	}
	public void setArchi(List<Arco> archi) {
		this.archi = archi;
	}
	public List<Nodo> getNodi() {
		return nodi;
	}
	public void setNodi(List<Nodo> nodi) {
		this.nodi = nodi;
	}
	

	public List<Possesso> getPossessoNodi() {
		return possessoNodi;
	}
	public void setPossessoNodi(List<Possesso> possessoNodi) {
		this.possessoNodi = possessoNodi;
	}
	
	public void addNodo(Nodo n) {
		nodi.add(n);
	}
	
	public void addArchi(Arco a) {
		archi.add(a);
	}
	
	//andiamo a cambiare  il possesso del nodo 
	public void addPossesso(Possesso p) {
		for (Possesso possesso : possessoNodi) {
			if(p.getId()==possesso.getId()) {
				setPossesso(p);
				return;
			}
		}
			
		possessoNodi.add(p);
	}
	
	//Ad ogni passaggio il livello viene aggiornato con i nuovi possessi 
	private  void setPossesso(Possesso p) {
		for (Possesso possesso : possessoNodi) {
			if(p.getId()==possesso.getId()) {
				possesso.setId(p.getId());
				possesso.setIstante(p.getIstante());
				possesso.setSquadra(p.getSquadra());

				
			}
		}
	}
	
	public void setNodo(Nodo n) {
		for(Nodo no:nodi)
			if(no.getId()==n.getId()) {
				n.setX(no.getX());
				n.setY(no.getY());
				n.setLivello(no.getLivello());
				nodi.remove(no);
				nodi.add(n);
				return;
			}
		
				
			
				
	}

}
