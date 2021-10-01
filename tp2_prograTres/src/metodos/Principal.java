package metodos;

import estructurasDeDatos.GrafoConPesos;

public class Principal {
	
	public static GrafoConPesos generarGrafoConexo(int n, int m) {
		GrafoAleatorio a=new GrafoAleatorio();
		GrafoConPesos grafoGenerado=a.grafoAleatorio(n,m);
		
		while(!BFS.esConexo(grafoGenerado)) {
			grafoGenerado=a.grafoAleatorio(n,m);
		}
		
		return grafoGenerado;
	}
	
	public static long promedioKruskal(String tipoKruskal, int veces, int vertices, int aristas) {
		GrafoConPesos a=generarGrafoConexo(vertices,aristas);
		long inicio = System.currentTimeMillis();
		
		if (tipoKruskal.equals("BFS")) {
			for(int i=0; i<veces ; i++) {
				KruskalBFS.kruskal(a);
			}
		}
		else if(tipoKruskal.equals("UnionFind")) {
			for(int i=0; i<veces ; i++) {
				KruskalUnionFind.Kruskal(a);
			}
		}
		else {
			throw new RuntimeException("El tipo de implementacion de kruskal no es correcto");
		}
		
		long fin = System.currentTimeMillis();
		long total=(fin-inicio)/veces;
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//tomando tiempo de Kruskal con BFS (grafos de 10 vertices, 9 aristas)
		System.out.println("tiempo promedio del metodo BFS (grafos de 10 vertices, 15 aristas)= " + promedioKruskal("BFS",100,10,15));;
			
			
		//tomando tiempo de Kruskal con BFS (grafos de 50 vertices, 69 aristas)
		System.out.println("tiempo promedio del metodo BFS (grafos de 50 vertices, 49 aristas)= " + promedioKruskal("BFS",100,50,69));
			
			
		//tomando tiempo de Kruskal con UnionFind (grafos de 10 vertices, 9 aristas)

		System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 10 vertices, 15 aristas)= " + promedioKruskal("UnionFind",100,10,15));
			
		//tomando tiempo de Kruskal con UnionFind (grafos de 50 vertices, 69 aristas)
		System.out.println("tiempo promedio del algoritmo Kruskal con UnionFind (grafos de 50 vertices, 69 aristas)= " + promedioKruskal("UnionFind",100,50,69));
			 
		KruskalUnionFind.Kruskal(generarGrafoConexo(10,15));
		System.out.println(KruskalUnionFind.Kruskal(generarGrafoConexo(10,15)).getAristas());
	}
}