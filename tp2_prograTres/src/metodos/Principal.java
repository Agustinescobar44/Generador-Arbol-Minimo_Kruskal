package metodos;


import java.util.HashSet;
import java.util.Set;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import tests.Assert;

public class Principal {
	
	public static GrafoConPesos generarGrafoConexo(int n, int m) {
		GrafoAleatorio a=new GrafoAleatorio();
		GrafoConPesos grafoGenerado=a.grafoAleatorio(n,m);
		
//		while(!BFS.esConexo(grafoGenerado)) {
//			grafoGenerado=a.grafoAleatorio(n,m);
//		}
		return grafoGenerado;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal con BFS (grafos de 10 vertices, 9 aristas)
			
			GrafoConPesos a=generarGrafoConexo(10,9);
			long inicio = System.currentTimeMillis();
			
			for(int i=0; i<100 ; i++) {
				KruskalBFS.kruskal(a);
			}
			
<<<<<<< HEAD
			long fin = System.currentTimeMillis();
			long total=(fin-inicio)/100;
			System.out.println("tiempo promedio del metodo BFS (grafos de 10 vertices, 9 aristas)= " + total);
			
			
			//tomando tiempo de Kruskal con BFS (grafos de 100 vertices, 99 aristas)
			GrafoConPesos a1=generarGrafoConexo(100,99);
			long inicio1 = System.currentTimeMillis();
			
			for(int i=0; i<100 ; i++) {
				KruskalBFS.kruskal(a1);
			}
			
			long fin1 = System.currentTimeMillis();
			long total1=(fin1-inicio1)/100;
			System.out.println("tiempo promedio del metodo BFS (grafos de 100 vertices, 99 aristas)= " + total1);
=======
		//tomando tiempo de Kruskal con BFS (grafos de 100 vertices, 99 aristas)
		System.out.println("tiempo promedio del metodo BFS (grafos de 100 vertices, 99 aristas)= " + promedioKruskal("BFS",100,100,99));
>>>>>>> parent of 21605ce... "detalles en principal, grafo y grafo con pesos"
			
			
		//tomando tiempo de Kruskal con UnionFind (grafos de 10 vertices, 9 aristas)
			GrafoConPesos a2=generarGrafoConexo(10,9);
			long inicio2 = System.currentTimeMillis();
			
			for(int i=0; i<100 ; i++) {
				KruskalUnionFind.Kruskal(a2);
			}
			
			long fin2 = System.currentTimeMillis();
			long total2=(fin2-inicio2)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 10 vertices, 9 aristas)= " + total2);
			
			//tomando tiempo de Kruskal con UnionFind (grafos de 100 vertices, 99 aristas)
			GrafoConPesos a3=generarGrafoConexo(100,99);
			long inicio3 = System.currentTimeMillis();
			
			for(int i=0; i<100 ; i++) {
				KruskalUnionFind.Kruskal(a3);
			}
			
<<<<<<< HEAD
			long fin3 = System.currentTimeMillis();
			long total3=(fin3-inicio3)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 100 vertices, 99 aristas)= " + total3);
=======
		//tomando tiempo de Kruskal con UnionFind (grafos de 100 vertices, 99 aristas)
		System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 100 vertices, 99 aristas)= " + promedioKruskal("UnionFind",100,100,99));
>>>>>>> parent of 21605ce... "detalles en principal, grafo y grafo con pesos"
			 

	}
}

