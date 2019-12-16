package 자바_디자인패턴.행위패턴.command.ex1;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand {
	// 명령의 집합
	private Stack<Command> commands = new Stack();
	
	// 실행
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while(it.hasNext()) {
			it.next().execute();
			System.out.println("!");
		}
	}
	
	// 추가
	public void append(Command cmd) {
		if(cmd != this) {
			commands.push(cmd);
		}
	}
	
	// 마지막 명령을 삭제
	public void undo() {
		if(!commands.empty()) {
			commands.pop();
		}
	}
	
	// 전부 삭제
	public void clear() {
		commands.clear();
	}
}
