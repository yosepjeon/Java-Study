package ModernJavaInAction.chapter5;
import static ModernJavaInAction.chapter4.Dish.menu;

import java.util.Optional;

import ModernJavaInAction.chapter4.Dish;

public class Finding {
	public static void main(String[] args) {
		
	}
	
	private static boolean isVegetarianFriendlyMenu() {
		return menu.stream().anyMatch(Dish::isVegetarian);
	}
	
	private static boolean isHealthyMenu() {
		return menu.stream().allMatch(d -> d.getCalories() < 1000);
	}
	
	private static boolean isHealthyMenu2() {
		return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
	}
	
	private static Optional<Dish> findVegetarianDish() {
		return menu.stream().filter(Dish::isVegetarian).findAny();
	}
}
