package boolPredicate;

import java.util.*;
import java.util.Set;

public class Run {
	/**
	 * @param formula
	 * @param map     must have a key for every variable in formula
	 * @return the value of the formula with variables substituted with their values
	 *         in the map
	 */
	public static boolean evaluate(Formula formula, Map<String, Boolean> map) {
		return formula.accept(new EvaluateVisitor(map));
	}

	public static void main(String[] args) {
		Formula f1 = new Variable("A");
		Set<String> variables1 = f1.accept(new VariablesInFormula());
		Formula f2 = new Not(new Variable("Q"));
		Set<String> variables2 = f2.accept(new VariablesInFormula());
		Formula f3 = new And(new Variable("C"), new Variable("Q"));
		Set<String> variables3 = f3.accept(new VariablesInFormula());
		Formula f4 = new Or(new Variable("R"), f3);
		Set<String> variables4 = f4.accept(new VariablesInFormula());

		System.out.println(variables1);
		System.out.println(variables2);
		System.out.println(variables3);
		System.out.println(variables4);

		Map<String, Boolean> map = new HashMap<>();
		map.put("C", true);
		map.put("Q", true);
		map.put("R", true);
		System.out.println(map);
		
		System.out.println(EvaluateVisitor.evaluate(f1, map));
		System.out.println(EvaluateVisitor.evaluate(f2, map));
		System.out.println(EvaluateVisitor.evaluate(f3, map));
		System.out.println(EvaluateVisitor.evaluate(f4, map));

	}
}
