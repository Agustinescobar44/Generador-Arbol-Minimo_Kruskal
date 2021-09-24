package tp2_prograTres;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KruskalTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testKruskalEsperado() {

		g = new GrafoConPesos(5);
		g.setArista(0, 1, 150);
		g.setArista(1, 2, 200);
		g.setArista(2, 4, 300);
		g.setArista(4, 3, 75);
		g.setArista(3, 1,500);
		g.setArista(4, 0,100);
		
		Set<Arista> esperados = new HashSet<Arista>();
		esperados.add(new Arista(0, 1, 150));
		esperados.add(new Arista(1, 2, 200));
		esperados.add(new Arista(4, 0, 100));
		esperados.add(new Arista(4, 3, 75));
		
		Assert.iguales(esperados , Kruskal.kruskal(g));
	}
	@Test 
	public void testKruskalGrafoSinAristas() {
		
		g = new GrafoConPesos(5);
		Set<Arista> esperados = new HashSet<Arista>();
		
		Assert.iguales(esperados, g);
	}
	
	@Test
	public void testDameMinimaNoMarcada() {
		g = new GrafoConPesos(5);
		g.setArista(0, 1, 150);
		g.setArista(1, 2, 200);
		g.setArista(2, 4, 300);
		g.setArista(4, 3, 75);
		g.setArista(3, 1,500);
		g.setArista(4, 0,100);
		
		GrafoConPesos arbol = new GrafoConPesos(5);
		
		arbol.setArista(4, 3, 75);
		arbol.setArista(4, 0, 100);
		
		assertEquals(new Arista(0, 1, 150), Kruskal.dameMinimaNoConexa(g,arbol));
		
	}

	@Test 
	public void testHaceCircuitoFalso(){
		g = new GrafoConPesos(3);
		g.setArista(0, 1, 120);
		
		assertFalse(Kruskal.haceCircuito(g, 0, 2));
	}
	@Test 
	public void testHaceCircuitoVerdadero(){
		g = new GrafoConPesos(3);
		g.setArista(0, 1, 120);
		g.setArista(2, 1, 100);
		
		assertTrue(Kruskal.haceCircuito(g, 0, 2));
	}
	
}
