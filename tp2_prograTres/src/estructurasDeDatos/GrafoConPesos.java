package estructurasDeDatos;

import java.util.HashSet;

public class GrafoConPesos extends Grafo {

	private HashSet<AristaConPeso> aristas;
	
	public GrafoConPesos(int i) {
		super(i);
		aristas = new HashSet<AristaConPeso>();
	}
	
	public void agregarAristaConPeso(int a , int b , double peso) {
		AristaConPeso arista = new AristaConPeso(a, b, peso);
		if(!existeArista(a, b)) {
			agregarArista(a, b);
			aristas.add(arista);
		}
		else {
			throw new RuntimeException("La arista ya existe");
		}
	}
	
	public double getPeso(int a , int b) {
		if(!existeArista(a, b)) {
			throw new RuntimeException("La arista no existe en el grafo");
		}

		for (AristaConPeso arista : aristas) {
				if((arista.getA() == a && arista.getB() == b)||
						(arista.getA() == b && arista.getB() == a)) {
						return arista.getPeso();
				}
		}
		return 0;
	}
	
	public HashSet<AristaConPeso> getAristas(){
		return (HashSet<AristaConPeso>) aristas.clone();
	}
	
}