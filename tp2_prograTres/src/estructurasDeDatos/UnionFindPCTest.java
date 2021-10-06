package estructurasDeDatos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnionFindPCTest {
	
	UnionFindPC unionFind=new UnionFindPC(5);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuscarRaiz() {
		unionFind.unir(1, 0);
		unionFind.unir(3, 1);
		unionFind.unir(2, 1);
		unionFind.unir(4, 0);
		int[] esperados= {0,0,0,0};
		int[] obtenidos= new int[4];
		obtenidos[0]=unionFind.buscarRaiz(0);
		obtenidos[1]=unionFind.buscarRaiz(1);
		obtenidos[2]=unionFind.buscarRaiz(2);
		obtenidos[3]=unionFind.buscarRaiz(3);
		assertArrayEquals(esperados, obtenidos);
 	}

}
