package boolPredicate;

import java.util.Set;

class Or implements Formula {
	private Formula left, right;

	public Or(Formula f1, Formula f2) {
		// TODO Auto-generated constructor stub
		left = f1;
		right = f2;
	}

	public Formula left() {
		return this.left;
	}

	public Formula right() {
		return this.right;
	}

	// ... constructor, other operations ...
	@Override
	public Set<String> variables() {
		return Formula.setUnion(this.left.variables(), this.right.variables());
	}

	@Override
	public <R> R accept(Visitor<R> visitor) {
		return visitor.on(this);
	}
}
