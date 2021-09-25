package metodos;

import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;
import estructurasDeDatos.UnionFind;

public class KruskalUnionFind  {


	GrafoConPesos AGM;
	UnionFind raices;
	
	public GrafoConPesos Kruskal(GrafoConPesos g) {
		
		if(BFS.esConexo(g)) {
			throw new RuntimeException("El grafo tiene que ser conexo");
		}

		
		AGM = new GrafoConPesos(g.vertices());
		raices=new UnionFind(AGM);
		
		int i = 0;
		int verticesDelGrafo=g.vertices();
		
		while (i<verticesDelGrafo-1) {
			Arista arista = dameMinimaNoConexa(g); //arista a agregar en el arbol
			
			AGM.agregarArista(arista.getA(), arista.getB(),arista.getPeso());//agrego la arista minima que no hace circuito al arbol
			
			i+=1; //manejo de indice
		}
		return AGM;
			
		}

	public Arista dameMinimaNoConexa(GrafoConPesos g) {
		Arista temp = g.getMaxima();
		for (Arista arista : g.getAristas()) {
			
			if(arista.compareTo(temp)<0) {
				if (!AGM.existeArista(arista.getA(),arista.getB()) 
					&& !raices.mismaCompConexa(arista.getA(), arista.getB())) {
					temp = arista;
				}
			}
		}
		
		return temp;
		
	}

	public void agregarArista(Arista arista) {
		AGM.agregarArista(arista.getA(), arista.getB(), arista.getPeso());
		raices.unir(arista.getA(), arista.getB());
	}
	

}
