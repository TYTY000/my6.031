package mit6031;

public class Cons<E> implements ImList<E> {
	private final E elt;
	private final ImList<E> rest;

	public Cons(E elt, ImList<E> rest) {
		this.elt = elt;
		this.rest = rest;
	}

	public ImList<E> cons(E elt) {
		return new Cons<>(elt, this);
	}

	public E first() {
		return elt;
	}

	public ImList<E> rest() {
		return rest;
	}
}