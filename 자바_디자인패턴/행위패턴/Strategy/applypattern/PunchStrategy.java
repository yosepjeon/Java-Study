package 자바_디자인패턴.행위패턴.Strategy.applypattern;

public class PunchStrategy implements AttackStrategy{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("I have strong punch.");
	}

}
