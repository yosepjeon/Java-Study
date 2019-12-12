package 자바_디자인패턴.행위패턴.Strategy.legacy;

public abstract class Robot {
	private String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void attack();
	public abstract void move();
}
