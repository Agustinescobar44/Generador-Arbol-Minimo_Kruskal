package metodos;

import java.util.Random;

import estructurasDeDatos.GrafoConPesos;
public class GrafoAleatorio {
	
	public GrafoConPesos grafoAleatorio(){
		Random random= new Random();
//		int numVertices= random.nextInt(30);
		int numVertices= 10;
		
//		int numAristas= random.nextInt(30);
		int numAristas=10;
		
		GrafoConPesos grafo= new GrafoConPesos(numVertices);
		
		for(int i=0; i<numAristas; i++){
			int verticeA=random.nextInt(numVertices);
			int verticeB=verticeA;
			
			while(verticeA==verticeB){
				verticeB=random.nextInt(numVertices);
			}
			
			grafo.agregarArista(verticeA, verticeB, random.nextDouble());
		
		}
		
		return grafo;
		}

}
