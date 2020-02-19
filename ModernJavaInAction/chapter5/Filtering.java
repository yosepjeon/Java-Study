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
		List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		vegetarianMenu.forEach(System.out::println);

		// 고유 요소로 거름
		System.out.println("Filtering unique elements:");
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

		// 스트림 슬라이스
		// 칼로리 값을 기준으로 리스트를 오름차순 정렬
		List<Dish> specialMenu = Arrays.asList(new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER));
		
		System.out.println("Filtered sorted menu:");
		
	}
}
