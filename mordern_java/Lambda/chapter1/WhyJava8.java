package mordern_java.Lambda.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhyJava8 {
	public static void main(String[] args) {
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 기존
		final StringBuilder stringBuilder = new StringBuilder();
//		for (Integer number : numbers) {
//			stringBuilder.append(number).append(" : ");
//		}

		// 1 : 2 : 3 : 4 : 5 : 6 : 7 : 8 : 9 : 10 :
		// 마지막에 : 이 하나 더 붙네.. 이걸 어떻게 없앨까
//		final int size = numbers.size();
//		for (int i = 0; i < size; i++) {
//			stringBuilder.append(numbers.get(i));
//			if (i != size - 1)
//				stringBuilder.append(" : ");
//		}
		
		// 잘 나왔네 그런데 꼭 이렇게 짜야만 할까? 실수할 여지도 많고...
		// 다시 foreach를 이용해볼까?
		for (Integer number : numbers) {
			stringBuilder.append(number).append(" : ");
		}
		
		if(stringBuilder.length() > 0) {
			// start가 어디부터 지우기를 시작하면 될까...
			// end는 stringBuilder.length()-1인가 아니면 그냥 stringBuilder.length()일까? API 참조해볼까 귀찮네...
			stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
		}
		
		// 잘 나오긴 하는데 length도 확인해봐야하고 헷갈리는 부분이 있어서 API도 참조해봐야 하고... 이것도 별로네...
		System.out.println(stringBuilder.toString());
		
		// JAVA8 기능을 써볼까?
		// 뒤에 더 공부하면서 자세하게 알게되겠지만 이 기능으로 인해 병렬 프로그래밍이 편해짐!!!
		final String result = numbers.stream()
				.map(String::valueOf) // String의 valueOf를 호출해서 numbers의 값을 인자로 넣어 변환 -> String.valueOf(number)
				.collect(Collectors.joining(" : "));
		
		// 코드가 3줄로 읽기 쉽게 끝나고 간단하네! 실수할 부분도 없고!
		System.out.println(result);
	}
}
