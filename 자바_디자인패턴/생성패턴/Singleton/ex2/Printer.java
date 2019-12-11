package 자바_디자인패턴.생성패턴.Singleton.ex2;

// Race condition으로 인한 문제점을 가지고 있다.

//public class Printer {
//	// 외부에 제공할 자기 자신의 인스턴스
//	private static Printer printer = null;
//	private Printer() {
//		
//	}
//	
//	// 자기 자신의 인스턴스를 외부에 제공
//	public static Printer getPrinter() {
//		if(printer == null) {
//			// Printer 인스턴스 생성
//			printer = new Printer();
//		}
//		
//		return printer;
//	}
//	
//	public void print(String str) {
//		System.out.println(str);
//	}
//}



// 해결책 1: Eager Initialization

//public class Printer {
//	// static 변수에 외부에 제공할 자기 자신의 인스턴스를 만들어 초기화
//	private static Printer printer = new Printer();
//
//	private Printer() {
//	}
//	
//	// 자기 자신의 인스턴스를 외부에 제공
//	public static Printer getPrinter() {
//		return printer;
//	}
//	
//	public void print(String str) {
//		System.out.println(str);
//	}
//}

// 해결책 2: Thread-Safe Initialization
//public class Printer {
//	// 외부에 제공할 자기 자신의 인스턴스
//	private static Printer printer = null;
//	private int counter = 0;
//	private Printer() {
//		
//	}
//	
//	// 인스턴스를 만드는 메서드 동기화 (임계 구역)
//	public synchronized static Printer getPrinter() {
//		if(printer == null) {
//			printer = new Printer();
//		}
//		
//		return printer;
//	}
//	
//	public void print(String str) {
//		// 오직 하나의 스레드만 접근을 허용함 (임계 구역)
//		// 성능을 위해 필요한 부분만을 임계 구역으로 설정한다.
//		synchronized (this) {
//			counter++;
//			System.out.println("userID=" + str + " : count Of Calling Singleton="+ counter);
//		}
//	}
//}

// 해결책 3: Enum
public enum Printer {
	Instance;

	public void print(String str) {
		System.out.println(str);
	}
}


