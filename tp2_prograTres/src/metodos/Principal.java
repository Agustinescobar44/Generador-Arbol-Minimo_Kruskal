package metodos;


import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal con BFS
			long inicio = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio());
			}
			long fin = System.currentTimeMillis();
			long total=(fin-inicio)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con BFS= " + total);
			
		//tomando tiempo de Kruskal con UnionFind
			long inicio1 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio());
			}
			long fin1 = System.currentTimeMillis();
			long total1=(fin1-inicio1)/100;
			System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind = " + total1);

	}
}

