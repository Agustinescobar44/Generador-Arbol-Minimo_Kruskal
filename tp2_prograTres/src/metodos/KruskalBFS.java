package metodos;

import java.util.Set;


import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;

public class KruskalBFS {

	static GrafoConPesos arbolGenerado ;
	
	// este metodo usa el algoritmo de kruskal con BFS para devolver un arbol de un grafo dado
	public static GrafoConPesos kruskal(GrafoConPesos g) {
		
		if(g.vertices() == 0) {
			return g;
		}
		
		arbolGenerado = new GrafoConPesos(g.vertices());
		
		int i = 0;
		int verticesDelGrafo=g.vertices();
		
		Set<AristaConPeso> aristasGrafo = g.getAristas();
		
		while (i<verticesDelGrafo-1) {
			AristaConPeso arista = dameMinimaNoConexa(aristasGrafo , arbolGenerado); //arista a agregar en el arbol
			if(arista!=null)
				arbolGenerado.agregarAristaConPeso(arista.getA(), arista.getB(),arista.getPeso());//agrego la arista minima que no hace circuito al arbol
			else //si dameMinimaNoConexa devuelve null significa que el grafo no es conexo
				throw new IllegalArgumentException("El grafo tiene que ser conexo");
			i+=1; //manejo de indice
		}
		
		return arbolGenerado;
	}

	
	//recorro el grafo y elijo la arista minima que no hace circuito en el arbol
	public static AristaConPeso dameMinimaNoConexa(Set<AristaConPeso> aristasGrafo , GrafoConPesos arbol) {
		AristaConPeso temp = null;
		for (AristaConPeso arista : aristasGrafo) { //recorro el grafo
			if(arista.compareTo(temp)<0 && 
					!haceCircuito(arbol, arista.getA(), arista.getB())) 
				
				temp = arista;
			
		}
		aristasGrafo.remove(temp); //remuevo la arista del set de aristas del grafo
		return temp;
	}
	
	//chequeo de si una arista hace circuito en un grafo
	public static boolean haceCircuito(GrafoConPesos g , int origen ,int destino) {
		Set<Integer> alcanzables =  BFS.alcanzables(g, origen);
		return alcanzables.contains(destino);
	}
}
