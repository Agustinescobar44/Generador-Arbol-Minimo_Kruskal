package metodos;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import estructurasDeDatos.UnionFind;

public class KruskalUnionFind  {

	
	public static GrafoConPesos Kruskal(GrafoConPesos g) {
		int verticesDelGrafo=g.vertices();
		 
		GrafoConPesos AGM = new GrafoConPesos(verticesDelGrafo);
		UnionFind unionFind=new UnionFind(verticesDelGrafo);
		

		int i = 0;
		
		
		while (i<verticesDelGrafo-1) {
			AristaConPeso arista = dameMinimaNoConexa(g,unionFind,AGM); //arista a agregar en el arbol
			if(arista!= null) {
				AGM.agregarAristaConPeso(arista.getA(), arista.getB(),arista.getPeso());//agrego la arista minima que no hace circuito al arbol
				unionFind.unir(arista.getA(), arista.getB());
			}else
				throw new RuntimeException("El grafo no es conexo");
			i+=1; //manejo de indice
		}
		
		return AGM;
			
		}

	public static AristaConPeso dameMinimaNoConexa(GrafoConPesos g,UnionFind unionFind,GrafoConPesos AGM) {
		AristaConPeso temp = null;
		for (AristaConPeso arista : g.getAristas()) {
			
			if(arista.compareTo(temp)<0) {
				if (!AGM.existeArista(arista.getA(),arista.getB()) 
					&& !unionFind.mismaCompConexa(arista.getA(), arista.getB())) {
					temp = arista;
				}
			}
		}
		
		return temp;
		
	}

	public void agregarArista(AristaConPeso arista, GrafoConPesos AGM) {
		AGM.agregarAristaConPeso(arista.getA(), arista.getB(), arista.getPeso());
		
	}
	

}
