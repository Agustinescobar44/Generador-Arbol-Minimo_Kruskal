package estructurasDeDatos;

//implementacion Union-Find con Path Compression
public class UnionFindPC extends UnionFind {

	public UnionFindPC(int cantVertices) {
		super(cantVertices);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int buscarRaiz(int i) {
		if (Raices[i]!=i) {
			Raices[i]=buscarRaiz(Raices[i]);
		}
		return Raices[i];
	}

}
