package ModernJavaInAction.chapter5;

import java.util.stream.Stream;

public class Practice3 {
	public static void main(String[] args) {
		Stream.generate(Math::random)
			.limit(5)
			.forEach(n -> System.out.println(n));
			
	}
}
