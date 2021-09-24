package tp2_prograTres;

import java.util.Set;

public class Kruskal {

	static GrafoConPesos arbolGenerado ;
	
	public static GrafoConPesos kruskal(GrafoConPesos g) {
		
		arbolGenerado = new GrafoConPesos(g.vertices());
		
		int i = 0;
		while (i<g.vertices()-1) {
			Arista arista = dameMinimaNoConexa(g , arbolGenerado); //arista a agregar en el arbol
			
			arbolGenerado.setArista(arista.getA(), arista.getB(),arista.getPeso());
			System.out.println(arbolGenerado.getAristas());
			i+=1; //manejo de indice
		}
		
		return arbolGenerado;
	}

	//agrega la arista a el arbol generado
	private void agregarArista(Arista arista) {
		arbolGenerado.setArista(arista.getA(), arista.getB(), arista.getPeso());;
	}
	
	
	public static Arista dameMinimaNoConexa(GrafoConPesos grafo , GrafoConPesos arbol) {
		Arista temp = grafo.dameAristaMaxima(); //inicio con la primer arista para comparar
		for (Arista arista : grafo.getAristas()) { //recorro el grafo
			if(arista.compareTo(temp)<0 && !haceCircuito(arbol, arista.getA(), arista.getB())) {
				temp = arista;
			}
		}
		return temp;
	}
	
	public static boolean haceCircuito(GrafoConPesos g , int origen ,int destino) {
		Set<Integer> alcanzables =  BFS.alcanzables(g, origen);
		return alcanzables.contains(destino);
	}
}
