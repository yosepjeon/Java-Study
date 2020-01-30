package ModernJavaInAction.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(
			new Apple(80,Color.GREEN),
			new Apple(155, Color.GREEN),
			new Apple(120, Color.RED)
		);
		
		// [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
		System.out.println(greenApples);
		
		// [Apple{color=RED, weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
		System.out.println(redApples);
		
		// [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
		List<Apple> greeApples2 = filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(greeApples2);
		
		// [Apple{color=GREEN, weight=155}]
		List<Apple> heavyApples = filterApples(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);
		
		// []
		List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);
		
		// [Apple{color=RED, weight=120}]
		List<Apple> redApples2 = filterApples(inventory, new ApplePredicate() {

			@Override
			public boolean test(Apple a) {
				// TODO Auto-generated method stub
				return a.getColor().equals(Color.RED);
			}
			
		});
		System.out.println(redApples2);
		
		prettyPrintApple(inventory, new AppleStringNormalFormatter());
		prettyPrintApple(inventory, new AppleStringColorFormatter());
		prettyPrintApple(inventory, new AppleStringWeightAndColorFormatter());
	}

	// 첫번째 시도: 필터링
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor() == Color.GREEN) {
				result.add(apple);
			}
		}

		return result;
	}

	// 두번째 시도: 색을 파라미터화
	public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor() == color) {
				result.add(apple);
			}
		}

		return result;
	}

	// 두번째 시도: 무게를 파라미터화
	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}

		return result;
	}

	// 세번째 시도: 가능한 모든 속성으로 필터링(실전에서는 절대 이 방법을 사용하지 말아야 한다.)
	// 형편없는 코드... flag의 의미를 알수 없을 뿐더러 요구사항에 유연하게 대응할 수 없음.
	public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ((flag && apple.getColor() == color) || (!flag && apple.getWeight() > weight)) {
				result.add(apple);
			}
		}

		return result;
	}

	// 네번째 시도: 추상적 조건으로 필터링
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}

		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter p) {
		for(Apple apple : inventory) {
			String output = p.format(apple);
			System.out.println(output);
		}
	}

	enum Color {
		RED, GREEN
	}

	public static class Apple {
		private int weight = 0;
		private Color color;

		public Apple(int weight, Color color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		@SuppressWarnings("boxing")
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("Apple{color=%s, weight=%d}", color, weight);
		}
	}

	interface ApplePredicate {
		boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate {
		@Override
		public boolean test(Apple apple) {
			// TODO Auto-generated method stub
			return apple.getWeight() > 150;
		}
	}

	static class AppleGreenColorPredicate implements ApplePredicate {
		public boolean test(Apple apple) {
			return apple.getColor().equals(Color.GREEN);
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate {

		@Override
		public boolean test(Apple apple) {
			// TODO Auto-generated method stub
			return apple.getClass().equals(Color.RED) && apple.getWeight() > 150;
		}

	}
	
	interface AppleFormatter {
		String format(Apple apple);
	}
	
	static class AppleStringNormalFormatter implements AppleFormatter {

		@Override
		public String format(Apple apple) {
			// TODO Auto-generated method stub
			
			return "this Apple Weight is " + apple.getWeight() + "g";
		}
		
	}
	
	static class AppleStringColorFormatter implements AppleFormatter {

		@Override
		public String format(Apple apple) {
			// TODO Auto-generated method stub
			return "this Apple Color is " + apple.getColor();
		}
		
	}
	
	static class AppleStringWeightAndColorFormatter implements AppleFormatter {

		@Override
		public String format(Apple apple) {
			// TODO Auto-generated method stub
			String str = apple.getWeight() > 150 ? "heavy" : "light";
			
			return "this Apple is " + str + " And Color is" + apple.getColor();
		}
		
	}
}
