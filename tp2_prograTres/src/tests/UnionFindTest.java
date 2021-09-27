package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.UnionFind;

public class UnionFindTest {
	UnionFind unionFind;


	@Test
	public void testBuscarRaiz() {
		unionFind=new UnionFind(3);
		unionFind.unir(0, 2);
		assertEquals(unionFind.buscarRaiz(0),2);
	}

	@Test
	public void testUnir() {
		unionFind=new UnionFind(3);
		unionFind.unir(0, 2);
		assertEquals(unionFind.buscarRaiz(0),unionFind.buscarRaiz(2));
	}

	@Test
	public void testEsConexo() {
		unionFind=new UnionFind(3);
		unionFind.unir(0, 1);
		unionFind.unir(1, 2);
		assertTrue(unionFind.esConexo());
	}
	
	@Test
	public void testNoEsConexo() {
		unionFind=new UnionFind(3);
		unionFind.unir(0, 1);
		assertFalse(unionFind.esConexo());
	}
	
	@Test
	public void testMismaCompConexa() {
		unionFind=new UnionFind(5);
		unionFind.unir(0, 1);
		unionFind.unir(1, 2);
		assertTrue(unionFind.mismaCompConexa(0,2));
	}

}
