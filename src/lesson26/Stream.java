package lesson26;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
class C {
    static int x = 5;
    static int y = 8;

    static boolean isOdd(int x) {
      return x % 2 == 1;
    }

    static boolean xIsOdd = x % 2 == 1;

    static int oddOrIdentity(int x) {
      return isOdd(x) ? x : 1;
    }

    static int identityFunction(int x) {
        return x;
    }

    static int sum(int x, int y) {
      return x + y;
    }

    static Function<Integer, Integer> identity = x -> x;

    static int product(int x, int y) {
      return x * y;
    }

    static boolean alwaysTrue(int x) {
      return true;
    }

    static Function<Integer,Boolean> modulusTester(int i) {
      return x -> x % 2 == i;
    }

}
public class Stream {
//	static int productOfOdds(List<Integer> list) {
//	    int result = 1;
//	    for (int x : list) {
//	        if (x % 2 == 1) {
//	            result *= x;
//	        }
//	    }
//	    return result;
//	}
	static int productOfOdds(List<Integer> list) {
	    return list.stream()
	    		.map(C.identity)
	    		.filter(C::alwaysTrue)
	    		.reduce(1, C::product);
	}
	
	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		List<Integer> list = List.of(1,2,3,4,5);
		System.out.println(productOfOdds(list));
		
		
		
		
//		List<Integer> intList = List.of(1, 4, 9, 16);
//		java.util.stream.Stream<Integer> intStream = intList.stream();
//		java.util.stream.Stream<Double> t = intStream.map(x -> Math.sqrt(x)); // like haskell
//
//		ps.println("Using println method: ");
//		t.forEach(ps::println);
//
//		ps.print("Using format method: ");
//		intList.forEach(n -> ps.format("%d ", n));
//
//		String[] stringArray = new String[] { "a", "b", "c" };
//		java.util.stream.Stream<String> stringStream = Arrays.stream(stringArray);
////		stringStream.forEach(ps::println);
//		// like mapM in Haskell
//		ps.println();
//		ps.print("Using stringstream: ");
//		java.util.stream.Stream<String> moreStringsStream = java.util.stream.Stream.concat(stringStream,
//				java.util.stream.Stream.of("d", "e", "f"));
//		moreStringsStream.forEach(n -> ps.format("%s ", n));
//
//		ps.println();
//		ps.print("Using IntStream boxing: ");
//		java.util.stream.Stream<Integer> numbers0Through99 = IntStream.range(0, 50).boxed();
//		numbers0Through99.forEachOrdered(n -> ps.format("%d ", n));
//		// IntStream.range() produces a stream of primitive ints,
//		// just like range() in Python.
//		// Then boxed() converts it to a Stream of Integer objects.
//
//		ps.println();
//		Function<Double, Double> mySquareRoot = Math::sqrt;
//		System.out.println(mySquareRoot.apply(16.0)); // returns 4.0
//
//		List.of("1", "2", "3").stream().map(String::length).forEach(n -> ps.format("%s ", n));;
//		ps.println();
//
//		System.out.println(List.of(1, 2, 3).stream().reduce("", // identity value
//				(String s, Integer n) -> s + n, // accumulator
//				(String s, String str) -> s + str // combiner
//		));
//		
//		List<Integer> list = List.of(1,2,3);
//		Optional<Integer> maybeResult = list.stream().reduce(Math::min);
//		int result1 = maybeResult.orElse(0);
//		int result2 = maybeResult.get();
//		int result3 = list.stream().reduce(Integer.MAX_VALUE, Math::min);
//
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
//		
		
		
		

		
	}
}
