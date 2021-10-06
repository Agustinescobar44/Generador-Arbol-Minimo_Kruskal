package metodos;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import estructurasDeDatos.UnionFind;
import estructurasDeDatos.UnionFindPC;

public class KruskalUnionFindPC extends KruskalUnionFind {
	
	public static GrafoConPesos Kruskal(GrafoConPesos g) {
		int verticesDelGrafo=g.vertices();
		 
		GrafoConPesos AGM = new GrafoConPesos(verticesDelGrafo);
		UnionFindPC unionFind=new UnionFindPC(verticesDelGrafo);
		

		int i = 0;
		
		
		while (i<verticesDelGrafo-1) {
			AristaConPeso arista = dameMinimaNoConexa(g,unionFind,AGM); //arista a agregar en el arbol
			
			AGM.agregarAristaConPeso(arista.getA(), arista.getB(),arista.getPeso());//agrego la arista minima que no hace circuito al arbol
			unionFind.unir(arista.getA(), arista.getB());
			
			i+=1; //manejo de indice
		}
		
		if(!unionFind.esConexo()) {
//			throw new RuntimeException("El grafo tiene que ser conexo");
			System.out.println("El grafo no es conexo!");
		}
		return AGM;
			
		}

}
