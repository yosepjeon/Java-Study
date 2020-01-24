package 자바의정석.람다.ex1함수형인터페이스;

import java.io.File;
import java.io.FileFilter;

// 람다식의 타입과 형변환
public class ex2 {
	public static void main(String[] args) {
		File[] hiddenFiles = new File(".").listFiles((f) -> f.isHidden());
	}
}

@FunctionalInterface
interface MyFunction3 {
	void myMethod();
}
