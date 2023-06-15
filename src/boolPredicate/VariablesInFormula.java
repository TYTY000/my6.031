package boolPredicate;

import java.util.*;
import java.util.Set;

class VariablesInFormula implements Formula.Visitor<Set<String>> {
    @Override public Set<String> on(Variable var) {
        return Collections.singleton(var.name());
    }
    @Override public Set<String> on(Not not) {
        return not.formula().accept(this);
    }
    @Override public Set<String> on(And and) {
	    return Formula.setUnion(and.left().accept(this), 
							    and.right().accept(this));
    }
    @Override public Set<String> on(Or or) {
        return Formula.setUnion(or.left().accept(this), 
        						or.right().accept(this));
    }
}