package estructurasDeDatos;

import java.util.HashMap;

public class UnionFindHashMap {
	HashMap<Integer,Integer> Raices;
	
	public UnionFindHashMap(int cantVertices){
		Raices=new HashMap<Integer, Integer>();
		for(int i=0; i<cantVertices; i++) {
			Raices.put(i, i);
		}
	}
	
	public int buscarRaiz(int i) {
		while(Raices.get(i)==i) {
			i=Raices.get(i);
		}
		return i;
	}
	
	public boolean mismaCompConexa(int i,int j) {
		return buscarRaiz(i)==buscarRaiz(j);
	}
	
	public void unir(int i, int j) {
		int raizDei=buscarRaiz(i);
		int raizDej=buscarRaiz(j);
		Raices.put(j, raizDei);
	}
}
