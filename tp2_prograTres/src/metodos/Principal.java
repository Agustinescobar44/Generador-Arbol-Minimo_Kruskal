package metodos;


import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal sin union find
//			long inicio = System.currentTimeMillis();
//			for(int i=0; i<10 ; i++) {
//				GrafoAleatorio a=new GrafoAleatorio();
//				Kruskal.kruskal(a.grafoAleatorio());
//			}
//			long fin = System.currentTimeMillis();
//			long total=(inicio-fin)/10;
//			System.out.println("tiempo promedio del metodo UnionFind = " + total);
		
		GrafoAleatorio a=new GrafoAleatorio();
		Kruskal.kruskal(a.grafoAleatorio());
	}
}

