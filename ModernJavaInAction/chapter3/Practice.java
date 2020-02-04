package ModernJavaInAction.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Practice {
	public static void main(String[] args) {
		List<Integer> list = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());

		int num = 1;
		list.forEach(element -> {
			System.out.println(num);
		});
		
		List<Element> list2 = new ArrayList<>();
		for(int i=1;i<=3;i++) {
			list2.add(new Element(i));
		}
		
		list2.forEach((element)-> {
			System.out.print(element.num + " ");
			element.num++;
		});
		
		System.out.println();
		
		list2.forEach((element)-> {
			System.out.print(element.num + " ");
		});
		
		// 퀴즈 3-6 메서드 참조
//		ToIntFunction<String> stringToInt = Integer::parseInt;
//		BiPredicate<List<String>, String> contains = List::contains;
//		Predicate<String> startsWithNumber = this::startsWithNumber;
	}

	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();

		for (T t : list) {
			result.add(f.apply(t));
		}

		return result;
	}
}

class Element {
	int num;
	
	public Element(int num) {
		this.num = num;
	}
}

@FunctionalInterface
interface FunctionPractice1<T, R> {
	R apply(T t);
}

@FunctionalInterface
interface FunctionPractice2<T1, T2, R> {
	R apply(T1 t1, T2 t2);
}
