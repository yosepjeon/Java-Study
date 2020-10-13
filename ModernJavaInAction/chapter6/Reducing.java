package ModernJavaInAction.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reducing {
	public static void main(String[] args) {
		int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		
		System.out.println(totalCalories);
		
		double avgCalories = Dish.menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println(avgCalories);
		
		IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
//		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
//		System.out.println(shortMenu);
		
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println(shortMenu);
		
		int totalCaloriesUsingReduce = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i,j) -> i+j));
		System.out.println(totalCaloriesUsingReduce);
		
		Optional<Dish> mostCalorieDish = Dish.menu.stream()
				.collect(Collectors.reducing((d1,d2) -> d1.getCalories() > d2.getCalories()? d1:d2));
		System.out.println(mostCalorieDish);
		
		/*
		 * collect와 reduce
		 */
		Stream<Integer> stream1 = Arrays.asList(1,2,3,4,5,6).stream();
		@SuppressWarnings("unchecked")
		List<Integer> numbers = stream1.reduce(new ArrayList(), (List<Integer> list, Integer e) -> {
			list.add(e);
			return list;
		},(List<Integer> list1, List<Integer> list2)->{
			list1.addAll(list2);
			return list1;
		});
		
		List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6).stream().collect(Collectors.toList());
		System.out.println(numbers);
		System.out.println(numbers2);
		
		System.out.println(Dish.menu.stream().mapToInt(Dish::getCalories).sum());
	}
}
