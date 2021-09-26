package estructurasDeDatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class GrafoConPesos extends Grafo {

	private HashSet<Arista> aristas;
	public GrafoConPesos(int i) {
		super(i);
		aristas = new HashSet<Arista>();
	}
	
	public void agregarArista(int a , int b , double peso) {
		if(!aristas.contains(new Arista(a, b, peso)))
			agregarArista(a, b);
			aristas.add(new Arista(a, b, peso));
	}
	
	public double getPeso(int a , int b) {
			for (Arista arista : aristas) {
				if(arista.getA() == a && arista.getB() == b) {
					return arista.getPeso();
				}
			}
		return 0;
	}
	
	
	public HashSet<Arista> getAristas(){
		return aristas;
	}

	public Arista getMaxima() {
		return Collections.max(aristas);
	}
	
}
