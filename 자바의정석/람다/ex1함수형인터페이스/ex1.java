package 자바의정석.람다.ex1함수형인터페이스;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ex1 {
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("a","b","c","d","e");
		List<Integer> intList = Arrays.asList(3,1,4,2,5);
		
		Collections.sort(stringList, (a,b) -> b.compareTo(a));
		Collections.sort(intList, (a,b) -> a-b);
		
		stringList.forEach(element -> System.out.println(element));
		intList.forEach(element -> System.out.println(element));
		
		int a = 0;
		Integer[] arr = {1,2,3};
		method1(() -> System.out.println("call method1()"));
		
		PrintArray<Integer> printArray = (array) -> {
			for(Integer element : array) {
				System.out.println(element);
			}
		};
		
		printForEach(arr, (array) -> {
			for(Integer element : array) {
				System.out.println(element);
			}
		});
		printArray.print(arr);
	}

	static void method1(MyFunction1<?> f) {
		f.method();
	}
	
	static <T> void printForEach(T[] t,PrintArray<T> f) {
		f.print(t);
	}
}

@FunctionalInterface
interface PrintArray<T> {
	void print(T[] t);
}

@FunctionalInterface
interface MyFunction1<T> {
	void method();
}

@FunctionalInterface
interface MyFunction2<T> {
	void method(T[] ar);
}

