package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import metodos.KruskalBFS;

public class KruskalBFSTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
	}

	@Test 
	public void testKruskalEsperado() {

		g = new GrafoConPesos(5);
		generarGrafoConexo();
		
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		aristasEsperadas(esperados);
		
		Assert.iguales(esperados , KruskalBFS.kruskal(g));
	}

	private void aristasEsperadas(Set<AristaConPeso> esperados) {
		esperados.add(new AristaConPeso(0, 1, 150));
		esperados.add(new AristaConPeso(1, 2, 200));
		esperados.add(new AristaConPeso(4, 0, 100));
		esperados.add(new AristaConPeso(4, 3, 75));
	}
	
	@Test
	public void testDameMinimaNoConexa() {
		g = new GrafoConPesos(5);
		generarGrafoConexo();
		
		Set<AristaConPeso> aristasGrafo = g.getAristas();
		GrafoConPesos arbol = new GrafoConPesos(5);
		
		arbol.agregarAristaConPeso(4, 3, 75);
		arbol.agregarAristaConPeso(4, 0, 100);
		aristasGrafo.remove(new AristaConPeso(4, 3, 75));
		aristasGrafo.remove(new AristaConPeso(4, 0, 100));
		
		assertEquals(new AristaConPeso(0, 1, 150), KruskalBFS.dameMinimaNoConexa(aristasGrafo,arbol));
		
	}

	private void generarGrafoConexo() {
		g.agregarAristaConPeso(0, 1, 150);
		g.agregarAristaConPeso(1, 2, 200);
		g.agregarAristaConPeso(2, 4, 300);
		g.agregarAristaConPeso(4, 3, 75);
		g.agregarAristaConPeso(3, 1,500);
		g.agregarAristaConPeso(4, 0,100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKruskalGrafoNoConexo() {
		g = new GrafoConPesos(5);
		generarGrafoNoConexo();
		KruskalBFS.kruskal(g);
	}

	private void generarGrafoNoConexo() {
		g.agregarAristaConPeso(1, 2, 200);
		g.agregarAristaConPeso(2, 4, 300);
		g.agregarAristaConPeso(4, 3, 75);
		g.agregarAristaConPeso(3, 1,500);
	}
	
	@Test 
	public void testKruskalGrafoSinAristas() {
		
		g = new GrafoConPesos(5);
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		
		Assert.iguales(esperados, g);
	}
	
	

	@Test 
	public void testHaceCircuitoFalso(){
		g = new GrafoConPesos(3);
		g.agregarAristaConPeso(0, 1, 120);
		
		assertFalse(KruskalBFS.haceCircuito(g, 0, 2));
	}
	@Test 
	public void testHaceCircuitoVerdadero(){
		g = new GrafoConPesos(3);
		g.agregarAristaConPeso(0, 1, 120);
		g.agregarAristaConPeso(2, 1, 100);
		
		assertTrue(KruskalBFS.haceCircuito(g, 0, 2));
	}
	@Test 
	public void testHaceCircuitoVerdaderoGrafoNoConexo(){
		g = new GrafoConPesos(4);
		g.agregarAristaConPeso(0, 1, 120);
		g.agregarAristaConPeso(2, 1, 100);
		
		assertTrue(KruskalBFS.haceCircuito(g, 0, 2));
	}
	

	
}
