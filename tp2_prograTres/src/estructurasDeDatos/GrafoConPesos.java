package estructurasDeDatos;

import java.util.HashMap;
import java.util.Set;


public class GrafoConPesos extends Grafo {

	private HashMap<AristaConPeso,Double> aristas;
	public GrafoConPesos(int i) {
		super(i);
		aristas = new HashMap<>();
	}
	
	public void agregarAristaConPeso(int a , int b , double peso) {
		AristaConPeso arista = new AristaConPeso(a, b, peso);
		if(!existeArista(a, b)) {
			agregarArista(a, b);
			aristas.put(arista, peso);
		}
		else {
			throw new RuntimeException("La arista ya existe");
		}
	}
	
	public double getPeso(int a , int b) {
		if(!existeArista(a, b)) {
			throw new RuntimeException("La arista no existe en el grafo");
		}
		AristaConPeso ar = new AristaConPeso(a, b, 0);
		
		return aristas.get(ar);
	}
	
	
	public Set<AristaConPeso> getAristas(){
		return aristas.keySet();
	}


	
}