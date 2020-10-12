package ModernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice2 {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
		List<Transaction> answer1 = transactions.stream().filter(t -> {
			return t.getYear() == 2011;
		}).sorted((Transaction t1, Transaction t2) -> {
			return t1.getValue() - t2.getValue();
		}).collect(Collectors.toList());
		System.out.print("answer1: ");
		System.out.println(answer1);

		// 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
		List<String> answer2 = transactions.stream().map(t -> t.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		System.out.print("answer2: ");
		System.out.println(answer2);

		// 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
		List<Trader> answer3 = transactions.stream().map(t -> t.getTrader()).filter(t -> t.getCity().equals("Cambridge")).collect(Collectors.toList());
		System.out.print("answer3: ");
		System.out.println(answer3);
		
		// 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
		List<String> answer4 = transactions.stream().map(t -> t.getTrader().getName()).collect(Collectors.toList());
		System.out.print("answer4: ");
		System.out.println(answer4);
		
		// 5. 밀라노에 거래자가 있는가?
		Boolean answer5 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.print("answer5: ");
		System.out.println(answer5);
		
		// 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
		List<Transaction> answer6 = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).collect(Collectors.toList());
		System.out.print("answer6");
		System.out.println(answer6);
		
		// 7. 전체 트랜잭션 중 최댓값은 얼마인가?
		Optional<Integer> answer7 = transactions.stream().map(t -> t.getValue()).reduce((t1,t2) -> Integer.max(t1, t2));
		System.out.print("answer7: ");
		System.out.println(answer7);
		
		// 8. 전체 트랜잭션 중 최솟값은 얼마인가?
		Optional<Integer> answer8 = transactions.stream().map(t -> t.getValue()).reduce((t1,t2) -> Integer.min(t1, t2));
		System.out.print("answer8: ");
		System.out.println(answer8);
	}
}
