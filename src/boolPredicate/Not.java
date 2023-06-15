package boolPredicate;

import java.util.Set;

class Not implements Formula {
	private Formula formula;

	public Not(Formula f) {
		// TODO Auto-generated constructor stub
		this.formula = f;
	}

	public Formula formula() {
		return this.formula;
	}

	// ... constructor, other operations ...
	@Override
	public Set<String> variables() {
		return this.formula.variables();
	}

	@Override
	public <R> R accept(Visitor<R> visitor) {
		return visitor.on(this);
	}
}
