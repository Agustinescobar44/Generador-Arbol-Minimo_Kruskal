package tp2_prograTres;


public class Kruskal {

	GrafoConPesos g; 
	GrafoConPesos arbolGenerado ;
	int[] unionFind;
	
	public Kruskal(int vertices) {
		g = new GrafoConPesos(vertices);
		
		arbolGenerado = new GrafoConPesos(vertices);
		
		unionFind = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			unionFind[i] = i;
			
		}
	}

	public Arista dameMinimaNoMarcada() {
		Arista temp = g.getAristas().get(0);
		for (Arista arista : g.getAristas()) {
			
			if(arista.compareTo(temp)<0 && !arbolGenerado.existeArista(arista.getA(),arista.getB())) {
				temp = arista;
			}
		}
		
		return temp;
		
	}

	public void agregarArista(Arista arista) {
		arbolGenerado.setArista(arista.getA(), arista.getB(), arista.getPeso());;
	}
	
	
	
	
	
}
