package ModernJavaInAction.chapter4;

import java.util.List;
import java.util.stream.Collectors;

import static ModernJavaInAction.chapter4.Dish.menu;

public class HighCaloriesNames {
	public static void main(String[] args ) {
		List<String> names = menu.stream()
				.filter(dish -> {
					System.out.println("filtering " + dish.getName());
					return dish.getCalories() > 300;
				})
				.map(dish -> {
					System.out.println("mapping " + dish.getName());
					return dish.getName();
				})
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(names);
	}
}
