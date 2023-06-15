

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;


import org.junit.jupiter.api.Test;

public class lesson3 {
	@Test
	public void testALessThanB() {
		assertEquals(2, Math.max(1, 2));
		System.out.println("assert passed!");
	}

	@Test
	public void testBothEqual() {
		Map<String, Integer> a = new HashMap<>(), b = new HashMap<>();
		String c = "c";
		a.put(c, 130);  // put integer into the maps
		b.put(c, 130);
		Boolean flag = a.get(c) == b.get(c); // what do we get out of the maps? are they equal?
		System.out.println(flag);
	}

	public static void main(String[] args) {
		int c = 1;
		System.out.println(c);
	}
}
/**
 *
 *
 *
 *
 *
*/