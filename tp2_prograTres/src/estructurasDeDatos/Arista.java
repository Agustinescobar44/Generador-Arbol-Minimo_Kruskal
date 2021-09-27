package estructurasDeDatos;


public class Arista implements Comparable<Arista>{
	private int a ;
	private int b ;
	private double peso ;
	
	public Arista(int a , int b , double peso2) {
		this.a = a;
		this.b = b;
		this.peso = peso2;
	}

	public int getA() {
		return a+0;
	}

	public int getB() {
		return b+0;
	}
	public double getPeso() {
		return peso+0;
	}

	public int compareTo(Arista o) {
		if(this.peso<o.peso) {
			return -1;
		}else if (this.peso>o.peso) {
			return 1;
		}
		return 0;
	}

	public void setPeso(double peso2) {
		this.peso = peso2;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if ((a == other.a && b == other.b) ||
				(a == other.b && b == other.a))
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Arista [a=");
		builder.append(a);
		builder.append(", b=");
		builder.append(b);
		builder.append(", peso=");
		builder.append(peso);
		builder.append("]");
		return builder.toString();
	}
}
