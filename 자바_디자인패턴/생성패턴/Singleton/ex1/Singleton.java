package 자바_디자인패턴.생성패턴.Singleton.ex1;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
