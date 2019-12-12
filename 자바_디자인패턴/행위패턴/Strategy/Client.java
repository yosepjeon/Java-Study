package 자바_디자인패턴.행위패턴.Strategy;

import 자바_디자인패턴.행위패턴.Strategy.applypattern.Atom;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.FlyingStrategy;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.MissileStrategy;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.PunchStrategy;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.Robot;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.TaekwonV;
import 자바_디자인패턴.행위패턴.Strategy.applypattern.WalkingStrategy;

public class Client {
	public static void main(String[] args ){
		Robot taekwonV = new TaekwonV("TaekwonV");
		  Robot atom = new Atom("Atom");

		  /* 수정된 부분: 전략 변경 방법 */
		  taekwonV.setMovingStrategy(new WalkingStrategy());
		  taekwonV.setAttackStrategy(new MissileStrategy());
		  atom.setMovingStrategy(new FlyingStrategy());
		  atom.setAttackStrategy(new PunchStrategy());

		  /* 아래부터는 동일 */
		  System.out.println("My name is " + taekwonV.getName());
		  taekwonV.move();
		  taekwonV.attack();

		  System.out.println();
		  System.out.println("My name is " + atom.getName());
		  atom.move();
		  atom.attack();
	}
}

/*
 * Legacy Client public class Client { public static void main(String[] args) {
 * Robot taekwonV = new TaekwonV("TaekwonV"); Robot atom = new Atom("Atom");
 * 
 * System.out.println("My name is " + taekwonV.getName()); taekwonV.move();
 * taekwonV.attack();
 * 
 * System.out.println();
 * 
 * System.out.println("My name is " + atom.getName()); atom.move();
 * atom.attack(); } }
 */
