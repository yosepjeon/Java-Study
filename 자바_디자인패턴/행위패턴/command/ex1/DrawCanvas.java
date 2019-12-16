package 자바_디자인패턴.행위패턴.command.ex1;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable{
	// 그림 그리는 색
	private Color color = Color.red;
	
	// 그림 그리는 점의 반경
	private int radius = 6;
	
	// 이력
	private MacroCommand history;
	
	// 생성자
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width,height);
		setBackground(Color.WHITE);
		this.history = history;
	}
	
	/*
	 * paint 메서드는 DrawCanvas를 다시 그릴 필요가 생겼을 때 Java 처리계(java.awt의 프레임워크)로부터 호출되는 메소드이다.
	 * 실행하는 처리는 history.execute를 호출하는 것 뿐이다.
	 * 이것만으로 history에 기록되어 있는 명령의 집합이 재실행된다.
	*/
	public void paint(Graphics g) {
		history.execute();
	}

	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}
