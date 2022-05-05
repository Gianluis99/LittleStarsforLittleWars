package Model;

public class Livelli {


	//creiamo livello uno dove inseriamo i nodi gli archi e le rispettive coordinate 
	public static Livello livelloUno() {
		Livello livello=new Livello();
		//creiamo i nodi e settiamo la posizione
		Nodo nodo=new Nodo(0,6,1);
		nodo.setX(400);
		nodo.setY(300);
		Nodo nodo1=new Nodo(1,2,2);
		nodo1.setX(520);
		nodo1.setY(180);
		Nodo nodo2=new Nodo(2,3,2);
		nodo2.setX(520);
		nodo2.setY(420);
		Nodo nodo3=new Nodo(3,2,1);
		nodo3.setX(740);
		nodo3.setY(180);
		Nodo nodo4=new Nodo(4,1,1);
		nodo4.setX(740);
		nodo4.setY(420);
		Nodo nodo5=new Nodo(5,3,1);
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
		Possesso possesso1= new Possesso(1,1,-1);
		Possesso possesso2= new Possesso(2,1,-1);

		Possesso possesso5= new Possesso(5,2,-1);
		
		livello.addPossesso(possesso);
		livello.addPossesso(possesso5);
		livello.addPossesso(possesso1);
		livello.addPossesso(possesso2);


		
		return livello;

	}
	
	
	public static Livello livelloDue() {
		Livello livello=new Livello();
		//creiamo i nodi e settiamo la posizione
		Nodo nodo=new Nodo(0,6,1);
		nodo.setX(400);
		nodo.setY(300);
		Nodo nodo1=new Nodo(1,2,2);
		nodo1.setX(520);
		nodo1.setY(180);
		Nodo nodo2=new Nodo(2,3,2);
		nodo2.setX(520);
		nodo2.setY(420);
		Nodo nodo3=new Nodo(3,2,1);
		nodo3.setX(740);
		nodo3.setY(180);
		Nodo nodo4=new Nodo(4,1,1);
		nodo4.setX(740);
		nodo4.setY(420);
		Nodo nodo5=new Nodo(5,4,1);
		nodo5.setX(860);
		nodo5.setY(300);
		Nodo nodo6=new Nodo(6,3,1);
		nodo6.setX(520);
		nodo6.setY(300);
		Nodo nodo7=new Nodo(7,3,1);
		nodo7.setX(740);
		nodo7.setY(300);
		
		livello.addNodo(nodo);
		livello.addNodo(nodo1);
		livello.addNodo(nodo2);
		livello.addNodo(nodo3);
		livello.addNodo(nodo4);
		livello.addNodo(nodo5);
		livello.addNodo(nodo6);
		livello.addNodo(nodo7);
		
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
		Arco arco6=new Arco(6,1);
		arco6.setNodo1(nodo6);
		arco6.setNod2(nodo1);
		Arco arco7=new Arco(6,2);
		arco7.setNodo1(nodo6);
		arco7.setNod2(nodo2);
		Arco arco8=new Arco(7,3);
		arco8.setNodo1(nodo7);
		arco8.setNod2(nodo3);
		Arco arco9=new Arco(7,24);
		arco9.setNodo1(nodo7);
		arco9.setNod2(nodo4);
		

		livello.addArchi(arco);
		livello.addArchi(arco1);
		livello.addArchi(arco2);
		livello.addArchi(arco3);
		livello.addArchi(arco4);
		livello.addArchi(arco5);
		livello.addArchi(arco6);
		livello.addArchi(arco7);
		livello.addArchi(arco8);
		livello.addArchi(arco9);


		Possesso possesso= new Possesso(0,1,-1);
		Possesso possesso1= new Possesso(6,1,-1);
		Possesso possesso2= new Possesso(7,2,-1);

		Possesso possesso5= new Possesso(5,2,-1);
		
		livello.addPossesso(possesso);
		livello.addPossesso(possesso5);
		livello.addPossesso(possesso1);
		livello.addPossesso(possesso2);


		
		return livello;

	}
	
	
	public static Livello livelloTre() {
		Livello livello=new Livello();
		//creiamo i nodi e settiamo la posizione
		Nodo nodo=new Nodo(0,15,1);
		nodo.setX(200);
		nodo.setY(300);
		Nodo nodo1=new Nodo(1,2,2);
		nodo1.setX(320);
		nodo1.setY(180);
		Nodo nodo2=new Nodo(2,3,2);
		nodo2.setX(320);
		nodo2.setY(420);
		Nodo nodo3=new Nodo(3,2,1);
		nodo3.setX(540);
		nodo3.setY(180);
		Nodo nodo4=new Nodo(4,1,1);
		nodo4.setX(540);
		nodo4.setY(420);
		Nodo nodo5=new Nodo(5,3,1);
		nodo5.setX(760);
		nodo5.setY(180);
		Nodo nodo6=new Nodo(6,4,1);
		nodo6.setX(760);
		nodo6.setY(420);
		Nodo nodo9=new Nodo(9,17,1);
		nodo9.setX(880);
		nodo9.setY(300);
		Nodo nodo10=new Nodo(10,2,1);
		nodo10.setX(540);
		nodo10.setY(300);
		
		livello.addNodo(nodo);
		livello.addNodo(nodo1);
		livello.addNodo(nodo2);
		livello.addNodo(nodo3);
		livello.addNodo(nodo4);
		livello.addNodo(nodo5);
		livello.addNodo(nodo6);
		livello.addNodo(nodo9);
		livello.addNodo(nodo10);
		
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
		Arco arco5=new Arco(4,6);
		arco5.setNodo1(nodo4);
		arco5.setNod2(nodo6);
		Arco arco10=new Arco(9,5);
		arco10.setNodo1(nodo9);
		arco10.setNod2(nodo5);
		Arco arco11=new Arco(9,6);
		arco11.setNodo1(nodo9);
		arco11.setNod2(nodo6);
		Arco arco12=new Arco(10,3);
		arco12.setNodo1(nodo10);
		arco12.setNod2(nodo3);
		Arco arco13=new Arco(10,4);
		arco13.setNodo1(nodo10);
		arco13.setNod2(nodo4);
	


		livello.addArchi(arco);
		livello.addArchi(arco1);
		livello.addArchi(arco2);
		livello.addArchi(arco3);
		livello.addArchi(arco4);
		livello.addArchi(arco5);
		livello.addArchi(arco10);
		livello.addArchi(arco11);
		livello.addArchi(arco12);
		livello.addArchi(arco13);



		Possesso possesso= new Possesso(0,1,-1);
		Possesso possesso9= new Possesso(9,2,-1);
		
		livello.addPossesso(possesso);
		livello.addPossesso(possesso9);

		
		return livello;

	}
	
	public static Livello livelloQuattro() {
		Livello livello=new Livello();
		//creiamo i nodi e settiamo la posizione
		Nodo nodo=new Nodo(0,15,1);
		nodo.setX(200);
		nodo.setY(300);
		Nodo nodo1=new Nodo(1,2,2);
		nodo1.setX(320);
		nodo1.setY(180);
		Nodo nodo2=new Nodo(2,3,2);
		nodo2.setX(320);
		nodo2.setY(420);
		Nodo nodo3=new Nodo(3,2,1);
		nodo3.setX(540);
		nodo3.setY(180);
		Nodo nodo4=new Nodo(4,1,1);
		nodo4.setX(540);
		nodo4.setY(420);
		Nodo nodo5=new Nodo(5,3,1);
		nodo5.setX(760);
		nodo5.setY(180);
		Nodo nodo6=new Nodo(6,4,1);
		nodo6.setX(760);
		nodo6.setY(420);
		Nodo nodo7=new Nodo(7,2,1);
		nodo7.setX(540);
		nodo7.setY(50);
		Nodo nodo8=new Nodo(8,2,1);
		nodo8.setX(540);
		nodo8.setY(550);
		Nodo nodo9=new Nodo(9,17,1);
		nodo9.setX(880);
		nodo9.setY(300);
		Nodo nodo10=new Nodo(10,2,1);
		nodo10.setX(540);
		nodo10.setY(300);
		
		livello.addNodo(nodo);
		livello.addNodo(nodo1);
		livello.addNodo(nodo2);
		livello.addNodo(nodo3);
		livello.addNodo(nodo4);
		livello.addNodo(nodo5);
		livello.addNodo(nodo6);
		livello.addNodo(nodo7);
		livello.addNodo(nodo8);
		livello.addNodo(nodo9);
		livello.addNodo(nodo10);
		
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
		Arco arco5=new Arco(4,6);
		arco5.setNodo1(nodo4);
		arco5.setNod2(nodo6);
		Arco arco6=new Arco(1,7);
		arco6.setNodo1(nodo1);
		arco6.setNod2(nodo7);
		Arco arco7=new Arco(5,7);
		arco7.setNodo1(nodo5);
		arco7.setNod2(nodo7);
		Arco arco8=new Arco(2,8);
		arco8.setNodo1(nodo2);
		arco8.setNod2(nodo8);
		Arco arco9=new Arco(8,6);
		arco9.setNodo1(nodo6);
		arco9.setNod2(nodo8);
		Arco arco10=new Arco(9,5);
		arco10.setNodo1(nodo9);
		arco10.setNod2(nodo5);
		Arco arco11=new Arco(9,6);
		arco11.setNodo1(nodo9);
		arco11.setNod2(nodo6);
		Arco arco12=new Arco(10,3);
		arco12.setNodo1(nodo10);
		arco12.setNod2(nodo3);
		Arco arco13=new Arco(10,4);
		arco13.setNodo1(nodo10);
		arco13.setNod2(nodo4);
	


		livello.addArchi(arco);
		livello.addArchi(arco1);
		livello.addArchi(arco2);
		livello.addArchi(arco3);
		livello.addArchi(arco4);
		livello.addArchi(arco5);
		livello.addArchi(arco6);
		livello.addArchi(arco7);
		livello.addArchi(arco8);
		livello.addArchi(arco9);
		livello.addArchi(arco10);
		livello.addArchi(arco11);
		livello.addArchi(arco12);
		livello.addArchi(arco13);



		Possesso possesso= new Possesso(0,1,-1);
		Possesso possesso9= new Possesso(9,2,-1);
		
		livello.addPossesso(possesso);
		livello.addPossesso(possesso9);

		
		return livello;

	}
	
	
}
