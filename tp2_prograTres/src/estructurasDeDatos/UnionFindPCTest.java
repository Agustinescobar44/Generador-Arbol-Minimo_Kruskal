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
		unionFind.unir(0, 1);
		unionFind.unir(3, 1);
		unionFind.unir(2, 1);
		unionFind.unir(0, 4);
		int[] esperados= {0,0,0,0};
		int[] obtenidos= new int[4];
		obtenidos[0]=0;
		obtenidos[1]=0;
		obtenidos[2]=0;
		obtenidos[3]=0;
		assertArrayEquals(esperados, obtenidos);
 	}

}
