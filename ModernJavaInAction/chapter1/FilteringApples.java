package ModernJavaInAction.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

public class FilteringApples {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(
			new Apple(80,"green"),
			new Apple(155, "green"),
			new Apple(120, "red")
		);
		
//		result = [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//		List<Apple> greenApples = filterApples(inventory,(apple) -> "green".equals(apple.getColor()));
		List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		System.out.println(" greenApples = " + greenApples);
		
//		result = [Apple{color='green', weight=155}]
//		List<Apple> heavyApples = filterApples(inventory, (apple) -> apple.getWeight() > 150);
		List<Apple> heavyApples = filterApples(inventory,FilteringApples::isHeavyApple);
		System.out.println(" heavyApples = " + heavyApples);
		
//		result = [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filterApples(inventory,(apple) -> "green".equals(apple.getColor()));
//		List<Apple> greenApples2 = filterApples(inventory, FilteringApples::isGreenApple);
		System.out.println("greenApples2 = " + greenApples2);
		
//		result = [Apple{color='green', weight=155}]
		List<Apple> heavyApples2 = filterApples(inventory, (apple) -> apple.getWeight() > 150);
//		List<Apple> heavyApples2 = filterApples(inventory, FilteringApples::isHeavyApple);
		System.out.println("heavyApples2 = " + heavyApples2);
		
		// result = []
		List<Apple> weirdApples = filterApples(inventory, (apple) -> apple.getWeight() < 80 || "brown".equals(apple.getColor()));
		System.out.println(" weirdApples = " + weirdApples);
		
//		use stream sequential
		List<Apple> heavyApplesByStreamSequential = inventory.stream().filter(apple -> apple.getWeight() > 150).collect(toList());
		System.out.println("heavyApplesByStream = " + heavyApplesByStreamSequential);
		
//		use stream parallel
		List<Apple> heavyApplesByStreamPrallel = inventory.parallelStream().filter(apple -> apple.getWeight() > 150).collect(toList());
		System.out.println("heavyApplesByStreamPrallel = " + heavyApplesByStreamPrallel);
	}
	
	// 레거시 자바 코드
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple : inventory) {
			if("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	// 레거시 자바 코드
	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple : inventory) {
			if(apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static class Apple {
		private int weight = 0;
		private String color = "";
		
		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@SuppressWarnings("boxing")
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("Apple{color='%s', weight=%d}", color, weight);
		}
	}
}
