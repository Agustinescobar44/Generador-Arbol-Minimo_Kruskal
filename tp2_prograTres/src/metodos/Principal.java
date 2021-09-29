package metodos;


import java.util.HashSet;
import java.util.Set;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import tests.Assert;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal con BFS (grafos de 10 vertices, 9 aristas)
			long inicio = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(10,9));
			}
			long fin = System.currentTimeMillis();

			long total=(fin-inicio)/100;
			System.out.println("tiempo promedio del metodo BFS (grafos de 10 vertices, 9 aristas)= " + total);
			
			
			//tomando tiempo de Kruskal con BFS (grafos de 50 vertices, 49 aristas)
			long inicio1 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(100,99));
			}
			long fin1 = System.currentTimeMillis();

			long total1=(fin-inicio)/100;
			System.out.println("tiempo promedio del metodo BFS (grafos de 100 vertices, 99 aristas)= " + total1);
			
			
		//tomando tiempo de Kruskal con UnionFind (grafos de 10 vertices, 9 aristas)
			long inicio2 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(10,9));
			}
			long fin2 = System.currentTimeMillis();

			long total2=(fin1-inicio1)/200;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 10 vertices, 9 aristas)= " + total2);
			
			//tomando tiempo de Kruskal con UnionFind (grafos de 50 vertices, 49 aristas)
			long inicio3 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(100,99));
			}
			long fin3 = System.currentTimeMillis();

			long total3=(fin1-inicio1)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 100 vertices, 99 aristas)= " + total3);
			 

	}
}

