package ModernJavaInAction.chapter5;

import java.io.IOException;
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

		//Stream.empty
		Stream<String> emptyStream = Stream.empty();
		
		//file stream
		long uniqueWords = Files.lines(Paths.get("src/ModernJavaInAction/chapter5/data.txt"), Charset.defaultCharset())
		        .flatMap(line -> Arrays.stream(line.split(" ")))
		        .distinct()
		        .count();
		System.out.println("There are " + uniqueWords + " unique words in data.txt");
		
		//
	}
}
