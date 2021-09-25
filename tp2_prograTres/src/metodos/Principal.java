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
			long total=(fin-inicio);
			System.out.println("tiempo promedio del metodo BFS = " + total);
			
		//tomando tiempo de Kruskal sin BFS
			long inicio1 = System.currentTimeMillis();
			for(int i=0; i<100 ; i++) {
				GrafoAleatorio a=new GrafoAleatorio();
				KruskalBFS.kruskal(a.grafoAleatorio());
			}
			long fin1 = System.currentTimeMillis();
			long total1=(fin1-inicio1);
			System.out.println("tiempo promedio del metodo UnionFind = " + total1);

	}
}

