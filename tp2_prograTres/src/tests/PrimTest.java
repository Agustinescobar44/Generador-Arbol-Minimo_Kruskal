package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;
import metodos.Prim;

public class PrimTest {

	GrafoConPesos g;
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGrafoNull() {
		g=null;
		Prim.prim(g,0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testorigenInvalido() {
		g=new GrafoConPesos(9);
		Prim.prim(g,10);
	}
	@Test
	public void testEsperado() {
		g = new GrafoConPesos(5);
		g.agregarAristaConPeso(0, 1, 150);
		g.agregarAristaConPeso(1, 2, 200);
		g.agregarAristaConPeso(2, 4, 300);
		g.agregarAristaConPeso(4, 3, 75);
		g.agregarAristaConPeso(3, 1,500);
		g.agregarAristaConPeso(4, 0,100);
		
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		esperados.add(new AristaConPeso(0, 1, 150));
		esperados.add(new AristaConPeso(1, 2, 200));
		esperados.add(new AristaConPeso(4, 0, 100));
		esperados.add(new AristaConPeso(4, 3, 75));
		
		Assert.iguales(esperados , Prim.prim(g,0));
	}
	
	@Test(expected = RuntimeException.class)
	public void testPrimGrafoNoConexo() {
		g = new GrafoConPesos(5);
		g.agregarAristaConPeso(0, 1, 150);
		g.agregarAristaConPeso(1, 2, 200);
		g.agregarAristaConPeso(2, 4, 300);
		g.agregarAristaConPeso(4, 0,100);
		Prim.prim(g, 0);
	}
	
	@Test
	public void testGrafoSinAristas() {
		g = new GrafoConPesos(5);
		Set<AristaConPeso> esperados = new HashSet<AristaConPeso>();
		
		Assert.iguales(esperados, Prim.prim(g, 0));
	}
	
	@Test
	public void testDameAristaMinima() {
		Set<Integer> verticesContados = new HashSet<>();
		verticesContados.add(0);
		g = new GrafoConPesos(3);
		g.agregarAristaConPeso(0, 1, 150);
		g.agregarAristaConPeso(0, 2, 100);
		g.agregarAristaConPeso(1, 2, 300);
		
		AristaConPeso retorno = Prim.dameAristaMinima(g,verticesContados);
		
		assertEquals(new AristaConPeso(0, 2, 100), retorno);
	}
	
	@Test
	public void testNoExisteVerticeVerdadero() {
		Set<Integer> verticesContados = new HashSet<>();
		verticesContados.add(0);
		verticesContados.add(4);
		
		AristaConPeso arista = new AristaConPeso(4, 1, 300);
		
		assertTrue(Prim.noExisteArista(arista,verticesContados));
		
	}
	@Test
	public void testNoExisteVerticeFalso() {
		Set<Integer> verticesContados = new HashSet<>();
		verticesContados.add(0);
		verticesContados.add(4);
		
		AristaConPeso arista = new AristaConPeso(4, 0, 300);
		
		assertFalse(Prim.noExisteArista(arista,verticesContados));
		
	}

}
