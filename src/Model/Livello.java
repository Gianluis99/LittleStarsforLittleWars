package Model;

import java.util.ArrayList;
import java.util.List;

public class Livello {

	//Un livello  è composto da archi nodi e i possessi iniziali
	private List<Arco>archi;
	private List<Nodo>nodi;
	private List<Possesso> possessoNodi;
	
	
	public Livello() {
		archi=new ArrayList<Arco>();
		nodi=new ArrayList<Nodo>();
		possessoNodi= new ArrayList<Possesso>();
		
	}
	
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
	
	
	public Nodo getNodo(int id) {
		for(Nodo n:nodi)
			if(n.getId()==id)
				return n;
		
		return null;
	}
	
	
	public Possesso getPossesso(int id) {
		for (Possesso possesso : possessoNodi) 
			if(possesso.getId()==id)
				return possesso;
		
		return null;
		
	}
	
	//andiamo a cambiare  il possesso del nodo 
	public void addPossesso(Possesso p) {
		for (Possesso possesso : possessoNodi) {
			
			//se il possesso è gia presente invece di aggiungerlo lo modifica
			if(p.getId()==possesso.getId()) {
				possesso.setId(p.getId());
				possesso.setIdPossesso(p.getIdPossesso());
				possesso.setSquadra(p.getSquadra());
				return;
			}
		}
		
		possessoNodi.add(p);
	}
	
	//Ad ogni passaggio il livello viene aggiornato con i nuovi possessi 
	public  void setPossesso(Possesso p) {
		for (Possesso possesso : possessoNodi) {
			if(p.getId()==possesso.getId()) {
				possesso.setId(p.getId());
				possesso.setIdPossesso(p.getIdPossesso());
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

	public boolean isFinito() {
		
//		se vogliamo che una squadra si impossessi di tutti i nodi
		
//		if(possessoNodi.size()!=nodi.size())
//			return false;
//		
		int squadra=possessoNodi.get(0).getSquadra();
		for(Possesso p:possessoNodi) {
			if(p.getSquadra()!=squadra)
				return false;
		}
		
		return true;
	}

	public void setNodoPrincipale(Possesso p,int idPossesso) {
		p.setIdPossesso(idPossesso);
		addPossesso(p);
	}
	
	public boolean haSquadra(Nodo n) {
		for(Possesso p:possessoNodi) {
			if(p.getId()==n.getId())
				return true;
		}
		return false;
	}
	

}
