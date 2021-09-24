package tp2_prograTres;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BFS {

	private static ArrayList<Integer> lista;
	private static boolean[] marcados;
	
	public static boolean esConexo(Grafo grafo) {
		if(grafo == null) 
			throw new IllegalArgumentException("El grafo no puede ser nulo");
		if(grafo.vertices() == 0)
			return true;
		return alcanzables(grafo, 0).size() == grafo.vertices();
	}

	public static Set<Integer> alcanzables(Grafo grafo, int origen) {
		
		Set<Integer> ret = new HashSet<Integer>();
		inicializar(grafo,origen);
		
		while(lista.size()>0) {
			int i = lista.get(0);
			marcados[i] = true;
			ret.add(i);
			
			agregarVecinosPendientes(grafo,i);
			lista.remove(0);
			
		}
			
		return ret;
	}

	private static void agregarVecinosPendientes(Grafo grafo, int i) {
		for (Integer vertice : grafo.vecinos(i)) {
			if(!marcados[vertice] && !lista.contains(vertice))
				lista.add(vertice);
		}
		
	}

	private static void inicializar(Grafo grafo, int origen) {
		lista = new ArrayList<Integer>();
		lista.add(origen);
		marcados = new boolean[grafo.vertices()];
		
	}

}
