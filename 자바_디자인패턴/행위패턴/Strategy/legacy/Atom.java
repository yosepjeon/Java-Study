package 자바_디자인패턴.행위패턴.Strategy.legacy;

public class Atom extends Robot{
	public Atom(String name) {
		super(name);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("I have strong punch.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("I can fly.");
	}
}
