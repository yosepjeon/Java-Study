package ModernJavaInAction.chapter3;

import java.util.function.Function;

public class Practice2 {
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		// Function<Integer, Integer> h = f.andThen(g); //f를 수행한 다음 g를 수행
		// g(f(x))
		Function<Integer, Integer> h = f.compose(g); // g를 수행한 다음 f를 수행 f(g(x))

		int result = h.apply(1);
		System.out.println(result);

		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
				.andThen(Letter::addFooter);
		Function<String, String> transformationHeaderAndFooterPipeline = addHeader.andThen(Letter::addFooter);

		String result2 = transformationPipeline.apply("labda");
		String result3 = transformationHeaderAndFooterPipeline.apply("labda");
		System.out.println(result2);
		System.out.println(result3);

	}
}

class Letter {
	public static String addHeader(String text) {
		return "From Raoul, Mario and Alan: " + text;
	}

	public static String addFooter(String text) {
		return text + " Kind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}
