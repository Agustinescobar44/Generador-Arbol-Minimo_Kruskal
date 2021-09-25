package estructurasDeDatos;

public class UnionFind {
	private int[] Raices;
	
	public UnionFind(int cantVertices){
		Raices=new int[cantVertices];
		for(int i=0; i<cantVertices; i++) {
			Raices[i]=i;
		}
	}
	
	public int buscarRaiz(int i) {
		while(Raices[i]!=i) {
			i=Raices[i];
		}
		return i;
	}
	
	public boolean mismaCompConexa(int i,int j) {
		return Raices[i]==Raices[j];
	}
	
	public void unir(int i, int j) {
		int raizDei=buscarRaiz(i);
		int raizDej=buscarRaiz(j);
		Raices[i]=raizDej;
	}
	
	public boolean esConexo() {
		boolean ret=true;
		for(int indice:this.Raices) {
			ret= ret && this.buscarRaiz(indice)==this.buscarRaiz(Raices[0]);
		}
		return ret;
	}

}
