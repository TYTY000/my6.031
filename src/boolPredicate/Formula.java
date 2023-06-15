package boolPredicate;

import java.util.*;
import java.util.function.Function;

public interface Formula {

	public interface Visitor<R> { // renamed from FormulaFunction<R>
		public R on(Variable var); // renamed from onVariable, onNot, onAnd, onOr

		public R on(Not not);

		public R on(And and);

		public R on(Or or);
	}

	public static <E> Set<E> setUnion(Set<E> set1, Set<E> set2) {
		Set<E> tmp = new HashSet<E>(set1);
		tmp.addAll(set2);
		return tmp;
	}

	public <R> R accept(Visitor<R> visitor); // renamed from callFunction()

	Set<String> variables();
	/**
	 * @return a visitor object whose on(T) method calls the onT function parameter, 
	 *         for all T that are concrete variants of Formula
	 */
	public static <R> Formula.Visitor<R> makeVisitor(
	        Function<Variable,R> onVariable,
	        Function<Not,R> onNot,
	        Function<And,R> onAnd,
	        Function<Or,R> onOr
	) {
	    return new Visitor<R>() {
	        public R on(Variable var) { return onVariable.apply(var); }
	        public R on(Not not) { return onNot.apply(not); }
	        public R on(And and) { return onAnd.apply(and); }
	        public R on(Or or) { return onOr.apply(or); }
	    };
	// ... other operations ...

}
	public static boolean evaluate(Formula formula, Map<String,Boolean> map) {
	    return formula.accept(makeVisitor(
	        (Variable var) -> map.get(var.name()),
	        (Not not) -> !evaluate(not.formula(), map),
	        (And and) -> evaluate(and.left(), map)  &&  evaluate(and.right(), map),
	        (Or or)   -> evaluate(or.left(),  map)  ||  evaluate(or.right(),  map) 
	    ));
	}
}