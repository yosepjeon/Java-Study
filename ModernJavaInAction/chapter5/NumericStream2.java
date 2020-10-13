package ModernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ModernJavaInAction.chapter4.Dish;

import static ModernJavaInAction.chapter4.Dish.menu;

public class NumericStream2 {
	public static void main(String... args ) {
		List<Integer> numbers = Arrays.asList(3,4,5,1,2);
		
		Arrays.stream(numbers.toArray())
			.forEach(System.out::println);
		
		int calories = menu.stream()
				.mapToInt(c -> c.getCalories())
				.sum();
		System.out.println("Number of calories: " + calories);
		
		// max와 OptionalInt
		OptionalInt maxCalories = menu.stream()
				.mapToInt(Dish::getCalories)
				.max();
		
		int max = maxCalories.orElse(1);
		System.out.println(max);
		
		// 숫자 범위
		IntStream evenNumbersRangeClosed = IntStream.rangeClosed(1, 100)
				.filter(n -> n%2 == 0);
		System.out.println(evenNumbersRangeClosed.count());
		
		IntStream evenNumbersRange = IntStream.range(1, 100)
				.filter(n -> n%2 == 0);
		System.out.println(evenNumbersRange.count());
		
		// 피타고라스
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.range(a, 100).filter(b->Math.sqrt(a * a + b * b) % 1 == 0).boxed()
						.map(b -> new int[] {a,b,(int)Math.sqrt(a*a + b*b)}));
		pythagoreanTriples.forEach(p -> System.out.println(p[0] + ", " + p[1] + ", " + p[2]));
		
		// 피타고라스 최적화
		Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[] {a,b,Math.sqrt(a*a + b*b)})
						.filter(t -> t[2] % 1 == 0))
				.map(array -> Arrays.stream(array).mapToInt(a -> (int)a).toArray());
		pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
		// 피보나치
		Stream.iterate(new int[] {0,1}, t -> new int[] {t[1],t[0] + t[1]})
		.limit(10)
		.map(t -> t[0])
		.forEach(e -> System.out.println(e));;
	}
}
