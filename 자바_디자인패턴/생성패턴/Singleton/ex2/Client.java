package 자바_디자인패턴.생성패턴.Singleton.ex2;

public class Client {
	private static final int USER_NUM = 5;
	
	public static void main(String[] args ) {
		User[] user = new User[USER_NUM];
		
		for(int i=0;i<USER_NUM;i++) {
			user[i] = new User(String.valueOf(i+1));
			user[i].print();
		}
		
		
		for(int i=0;i<USER_NUM;i++) {
			user[i] = new User(String.valueOf(i+1));
			user[i].print();
		}
	}
}
