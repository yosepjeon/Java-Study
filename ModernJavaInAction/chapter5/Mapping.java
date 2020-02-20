package ModernJavaInAction.chapter5;

import static ModernJavaInAction.chapter4.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ModernJavaInAction.chapter4.Dish;

public class Mapping {
	public static void main(String[] args) {
		// map
		List<String> dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());
		System.out.println(dishNames);

		// map
		// wordLengths
		List<String> words = Arrays.asList("Hello", "World");
		List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		System.out.println(wordLengths);
		
		// map
		// word
//		List<String[]> mappingStrings = words.stream()
//				.map(word -> word.split(""))
//				.distinct()
//				.collect(Collectors.toList());
//		mappingStrings.forEach(strings -> {
//			for(String s : strings) {
//				System.out.print(s);
//			}
//		});
		
		// flatMap
		// word
		words.stream()
		.flatMap((String line) -> Arrays.stream(line.split("")))
		.distinct()
		.forEach(System.out::println);
		
		// p5-2
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> sqrtNumbers = numbers.stream()
				.map(number -> number * number)
				.collect(Collectors.toList());
		
		sqrtNumbers.forEach(number -> System.out.print(number + " "));
		System.out.println();
		
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		
		List<int[]> pairNumbers = numbers1.stream()
			.flatMap(i -> numbers2.stream()
					.map(j -> new int[]{i,j}))
			.collect(Collectors.toList());
		
		pairNumbers.forEach(pairNumber -> {
			System.out.print("{ ");
			for(int number : pairNumber) {
				System.out.print(number + " ");
			}
			System.out.print("}");
		});
		System.out.println();
		
		List<int[]> filteredPairNumbers = pairNumbers.stream().filter(pairNumber -> {
			int total = 0;
			for(int i : pairNumber) {
				total += i;
			}
			
			return total%3 == 0;
		}).collect(Collectors.toList());
		
		filteredPairNumbers.forEach(fpn -> {
			System.out.print("{ ");
			for(int i : fpn) {
				System.out.print(i + " ");
			}
			System.out.print("}");
		});
		System.out.println();
	}
}
