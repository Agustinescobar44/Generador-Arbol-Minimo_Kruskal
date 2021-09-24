package tp2_prograTres;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

public class Assert {


	public static void iguales(Set<Arista> esperados, GrafoConPesos kruskal) {
		assertEquals(esperados.size(), kruskal.getAristas().size());
		for (Arista arista : esperados) {
			assertTrue(kruskal.existeArista(arista.getA(), arista.getB()));
		}
	}

}
