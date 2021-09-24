package tp2_prograTres;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KruskalTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
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
