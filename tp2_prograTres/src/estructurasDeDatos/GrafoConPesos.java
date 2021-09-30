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
			agregarAristaConPeso(a, b);
			aristas.add(new AristaConPeso(a, b, peso));
		}else {
			throw new RuntimeException("Esa arista ya existe en el grafo!");
		}
<<<<<<< HEAD
=======
		else {
			throw new RuntimeException("La arista ya existe");
		}
	}
	
	@Override
	public boolean existeArista (int i, int j){
		verificarArista(i, j, "consultar");
		
		return aristas.contains(new AristaConPeso(i, j, 0.1));
>>>>>>> parent of 21605ce... "detalles en principal, grafo y grafo con pesos"
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
