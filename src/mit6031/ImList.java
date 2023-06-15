package mit6031;

public interface ImList<E> {
	public static <E> ImList<E> empty() {
		return new Empty<>();
	}

	public ImList<E> cons(E elt);

	public E first();

	public ImList<E> rest();
}