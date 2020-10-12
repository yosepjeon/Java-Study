package 자바_디자인패턴.행위패턴.command.ex2.legacy;

public class Client {
	public static void main(String[] args) {
		Alarm alarm = new Alarm();
		Button alarmButton = new Button(alarm);
		alarmButton.pressed();
	}
}
