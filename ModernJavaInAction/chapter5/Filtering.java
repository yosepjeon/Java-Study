package ModernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ModernJavaInAction.chapter4.Dish;
import static ModernJavaInAction.chapter4.Dish.menu;;

public class Filtering {
	public static void main(String[] args) {
		// 프레디케이트로 거름
		System.out.println("Filtering with a predicate");
		List<Dish> vegetarianMenu = menu.stream()
				.filter(Dish::isVegetarian)
				.collect(Collectors.toList());
		vegetarianMenu.forEach(System.out::println);
		
		// 고유 요소로 거름
		System.out.println("Filtering unique elements:");
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
			.filter(i -> i % 2 == 0)
			.distinct()
			.forEach(System.out::println);
	}
}
