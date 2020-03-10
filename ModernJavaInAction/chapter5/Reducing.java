package ModernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static ModernJavaInAction.chapter4.Dish.menu;

public class Reducing {
	public static void main(String[] args ) {
		List<Integer> numbers = Arrays.asList(3,4,5,1,2);
		int sum = numbers.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
		int sum2 = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum2);
		
		Optional<Integer> sum3 = numbers.stream().reduce((a,b)-> (a+b));
		System.out.println(sum3.get());
		
		int max = numbers.stream().reduce(0,(a,b) -> a>b? a:b);
		System.out.println(max);
		Optional<Integer> max2 = numbers.stream().reduce(Integer::max);
		System.out.println(max2.get());
		
		Optional<Integer> min = numbers.stream().reduce((a,b) -> a < b? a:b);
		min.ifPresent(System.out::println);
		
		Optional<Integer> min2 = numbers.stream().reduce(Integer::min);
		min2.ifPresent(System.out::println);
		
		Optional<Integer> dishCount = menu.stream().map(d -> 1).reduce(Integer::sum);
		dishCount.ifPresent(System.out::println);
	}
}
