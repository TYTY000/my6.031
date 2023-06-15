package boolPredicate;

import java.util.Set;

class Variable implements Formula {
	String name;

	public String name() {
		return this.name;
	}
	public Variable(String name) { // 这是一个构造器，它接受一个String参数
		this.name = name; // 把参数赋值给name字段
	}
	// ... constructor, other operations ...

	@Override
	public Set<String> variables() {
		return Set.of(this.name);
	}

	@Override
	public <R> R accept(Visitor<R> visitor) {
		return visitor.on(this);
	}

}
