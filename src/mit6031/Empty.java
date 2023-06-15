package mit6031;

public class Empty<E> implements ImList<E> {
	public Empty() {
	}

	public ImList<E> cons(E elt) {
		return new Cons<>(elt, this);
	}

	public E first() {
		throw new UnsupportedOperationException();
	}

	public ImList<E> rest() {
		throw new UnsupportedOperationException();
	}
}