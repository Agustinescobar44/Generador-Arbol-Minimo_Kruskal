package metodos;

import java.util.Random;

import estructurasDeDatos.GrafoConPesos;
public class GrafoAleatorio {
	
	public GrafoConPesos grafoAleatorio(int n, int m){
		Random random= new Random();
		int numVertices= n;
		int numAristas=m;
		 
		GrafoConPesos grafo= new GrafoConPesos(numVertices);
		
		for(int i=0; i<numAristas; i++){
			int verticeA=random.nextInt(numVertices);
			int verticeB=verticeA;
			
			while(verticeA==verticeB || grafo.existeArista(verticeA, verticeB)) {
				verticeB=random.nextInt(numVertices);
			}
			
			grafo.agregarAristaConPeso(verticeA, verticeB, random.nextDouble());
		
		}
		
		return grafo;
		}

}
