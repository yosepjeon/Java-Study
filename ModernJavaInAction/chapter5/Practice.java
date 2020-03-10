package ModernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1번
		List<Transaction> result1 = transactions.stream().filter((t) -> t.getYear() == 2011)
				.sorted((t1, t2) -> t1.getValue() - t2.getValue()).collect(Collectors.toList());
		System.out.println(result1);

		// 2번
		List<String> result2 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		System.out.println(result2);

		// 3번
		// List<Transaction> result3 = transactions.stream().filter(t ->
		// t.getTrader().getCity().equals("Cambridge")).sorted((t1,t2) ->
		// t1.getTrader().getName().compareTo(t2.getTrader().getName())).collect(Collectors.toList());
		List<Trader> result3 = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).distinct().collect(Collectors.toList());
		System.out.println(result3);
		
		// 4번
		List<Trader> result4 = transactions.stream().map(Transaction::getTrader).sorted((t1,t2) -> t1.getName().compareTo(t2.getName())).collect(Collectors.toList());
		System.out.println(result4);
		
		// 5번
		boolean isTraderFromMilano = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equals("Milan"));
		System.out.println(isTraderFromMilano);
		
		// 6번
		List<Transaction> result5 = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).collect(Collectors.toList());
		//		System.out.println(result5);
		
		// 7번
		Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce((v1,v2) -> v1 > v2?v1:v2);
		max.ifPresent(System.out::println);
		
		// 8번
		Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		min.ifPresent(System.out::println);
	}
}
