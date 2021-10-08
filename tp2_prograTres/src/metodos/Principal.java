package metodos;

import java.util.HashSet;
import java.util.Set;

import estructurasDeDatos.GrafoConPesos;

public class Principal {

	public static void main(String[] args) {
		
		//==============Variables==============
		StringBuilder ret = new StringBuilder();
		int verticesG = 100; 
		int cantidadDeEjecuciones=100;
		
		int verticesMuchos = 50;
		int cantidadGrafos = 200;
		
		//==============Graficar==============
		ret.append("Mediciones multiples sobre una instancia\n---------------------\n");
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 110;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 120;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 130;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 140;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 150;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 160;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 170;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 180;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 190;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		verticesG = 200;
		medirEnG(verticesG,cantidadDeEjecuciones,ret);
		ret.append("===============================================\n");
		ret.append("Mediciones unicas sobre "+cantidadGrafos+" instancias\n---------------------\n");
		medirEnMuchos(cantidadGrafos,verticesMuchos,ret);
		
		System.out.println(ret);
	}
	
	
	public static GrafoConPesos generarGrafoConexo(int n, int m) {
		GrafoAleatorio a=new GrafoAleatorio();
		GrafoConPesos grafoGenerado=a.grafoAleatorio(n,m);
		
		while(!BFS.esConexo(grafoGenerado)) {
			grafoGenerado=a.grafoAleatorio(n,m);
		}
		
		return grafoGenerado;
	}
	
	
	
	
	
	

	private static void medirEnG(int vertices,int veces,StringBuilder ret) {
		//==============Generacion del Grafo==============
		int verticesG = vertices;
		int aristasG = verticesG+(verticesG/2);
		int cantidadDeEjecuciones=veces;
		GrafoConPesos g= generarGrafoConexo(verticesG, aristasG);
		
		//==============Medicion de tiempo==============
		long tiempoBFSEnG = promedioKruskalEnGrafo("bfs", cantidadDeEjecuciones, g);
		long tiempoUnionFindEnG = promedioKruskalEnGrafo("unionfind", cantidadDeEjecuciones, g);
		long tiempoUnionFindPCEnG = promedioKruskalEnGrafo("unionfindpc", cantidadDeEjecuciones, g);
		long tiempoPrimEnG = promedioKruskalEnGrafo("prim", cantidadDeEjecuciones, g);
		
		//==============Graficar==============
		ret.append("Cantidad de vertices en G= " + verticesG+" / ");
		ret.append("Cantidad de aristas en G= " + aristasG+" / ");
		ret.append("Cantidad de ejecuciones en G= " + cantidadDeEjecuciones+"\n");
		ret.append("Tiempo promedio de kruskal con BFS en G= ");
		ret.append(tiempoBFSEnG+"\n");
		ret.append("Tiempo promedio de kruskal con UnionFind en G= ");		  
		ret.append(tiempoUnionFindEnG+"\n");
		ret.append("Tiempo promedio de kruskal con UnionFind Path Compression en G= ");		  
		ret.append(tiempoUnionFindPCEnG+"\n");
		ret.append("Tiempo promedio Prim en G= ");		  
		ret.append(tiempoPrimEnG+"\n*****************\n");
	}
	
	public static long promedioKruskalEnGrafo(String tipoKruskal, int veces, GrafoConPesos a) {
		long inicio = System.currentTimeMillis();
		tipoKruskal.toLowerCase();
		if (tipoKruskal.equals("bfs")) {
			for(int i=0; i<veces ; i++) {
				KruskalBFS.kruskal(a);
			}
		}
		else if(tipoKruskal.equals("unionfind")) {
			for(int i=0; i<veces ; i++) {
				KruskalUnionFind.Kruskal(a);
			}
		}
		else if(tipoKruskal.equals("unionfindpc")) {
			for(int i=0; i<veces ; i++) {
				KruskalUnionFindPC.Kruskal(a); // el origen siempre sera 0
			}
		}
		else if(tipoKruskal.equals("prim")) {
			for(int i=0; i<veces ; i++) {
				Prim.prim(a,0); // el origen siempre sera 0
			}
		}
		else {
			throw new RuntimeException("El tipo de implementacion de kruskal no es correcto");
		}
		
		long fin = System.currentTimeMillis();
		long total=(fin-inicio)/veces;
		
		return total;
	}
	
	private static void medirEnMuchos(int cantidadGrafos, int vertices,StringBuilder ret) {
			int aristas=vertices+(vertices/2);
			//==============Generacion de Grafos==============
			Set<GrafoConPesos> grafos = new HashSet<GrafoConPesos>();
			for(int i=0; i<cantidadGrafos ; i++) {
				grafos.add(generarGrafoConexo(vertices, aristas));
			}
			//==============Medicion de Tiempos==============
			long tiemposBFSEnMuchos = promedioKruskalSetDeGrafos("bfs", grafos);
			long tiemposUnionFindEnMuchos = promedioKruskalSetDeGrafos("unionfind", grafos);
			long tiemposUnionFindPCEnMuchos = promedioKruskalSetDeGrafos("unionfindpc", grafos);
			long tiemposPrimEnMuchos = promedioKruskalSetDeGrafos("prim", grafos);
			
			//==============Graficar==============
			ret.append("Cada instancia tiene "+vertices+ " vertices y ");
			ret.append(aristas+ " aristas\n");
			ret.append("Medicion de Kruskal con BFS= ");
			ret.append(tiemposBFSEnMuchos+"\n");
			ret.append("Medicion de Kruskal con UnionFind= ");
			ret.append(tiemposUnionFindEnMuchos);
			ret.append("Medicion de Kruskal con UnionFind Path Compression= \n");
			ret.append(tiemposUnionFindPCEnMuchos);
			ret.append("Medicion de Prim= ");
			ret.append(tiemposPrimEnMuchos);
			
		}
	
	public static long promedioKruskalSetDeGrafos(String tipoKruskal,Set<GrafoConPesos> grafos) {
		long inicio = System.currentTimeMillis();
		tipoKruskal.toLowerCase();
		if (tipoKruskal.equals("bfs")) {
			for (GrafoConPesos grafoConPesos : grafos) {
				KruskalBFS.kruskal(grafoConPesos);
			}
		}
		else if(tipoKruskal.equals("unionfind")) {
			for (GrafoConPesos grafoConPesos : grafos) {
				KruskalUnionFind.Kruskal(grafoConPesos);
			}
		}
		else if(tipoKruskal.equals("unionfindpc")) {
			for (GrafoConPesos grafoConPesos : grafos) {
				KruskalUnionFindPC.Kruskal(grafoConPesos);
			}
		}
		else if(tipoKruskal.equals("prim")) {
			for (GrafoConPesos grafoConPesos : grafos) {
				Prim.prim(grafoConPesos,0);
			}
		}
		else {
			throw new RuntimeException("El tipo de implementacion de kruskal no es correcto");
		}
		
		long fin = System.currentTimeMillis();
		long total=(fin-inicio);
		
		return total;
	}
	
}