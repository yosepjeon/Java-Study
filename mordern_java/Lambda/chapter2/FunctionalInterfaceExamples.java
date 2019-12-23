package mordern_java.Lambda.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples {
	public static void main(String[] args) {
		Function<String, Integer> toInt = (value) -> Integer.valueOf(value);

		final Integer number = toInt.apply("100");
		System.out.println(number);

		// final Function<Integer, Integer> identity = Function.identity();
		final Function<Integer, Integer> identity = (value) -> value;
		System.out.println(identity.apply(100));

		// Consumer<String> print = new Consumer<String>() {
		//
		// @Override
		// public void accept(String value) {
		// // TODO Auto-generated method stub
		// System.out.println(value);
		// }
		// };
		//
		// print.accept("Hello World");
		Consumer<String> print = value -> System.out.println(value);
		// Function<String, Void> print2 = value -> System.out.println(value);
		print.accept("Hello World");

		Predicate<Integer> isPositive = value -> value > 0;

		System.out.println(isPositive.test(1)); // true
		System.out.println(isPositive.test(0)); // false
		System.out.println(isPositive.test(-1));// false

		List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
		List<Integer> positiveNumbers = new ArrayList<Integer>();
		//
		// for(Integer num : numbers) {
		// if(isPositive.test(num)) {
		// positiveNumbers.add(num);
		// }
		// }
		//
		// System.out.println(positiveNumbers);
		//
		// Predicate<Integer> isNegative = value -> value < 0;
		//
		// List<Integer> negativeNumbers = new ArrayList<Integer>();
		//
		// for(Integer num : numbers) {
		// if(isNegative.test(num)) {
		// negativeNumbers.add(num);
		// }
		// }
		//
		// System.out.println(negativeNumbers); // [-1,-2,-3,-4,-5]

		System.out.println(filter(numbers, isPositive));
		System.out.println(filter(numbers, value -> value < 0));

		Supplier<String> helloSupplier = () -> "Hello";
		System.out.println(helloSupplier.get() + " World");

//		printIfValidIndex(1, () -> getVeryExpensiveValue());
		long start = System.currentTimeMillis();
		// 자바 8 이전이었다면... 복잡하고.. 쓰기 귀찮고..
//		printIfValidIndex(1, new Supplier<String>() {
//
//			@Override
//			public String get() {
//				// TODO Auto-generated method stub
//				return getVeryExpensiveValue();
//			}
//		});
		printIfValidIndex(1, () -> getVeryExpensiveValue());
		printIfValidIndex(-1, () -> getVeryExpensiveValue());
		System.out.println((System.currentTimeMillis() - start) / 1000 + "초 걸렸습니다.");
	}

	// 이 값을 얻기까지 엄청난 연산이 필요하다는 것을 의미
	private static String getVeryExpensiveValue() {
		// 이 연산을 수행하기까지 3초나 걸린다고 가정하기 위해 넣은 코드
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Yoggaebi";
	}

	// private static void printIfValidIndex(int number, String value) {
	private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
		if (number >= 0) {
			System.out.println("The value is " + valueSupplier.get() + ".");
		} else {
			System.out.println("Invalid");
		}
	}

	private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
		List<T> result = new ArrayList();

		for (T input : list) {
			if (filter.test(input))
				result.add(input);
		}

		return result;
	}
}
