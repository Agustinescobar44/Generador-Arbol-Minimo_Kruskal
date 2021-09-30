package estructurasDeDatos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
  Representacin con Lista de vecinos
*/
public class Grafo 
{
	protected ArrayList<Set<Integer>> _vecinos;
	protected int _vertice; 
	
	public Grafo( int vertices)
	{
		_vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++)
			_vecinos.add(new HashSet<Integer>());	

		_vertice = vertices;
	}
	
	public void agregarArista( int i, int j)
	{
		verificarArista(i, j, "agregar");
		
		_vecinos.get(i).add(j);
		_vecinos.get(j).add(i);
	}
	
	public void eliminarArista(int i, int j)
	{
		verificarArista(i, j, "eliminar");
		
		_vecinos.get(i).remove(j);
		_vecinos.get(j).remove(i);

	}
	
	public boolean existeArista (int i, int j)
	{
		verificarArista(i, j, "consultar");
		
		return _vecinos.get(i).contains(j);
	}

	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i, " un vertice ");
		
		return _vecinos.get(i);
	}

	public int grado (int i)
	{ 
		return _vecinos.get(i).size();
	}
		
	protected void verificarArista(int i, int j, String tipo) 
	{
		if (i == j)
			throw new IllegalArgumentException("Se intento "+tipo+" una arista con i=j : "+i +"/"  + j);
		
		verificarVertice(i, tipo);

		verificarVertice(j, tipo);

	}

	private void verificarVertice(int i, String tipo) 
	{
		if (i < 0 || i >= _vertice)
			throw new IllegalArgumentException("Se intento usar "+tipo+" con valores, fuera de rango: "+ i);
	}

	public int vertices()
	{
		return _vertice;
	}
	
	
	public boolean esClique( Set<Integer> conjunto) 
	{
		if (conjunto == null)
			throw new IllegalArgumentException("El conjunto no puede ser null");

		for (int v: conjunto)
		   verificarVertice(v," Clique");
		
		if (conjunto.isEmpty())
			return true;
		
		for (int v: conjunto)
		for (int otro: conjunto) 
			if (v != otro)
				if (existeArista(v,otro) == false)
					return false;
		
		return true;
	}

}
