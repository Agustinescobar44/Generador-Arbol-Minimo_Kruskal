package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import metodos.KruskalBFS;

public class KruskalBFSTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
	}

	@Test @Ignore
	public void testKruskalEsperado() {

		g = new GrafoConPesos(5);
		g.agregarArista(0, 1, 150);
		g.agregarArista(1, 2, 200);
		g.agregarArista(2, 4, 300);
		g.agregarArista(4, 3, 75);
		g.agregarArista(3, 1,500);
		g.agregarArista(4, 0,100);
		
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		esperados.add(new AristaConPeso(0, 1, 150));
		esperados.add(new AristaConPeso(1, 2, 200));
		esperados.add(new AristaConPeso(4, 0, 100));
		esperados.add(new AristaConPeso(4, 3, 75));
		
		Assert.iguales(esperados , KruskalBFS.kruskal(g));
	}
	
	@Test 
	public void testKruskalGrafoSinAristas() {
		
		g = new GrafoConPesos(5);
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		
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
		
		Set<AristaConPeso> aristasGrafo = g.getAristas();
		GrafoConPesos arbol = new GrafoConPesos(5);
		
		arbol.agregarArista(4, 3, 75);
		arbol.agregarArista(4, 0, 100);
		aristasGrafo.remove(new AristaConPeso(4, 3, 75));
		aristasGrafo.remove(new AristaConPeso(4, 0, 100));
		
		assertEquals(new AristaConPeso(0, 1, 150), KruskalBFS.dameMinimaNoConexa(aristasGrafo,arbol));
		
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
