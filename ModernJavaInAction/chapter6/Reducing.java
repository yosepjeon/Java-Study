package ModernJavaInAction.chapter6;

import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reducing {
	public static void main(String[] args) {
		int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		
		System.out.println(totalCalories);
		
		double avgCalories = Dish.menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println(avgCalories);
		
		IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
	}
}
