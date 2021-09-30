package estructurasDeDatos;

import java.util.Collections;
import java.util.HashSet;


public class GrafoConPesos extends Grafo {

	private HashSet<AristaConPeso> aristas;
	public GrafoConPesos(int i) {
		super(i);
		aristas = new HashSet<AristaConPeso>();
	}
	
	public void agregarArista(int a , int b , double peso) {
		if(!aristas.contains(new AristaConPeso(a, b, peso))) {
			agregarArista(a, b);
			aristas.add(new AristaConPeso(a, b, peso));
		}
	}
	
	public double getPeso(int a , int b) {
		if(!aristas.contains(new AristaConPeso(a, b, 0))) {
			throw new RuntimeException("La arista no existe en el grafo");
		}

		for (AristaConPeso arista : aristas) {
				if(arista.getA() == a && arista.getB() == b) {
						return arista.getPeso();
				}
		}
		return 0;
	}
	
	
	public HashSet<AristaConPeso> getAristas(){
		return aristas;
	}

	public AristaConPeso getMaxima() {
		return Collections.max(aristas);
	}
	
}
