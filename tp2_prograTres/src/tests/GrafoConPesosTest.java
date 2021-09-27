package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;

public class GrafoConPesosTest {

	GrafoConPesos g ;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAgregarArista() {
		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		assertTrue(g.getAristas().contains(new AristaConPeso(0, 1, 150)));
		assertTrue(g.existeArista(0, 1));
	}
	@Test (expected = RuntimeException.class)
	public void testAgregarAristaExistente() {
		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(0, 1, 150);
	}

	@Test
	public void testGetPeso() {
		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(2, 1, 120);
		g.agregarArista(3, 1, 10);
		g.agregarArista(4, 1, 200);
		
		assertEquals(120, g.getPeso(2, 1),0.1);
	}
	@Test (expected = RuntimeException.class)
	public void testGetPesoAristaInexistente() {
		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(2, 1, 120);
		g.agregarArista(3, 1, 10);
		g.agregarArista(4, 1, 200);
		
		assertEquals(32, g.getPeso(3, 0),0.1);
	}
	
}
