package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import estructurasDeDatos.AristaConPeso;
import estructurasDeDatos.GrafoConPesos;

public class Assert {


	public static void iguales(Set<AristaConPeso> esperados, GrafoConPesos grafo) {
		assertEquals(esperados.size(), grafo.getAristas().size());
		for (AristaConPeso arista : esperados) {
			assertTrue(grafo.existeArista(arista.getA(), arista.getB()));
		}
	}

	public static void iguales(int[] esperados, Set<Integer> alcanzables) {
		assertEquals(esperados.length, alcanzables.size());
		for (Integer elem : esperados) {
			assertTrue(alcanzables.contains(elem));
		}
	}
}
