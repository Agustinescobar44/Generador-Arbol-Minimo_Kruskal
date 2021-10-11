package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estructurasDeDatos.AristaConPeso;

public class AristaConPesoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompareAMenor() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(0, 1, 2000);
		assertEquals(-1, a.compareTo(b));
	}
	@Test
	public void testCompareAMayor() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(0, 1, 2);
		assertEquals(1, a.compareTo(b));
	}
	@Test
	public void testCompareAigual() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(0, 1, 120);
		assertEquals(0, a.compareTo(b));
	}

	@Test
	public void testEqualsVerticesCambiados() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(1, 0, 120);
		assertTrue(a.equals(b));
	}
	@Test
	public void testEqualsVerticesIguales() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(0, 1, 120);
		assertTrue(a.equals(b));
	}
	@Test
	public void testEqualsAristasDiferentes() {
		AristaConPeso a = new AristaConPeso(0, 1, 120);
		AristaConPeso b = new AristaConPeso(2, 1, 120);
		assertFalse(a.equals(b));
	}
}
