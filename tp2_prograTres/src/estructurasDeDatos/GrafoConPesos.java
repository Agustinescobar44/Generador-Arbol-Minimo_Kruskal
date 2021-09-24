package estructurasDeDatos;

import java.util.ArrayList;


public class GrafoConPesos extends Grafo {

	private ArrayList<Arista> aristas;
	
	public GrafoConPesos(int i) {
		super(i);
		aristas = new ArrayList<Arista>();
	}
	
	public void setArista(int a , int b , int peso) {
		if(!existeArista(a, b)) {
			agregarArista(a, b);
			aristas.add(new Arista(a, b, peso));
		} else { 
			for (Arista arista : aristas) {
				if((arista.getA() == b && arista.getB() == a)||(arista.getA() == a && arista.getB() == b))
					arista.setPeso(peso);
			}
		}
	}
	
	public int getPeso(int a , int b) {
		if(!existeArista(a, b)) {
			throw new IllegalArgumentException("no existe esa arista");
		}else {
			for (Arista arista : aristas) {
				if(arista.getA() == a && arista.getB() == b) {
					return arista.getPeso();
				}
			}
		}
		return 0;
	}
	
	public ArrayList<Arista> getAristas(){
		return aristas;
	}

	public Arista dameAristaMaxima() {
		Arista maxima = aristas.get(0);
		for (Arista arista : getAristas()) {
			if (arista.compareTo(maxima)>0) {
				maxima = arista;
			}
		}
		return maxima;
	}
}
