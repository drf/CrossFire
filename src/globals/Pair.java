package globals;

public class Pair<E> {
	private E a;
	private E b;
	
	public Pair() {
		a = null;
		b = null;
	}
	
	public Pair(E a, E b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public E getSecond() {
		return b;
	}

	public void setSecond(E second) {
		this.b = second;
	}

	public void setFirst(E first) {
		this.a = first;
	}

	public E getFirst() {
		return a;
	}	
}
