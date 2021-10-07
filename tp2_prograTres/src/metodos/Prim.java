package metodos;

import java.util.HashSet;
import java.util.Set;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;

public class Prim {
	
	static GrafoConPesos arbolGenerado;
	
	public static GrafoConPesos prim(GrafoConPesos g, int origen) {
		// Casos base
		if(g==null)
			throw new IllegalArgumentException("El grafo no puede ser null");
		if(origen>g.vertices()) {
			throw new IllegalArgumentException("El origen no pertecene al grafo");
		}
		if(g.getAristas().size()<1) {
			return g;
		}
		
		//variables
		Set<Integer> verticesContados = new HashSet<Integer>();
		verticesContados.add(origen);
		GrafoConPesos Arbol = new GrafoConPesos(g.vertices());
		
		int i = 0;
		while(i<g.vertices()-1) {
			AristaConPeso arista = dameAristaMinima(g,verticesContados);
			
			if(arista!=null)
				Arbol.agregarAristaConPeso(arista.getA(), arista.getB(), arista.getPeso());
			else {
				throw new RuntimeException("El grafo no es conexo");
			}
			i++;
		}
		return Arbol;
	}

	public static AristaConPeso dameAristaMinima(GrafoConPesos g, Set<Integer> verticesContados) {
		AristaConPeso ret=null;
		
		for (AristaConPeso arista : g.getAristas()) {
			if(arista.compareTo(ret)<0 && noExisteArista(arista,verticesContados)) {
				ret = arista;
			}
		}
		if(ret != null) {
			if(verticesContados.contains(ret.getA()))
				verticesContados.add(ret.getB());
			else
				verticesContados.add(ret.getA());
		}
		return ret;
	}
	
	public static boolean noExisteArista(AristaConPeso arista, Set<Integer> verticesContados) {
		int a = arista.getA();
		int b = arista.getB();
		return (verticesContados.contains(a) && !verticesContados.contains(b))||
				(verticesContados.contains(b) && !verticesContados.contains(a));
	}
	
}
