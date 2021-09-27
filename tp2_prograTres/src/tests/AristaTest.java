package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.Arista;

public class AristaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompareAMenor() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(0, 1, 2000);
		assertEquals(-1, a.compareTo(b));
	}
	@Test
	public void testCompareAMayor() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(0, 1, 2);
		assertEquals(1, a.compareTo(b));
	}
	@Test
	public void testCompareAigual() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(0, 1, 120);
		assertEquals(0, a.compareTo(b));
	}

	@Test
	public void testEqualsVerticesCambiados() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(1, 0, 120);
		assertTrue(a.equals(b));
	}
	@Test
	public void testEqualsVerticesIguales() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(0, 1, 120);
		assertTrue(a.equals(b));
	}
	@Test
	public void testEqualsAristasDiferentes() {
		Arista a = new Arista(0, 1, 120);
		Arista b = new Arista(2, 1, 120);
		assertFalse(a.equals(b));
	}
}
