package ModernJavaInAction.chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ModernJavaInAction.chapter2.FilteringApples.Apple;
import ModernJavaInAction.chapter2.FilteringApples.Color;

public class Example {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN),
				new Apple(120, Color.RED));
		
		// Comparator 
		inventory.sort((apple1,apple2) -> apple1.getWeight() - apple2.getWeight());
		System.out.println(inventory);
		
		// Thread
		Thread t= new Thread(() -> System.out.println("Hello world"));
		t.run();
		
		// GUI Event
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());
		
		System.out.println(threadName);
	}
}
