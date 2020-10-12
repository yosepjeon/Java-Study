package 자바_디자인패턴.행위패턴.command.ex2.legacy;

public class Button {
	private Alarm theAlarm;
	public Button(Alarm theAlarm) {
		this.theAlarm = theAlarm;
	}
	
	public void pressed() {
		theAlarm.start();
	}
}
