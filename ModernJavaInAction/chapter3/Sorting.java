package ModernJavaInAction.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		
		// 일반 람다 식으로 Comparator의 then연산을 수행하기 위해서는 따로 변수로 빼놔야할듯...
		Comparator<Apple> c = (a1,a2) -> a1.getWeight() - a2.getWeight();

		inventory.addAll(
				Arrays.asList(new Apple(80, Color.GREEEN), new Apple(155, Color.GREEEN), new Apple(120, Color.RED)));
		
		// 1
		// [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
		inventory.sort(new AppleComparator());
		System.out.println(inventory);
		
		// reshuffling things a little
		inventory.set(1, new Apple(30,Color.GREEEN));
		
		// 2
		// [Apple{color=GREEN, weight=30}, Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
		inventory.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple a1, Apple a2) {
				// TODO Auto-generated method stub
				return a1.getWeight() - a2.getWeight();
			}
		});
		System.out.println(inventory);
		
		//reshuffling things a little
		inventory.set(1, new Apple(20,Color.RED));
		
		// 3
		// [Apple{color=RED, weight=20}, Apple{color=GREEN, weight=30}, Apple{color=GREEN, weight=155}]
		inventory.sort((a1,a2) -> a1.getWeight() - a2.getWeight());
		System.out.println(inventory);
		
		// reshuffling things a little
		inventory.set(1, new Apple(10, Color.RED));
		
		// 4
		// [Apple{color=RED, weight=10}, Apple{color=RED, weight=20}, Apple{color=GREEN, weight=155}]
		inventory.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(inventory);
		
		// 5 reverse sort
		inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
		System.out.println(inventory);
	}
	
	static class AppleComparator implements Comparator<Apple>  {

		@Override
		public int compare(Apple a1, Apple a2) {
			// TODO Auto-generated method stub
			return a1.getWeight() - a2.getWeight();
		}
		
	}
}
