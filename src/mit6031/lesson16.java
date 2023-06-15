package mit6031;

public class lesson16 {
	public static void main(String[] args) {
		ImList<Integer> nil = ImList.empty();
		ImList<Integer> x = nil.cons(2).cons(1).cons(0);
		System.out.println(x.first());
		System.out.println(x.rest().rest().first());

		ImList<Integer> y = x.rest().cons(4);
		System.out.println(y.first());

	}
}
