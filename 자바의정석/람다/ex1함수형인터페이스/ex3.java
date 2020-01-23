package 자바의정석.람다.ex1함수형인터페이스;

public class ex3 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		
		inner.method(100);
	}
}

@FunctionalInterface
interface MyFunction4 {
	void myMethod();
}

class Outer {
	int val = 10;
	
	class Inner {
		int val = 20;
		
		void method(int i) {
			int val = 30;
//			i = 10;
			
			MyFunction4 f = () -> {
				System.out.println("             i:" + i);
				System.out.println("           val:" + val);
				System.out.println("      this.val:" + ++this.val);
				System.out.println("Outer.this.val:" + ++ Outer.this.val);
			};
			
			f.myMethod();
		}
	}
}
