package 자바_디자인패턴.행위패턴.Strategy.applypattern;

public class FlyingStrategy implements MovingStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can fly.");
	}
	
}
