package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;
import metodos.GrafoAleatorio;
import metodos.KruskalBFS;

public class KruskalBFSTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKruskalEsperado() {

		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(1, 2, 200);
		g.agregarArista(2, 4, 300);
		g.agregarArista(4, 3, 75);
		g.agregarArista(3, 1,500);
		g.agregarArista(4, 0,100);
		
		Set<Arista> esperados = new HashSet<Arista>();
		esperados.add(new Arista(0, 1, 150));
		esperados.add(new Arista(1, 2, 200));
		esperados.add(new Arista(4, 0, 100));
		esperados.add(new Arista(4, 3, 75));
		
		Assert.iguales(esperados , KruskalBFS.kruskal(g));
	}
	
	@Test 
	public void testKruskalGrafoSinAristas() {
		
		g = new GrafoConPesos(5);
		Set<Arista> esperados = new HashSet<Arista>();
		
		Assert.iguales(esperados, g);
	}
	
	@Test
	public void testDameMinimaNoConexa() {
		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(1, 2, 200);
		g.agregarArista(2, 4, 300);
		g.agregarArista(4, 3, 75);
		g.agregarArista(3, 1,500);
		g.agregarArista(4, 0,100);
		
		GrafoConPesos arbol = new GrafoConPesos(5);
		
		arbol.agregarArista(4, 3, 75);
		arbol.agregarArista(4, 0, 100);
		
		assertEquals(new Arista(0, 1, 150), KruskalBFS.dameMinimaNoConexa(g,arbol));
		
	}

	@Test 
	public void testHaceCircuitoFalso(){
		g = new GrafoConPesos(3);
		g.agregarArista(0, 1, 120);
		
		assertFalse(KruskalBFS.haceCircuito(g, 0, 2));
	}
	@Test 
	public void testHaceCircuitoVerdadero(){
		g = new GrafoConPesos(3);
		g.agregarArista(0, 1, 120);
		g.agregarArista(2, 1, 100);
		
		assertTrue(KruskalBFS.haceCircuito(g, 0, 2));
	}
	@Test 
	public void testHaceCircuitoVerdaderoGrafoNoConexo(){
		g = new GrafoConPesos(4);
		g.agregarArista(0, 1, 120);
		g.agregarArista(2, 1, 100);
		
		assertTrue(KruskalBFS.haceCircuito(g, 0, 2));
	}
	

	
}
