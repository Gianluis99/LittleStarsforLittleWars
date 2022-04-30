package Model;

public class Livelli {


	//creiamo livello uno dove inseriamo i nodi gli archi e le rispettive coordinate 
	public static Livello livelloUno() {
		Livello livello=new Livello();
		//creiamo i nodi e settiamo la posizione
		Nodo nodo=new Nodo(0,19,1);
		nodo.setX(400);
		nodo.setY(300);
		Nodo nodo1=new Nodo(1,3,1);
		nodo1.setX(520);
		nodo1.setY(180);
		Nodo nodo2=new Nodo(2,4,1);
		nodo2.setX(520);
		nodo2.setY(420);
		Nodo nodo3=new Nodo(3,2,1);
		nodo3.setX(740);
		nodo3.setY(180);
		Nodo nodo4=new Nodo(4,1,1);
		nodo4.setX(740);
		nodo4.setY(420);
		Nodo nodo5=new Nodo(5,2,1);
		nodo5.setX(860);
		nodo5.setY(300);
		
		livello.addNodo(nodo);
		livello.addNodo(nodo1);
		livello.addNodo(nodo2);
		livello.addNodo(nodo3);
		livello.addNodo(nodo4);
		livello.addNodo(nodo5);
		
		//aggiungimao gli archi ai nodi
		Arco arco=new Arco(0,1);
		arco.setNodo1(nodo);
		arco.setNod2(nodo1);
		Arco arco1=new Arco(0,2);
		arco1.setNodo1(nodo);
		arco1.setNod2(nodo2);
		Arco arco2=new Arco(1,3);
		arco2.setNodo1(nodo1);
		arco2.setNod2(nodo3);
		Arco arco3=new Arco(2,4);
		arco3.setNodo1(nodo2);
		arco3.setNod2(nodo4);
		Arco arco4=new Arco(3,5);
		arco4.setNodo1(nodo3);
		arco4.setNod2(nodo5);
		Arco arco5=new Arco(4,5);
		arco5.setNodo1(nodo4);
		arco5.setNod2(nodo5);

		livello.addArchi(arco);
		livello.addArchi(arco1);
		livello.addArchi(arco2);
		livello.addArchi(arco3);
		livello.addArchi(arco4);
		livello.addArchi(arco5);

		Possesso possesso= new Possesso(0,1,-1);
		Possesso possesso5= new Possesso(5,2,-1);
		
		livello.addPossesso(possesso);
		livello.addPossesso(possesso5);

		
		return livello;

	}
}
