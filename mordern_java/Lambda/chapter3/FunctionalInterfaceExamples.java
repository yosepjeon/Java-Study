package mordern_java.Lambda.chapter3;

import java.math.BigDecimal;

public class FunctionalInterfaceExamples {
	public static void main(String[] args) {
		//(i1 + i2 + i3) -> 여기에서 '+'가 들어가는 순간 자동으로 Auto Unboxing이 일어나면서 primitive int가 되기 때문에 String.valueOf()로 변환
		println(1,2,3,(i1,i2,i3) -> String.valueOf(i1+i2+i3));
		println("Area is ",12,20, (message,height,width) -> String.valueOf((message + (width * height)))); // Area is 240
		println(1L,"JYS", "email.test.com",(id,name,email) -> "User info: ID=" + id + ", NAME=" + name +", EMAIL=" + email); //User info: ID=1, NAME=JYS, EMAIL=email.test.com
	
		BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
		System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
		
		final InvalidFunctionalInterface validFunctionalInterface = new InvalidFunctionalInterface() {

			@Override
			public <T> String makeString(T value) {
				// TODO Auto-generated method stub
				return value.toString();
			}
			
		};
		
		System.out.println("anonymous class: " + validFunctionalInterface.makeString(123)); // 123 제대로 출력된다.
		
		
		// final InvalidFunctionalInterface invalidFunctionalInterface = value -> value.toString(); // Target이 되는 메서드가 Generic이라 안된다라고 
		// System.out.println(invalidFunctionalInterface.makeString(123));
	}

	private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
		System.out.println(function.apply(t1, t2, t3));
	}
}

@FunctionalInterface
// T1, T2, T3 타입은 사용할 때(호출할 때) 추론이 된다.
interface Function3<T1, T2, T3, R> { // 파라미터 3개를 받아서 연산 후 R을 리턴함
	R apply(T1 t1, T2 t2, T3 t3); // Abstract Method가 하나만 있으면 이름이 apply든 apply2든 상관 없다.
	
//	void print(int i);
}

@FunctionalInterface
// 타입이 명확할 때는 T 타입을 넣을 필요가 없다.
interface BigDecimalToCurrency {
	String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalInterface {
	// Function Interface의 제약사항 -> Function Interface에 있는 메서드가 Generic 메서드면 사용할 수 없다.
	<T> String makeString(T value); // Error 사용 못함!!
}
