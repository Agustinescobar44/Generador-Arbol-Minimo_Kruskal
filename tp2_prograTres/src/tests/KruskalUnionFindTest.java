package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.Arista;
import estructurasDeDatos.GrafoConPesos;
import estructurasDeDatos.UnionFind;
import metodos.KruskalBFS;
import metodos.KruskalUnionFind;

public class KruskalUnionFindTest {
	
	GrafoConPesos g;
	KruskalUnionFind kruskal;
	UnionFind unionFind;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void tamano() {
		g=new GrafoConPesos(10);
		g.agregarArista(0,1,1);
		g.agregarArista(1,2,2);
		g.agregarArista(2,4,3);
		g.agregarArista(4,3,1);
		g.agregarArista(3,1,8);
		g.agregarArista(3,0,9);
		assertEquals(g.getAristas().size(),6);
	}
	
	@Test
	public void testKruskal() {
		g=new GrafoConPesos(5);
		g.agregarArista(0,1,1);
		g.agregarArista(1,2,2);
		g.agregarArista(2,4,3);
		g.agregarArista(4,3,1);
		g.agregarArista(3,1,8);
		g.agregarArista(3,0,9);
		
		Set<Arista> esperados = new HashSet<Arista>();
		esperados.add(new Arista(0, 1, 1));
		esperados.add(new Arista(1, 2, 2));
		esperados.add(new Arista(2, 4, 3));
		esperados.add(new Arista(4, 3, 1));
		kruskal=new KruskalUnionFind();
		Assert.iguales(esperados ,kruskal.Kruskal(g));
	}

	@Test
	public void testDameMinimaNoConexa() {
		g=new GrafoConPesos(3);
		kruskal=new KruskalUnionFind();
		unionFind=new UnionFind(3);
		GrafoConPesos aux=new GrafoConPesos(3);
		g.agregarArista(0,1,1);
		g.agregarArista(1,2,2);
		assertEquals(new Arista(0,1,1),kruskal.dameMinimaNoConexa(g,unionFind,aux));
	}

	@Test
	public void testAgregarArista() {
		g=new GrafoConPesos(3);
		g.agregarArista(0,1,1);
		g.agregarArista(1,2,2);
		kruskal=new KruskalUnionFind();
		GrafoConPesos grafo=kruskal.Kruskal(g);
		assertTrue(grafo.existeArista(0, 1));
		
		
	}

}
