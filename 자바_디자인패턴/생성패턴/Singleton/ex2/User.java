package 자바_디자인패턴.생성패턴.Singleton.ex2;

public class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public void print() {
//		Printer printer = Printer.getPrinter();
		Printer printer = Printer.Instance;

		printer.print(this.name);
	}
}
