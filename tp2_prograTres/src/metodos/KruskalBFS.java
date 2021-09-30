package metodos;

import java.util.Set;


import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;

public class KruskalBFS {

	static GrafoConPesos arbolGenerado ;
	
	// este metodo usa el algoritmo de kruskal con BFS para devolver un arbol de un grafo dado
	public static GrafoConPesos kruskal(GrafoConPesos g) {
		

		if(!BFS.esConexo(g)) {
			return null;
		}
		
		else if(g.vertices() == 0) {
			return g;
		}
		

		else {
			arbolGenerado = new GrafoConPesos(g.vertices());
			
			int i = 0;
			int verticesDelGrafo=g.vertices();
			
			Set<AristaConPeso> aristasGrafo = (Set<AristaConPeso>) g.getAristas().clone();
			
			while (i<verticesDelGrafo-1) {
				AristaConPeso arista = dameMinimaNoConexa(aristasGrafo , arbolGenerado); //arista a agregar en el arbol
				if(arista!=null)
					//agrego la arista minima que no hace circuito al arbol
				arbolGenerado.agregarAristaConPeso(arista.getA(), arista.getB(), arista.getPeso());
				i+=1; //manejo de indice
			}
			
			return arbolGenerado;
		}
	}

	
	//recorro el grafo y elijo la arista minima que no hace circuito en el arbol
	public static AristaConPeso dameMinimaNoConexa(Set<AristaConPeso> aristasGrafo , GrafoConPesos arbol) {
		AristaConPeso temp = null; //inicio con la primer arista para comparar
		
		for (AristaConPeso arista : aristasGrafo) { //recorro el grafo
			if(temp == null) {
				temp = arista;
			}
			//si la arista es menor a la primera de las aristas del grafo y no hace circuito con otra arista del arbol, la elijo
			else if(arista.compareTo(temp)<0 && 
					!haceCircuito(arbol, arista.getA(), arista.getB())) {
				
				temp = arista;
			}
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
