package lesson27;

import java.util.function.BiFunction;

public class lesson27 {
	
	
	class AndFunction implements BiFunction<Boolean,Boolean,Boolean> {
		public Boolean apply(Boolean t, Boolean u) {
			return p && q;
		}
	}
	BiFunction<Boolean,Boolean,Boolean> f1 = new AndFunction();
	boolean p = true;
	boolean q = false;
	boolean result = f1.apply(p, q);
	
	
	
	BiFunction<Boolean,Boolean,Boolean> f2 = (p, q) -> p && q;
	
	
}
