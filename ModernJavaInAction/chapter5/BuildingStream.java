package ModernJavaInAction.chapter5;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStream {
	public static void main(String[] args) throws IOException {
		// Stream.of
		Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		// Stream.empty
		Stream<String> emptyStream = Stream.empty();

		// file stream
		long uniqueWords = Files.lines(Paths.get("src/ModernJavaInAction/chapter5/data.txt"), Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		System.out.println("There are " + uniqueWords + " unique words in data.txt");
		
		// Stream.iterate
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
		
		// iterate를 이용한 피보나치
		Stream.iterate(new BigInteger[]{BigInteger.ZERO,BigInteger.ONE}, t -> {
			BigInteger temp;
			temp = t[0].add(t[1]);
			t[0] = t[1];
			t[1] = temp;
			return t;
		}).limit(300).map(t -> t[0]).forEach(System.out::println);
		
		//
	}
}
