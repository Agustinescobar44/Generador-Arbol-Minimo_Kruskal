package estructurasDeDatos;

import java.util.ArrayList;


public class GrafoConPesos extends Grafo {

	private ArrayList<Arista> aristas;
	private Arista maxima;
	public GrafoConPesos(int i) {
		super(i);
		aristas = new ArrayList<Arista>();
	}
	
	public void agregarArista(int a , int b , double peso) {
		if(!existeArista(a, b)) {
			agregarArista(a, b);
			aristas.add(new Arista(a, b, peso));
			maxima = dameAristaMaxima();
		}
	}
	
	public double getPeso(int a , int b) {
			for (Arista arista : aristas) {
				if(arista.getA() == a && arista.getB() == b) {
					return arista.getPeso();
				}
			}
		return 0;
	}
	
	
	public ArrayList<Arista> getAristas(){
		return aristas;
	}

	public Arista getMaxima() {
		return maxima;
	}
	
	private Arista dameAristaMaxima() {
		Arista maxima = aristas.get(0);
		for (Arista arista : getAristas()) {
			if (arista.compareTo(maxima)>0) {
				maxima = arista;
			}
		}
		return maxima;
	}
}
