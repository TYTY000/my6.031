package boolPredicate;

import java.util.Map;

class EvaluateVisitor implements Formula.Visitor<Boolean> {
	private Map<String, Boolean> map;

	public EvaluateVisitor(Map<String, Boolean> map) {
		this.map = map;
	}

	@Override
	public Boolean on(Variable var) {
		return map.get(var.name());
	}

	@Override
	public Boolean on(Not not) {
		return !not.formula().accept(this);
	}

	@Override
	public Boolean on(And and) {
		return and.left().accept(this) && and.right().accept(this);
	}

	@Override
	public Boolean on(Or or) {
		return or.left().accept(this) || or.right().accept(this);
	}

	/**
	 * @param formula
	 * @param map     must have a key for every variable in formula
	 * @return the value of the formula with variables substituted with their values
	 *         in the map
	 */
	public static boolean evaluate(Formula formula, Map<String, Boolean> map) {
		return formula.accept(new Formula.Visitor<Boolean>() {
			@Override
			public Boolean on(Variable var) {
				return (map.get(var.name())==null)?false:true;
			}

			@Override
			public Boolean on(Not not) {
				return !evaluate(not.formula(), map);
			}

			@Override
			public Boolean on(And and) {
				return evaluate(and.left(), map) && evaluate(and.right(), map);
			}

			@Override
			public Boolean on(Or or) {
				return evaluate(or.left(), map) || evaluate(or.right(), map);
			}
		});
	}
}