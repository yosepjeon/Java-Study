package ModernJavaInAction.chapter4;
import static ModernJavaInAction.chapter4.Dish.menu;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {
	public static void main(String[] args ) {
//		List<String> names = menu.stream()
//				.filter(dish -> {
//					System.out.println("filtering " + dish.getName());
//					return dish.getCalories() > 300;
//				})
//				.map(dish -> {
//					System.out.println("mapping " + dish.getName());
//					return dish.getName();
//				})
//				.collect(Collectors.toList());
		
		List<Dish> highCalories = menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.map(dish -> dish)
				.collect(Collectors.toList());
		
		System.out.println(highCalories);
	}
}
