package ModernJavaInAction.chapter3;

public class Lambdas {
	public static void main(String[] args ) {
		process(() -> System.out.println("Hello!"));
	}
	
	public static void process(Runnable r) {
		r.run();
	}
}
