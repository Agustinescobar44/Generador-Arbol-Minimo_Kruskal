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
		unionFind=new UnionFind(10);
		unionFind.unir(0, 1);
		unionFind.unir(1, 2);
		unionFind.unir(2, 3);
		unionFind.unir(3, 4);
		unionFind.unir(4, 5);
		unionFind.unir(5, 6);
		unionFind.unir(7, 8);
		unionFind.unir(8, 9);
		unionFind.unir(9, 6);
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