package estructurasDeDatos;

public class UnionFindPathCompression extends UnionFind {

	public UnionFindPathCompression(int cantVertices) {
		super(cantVertices);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int buscarRaiz(int i) {
		while(Raices[i]!=i) {
			Raices[i]=buscarRaiz(Raices[i]);
		}
		return i;
	}

}
