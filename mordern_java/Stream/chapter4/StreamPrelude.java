package mordern_java.Stream.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
	public static void main(String[] args) {
		final int abs1 = Math.abs(-1);
		final int abs2 = Math.abs(1);

		System.out.println("abs1: " + abs1);
		System.out.println("abs2: " + abs2);
		System.out.println("abs1 == abs2 is " + (abs1 == abs2));

		final int minInt = Math.abs(Integer.MIN_VALUE);
		System.out.println("minInt: " + minInt);

		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(mapOld(numbers, i -> i * 2));
		// 만약 아무것도 하고 싶지 않을때?
		// null pointer exception이 발생하므로 map 메서드를 수정하자.
		// [] 리스트가 반환됨...
		System.out.println("mapOld(numbers, null)");
		System.out.println(mapOld(numbers, null));
		
		System.out.println("");
		System.out.println("map(numbers, i->i*2)");
		System.out.println(map(numbers,i->i*2));
		
		System.out.println("");
		System.out.println("map(numbers, i->i)");
		System.out.println(map(numbers,i->i));
		
		System.out.println("");
		System.out.println("map(numbers, Function.identity()");
		System.out.println(map(numbers,Function.identity()));
	}

	private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper) {
//		final Function<T, R> function;
//		if (mapper != null) {
//			function = mapper;
//		} else {
//			function = x -> (R) x;
//		}

		final List<R> result = new ArrayList<>();
		for (final T t : list) {
			result.add(mapper.apply(t));
		}

		return result;
	}

	private static <T, R> List<R> mapOld(List<T> list, Function<T, R> mapper) {
		final List<R> result;

		if (mapper != null) {
			result = new ArrayList<>();
		} else {
			result = new ArrayList<>((List<R>) list);
		}

		if (result.isEmpty()) { // 이게 무슨 의미지?
			for (final T t : list) {
				result.add(mapper.apply(t));
			}
		}
		// 코드를 이해하기도 어렵고 유지보수하기도 어려움...

		return result;
	}
}
