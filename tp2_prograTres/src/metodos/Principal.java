package metodos;


import java.util.HashSet;
import java.util.Set;

import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;
import tests.Assert;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal con BFS
			long inicio = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(10,9));
			}
			long fin = System.currentTimeMillis();

			long total=(fin-inicio)/100;
			System.out.println("tiempo promedio del metodo BFS = " + total);

			
		//tomando tiempo de Kruskal con UnionFind
			long inicio1 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio(10,9));
			}
			long fin1 = System.currentTimeMillis();

			long total1=(fin1-inicio1)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind = " + total1);
			

	}
}

