package Model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;



//mandaNavi(Nodo,Nodo1,Navi)
@Id("mandaNavi")
public class MandaNavi {
	
	@Param(0)
	private int Nodo1;
	@Param(1)
	private int Nodo2;
	@Param(2)
	private int Navi;
	
	public MandaNavi() {
		
	}
	
	

	public MandaNavi(int nodo1, int nodo2, int navi) {
		super();
		Nodo1 = nodo1;
		Nodo2 = nodo2;
		Navi = navi;
	}



	public int getNodo1() {
		return Nodo1;
	}
	public void setNodo1(int nodo1) {
		Nodo1 = nodo1;
	}
	public int getNodo2() {
		return Nodo2;
	}
	public void setNodo2(int nodo2) {
		Nodo2 = nodo2;
	}
	public int getNavi() {
		return Navi;
	}
	public void setNavi(int navi) {
		Navi = navi;
	}
	
	
	@Override
	public String toString() {
		return "MandaNavi [Nodo1=" + Nodo1 + ", Nodo2=" + Nodo2 + ", NaviMandate=" + Navi + "]";
	}


	

}
