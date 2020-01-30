package ModernJavaInAction.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
	private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();
	
	public static void main(String[] args ) throws IOException {
		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);
		
		String twoLine = processFile((BufferedReader b) -> b.readLine() + " " + b.readLine());
		System.out.println(twoLine);
	}
	
	public static String processFileLimited() throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			return br.readLine();
		}
	}
	
	public static String processFile(BufferedReaderProcessor bp) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			return bp.process(br);
		}
	}
	
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}
}
