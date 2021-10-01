package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.Grafo;
import metodos.BFS;



public class BFSTest {

private Grafo grafo = new Grafo(5);
	
	@Before
	public void setUp() throws Exception {
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(2, 3);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}
	
	@Test
	public void testAlcanzables(){
		Set<Integer> alcanzables = BFS.alcanzables(grafo,0);
		int[] esperados = {0,1,2,3};
		Assert.iguales(esperados,alcanzables);
	}
	@Test
	public void testConexo(){  
		grafo.agregarArista(3, 4);
		assertTrue(BFS.esConexo(grafo));
	}
	@Test
	public void testNoConexo(){
		grafo.eliminarArista(3, 4);
		assertFalse(BFS.esConexo(grafo));
	}
	@Test
	public void testNoGrafoConexo(){
		
		grafo.eliminarArista(3, 4);
		assertFalse(BFS.esConexo(grafo));
	}
	@Test
	public void testGrafoVacio(){
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}

}
