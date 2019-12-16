package 자바_디자인패턴.행위패턴.command.ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
	// 그림 그린 이력
	private MacroCommand history = new MacroCommand();

	// 그림 그리는 영역
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);

	// 제거 버튼
	private JButton clearButton = new JButton("clear");

	// 생성자
	public Main(String title) {
		super(title);

		this.addWindowListener(this);
		canvas.addMouseMotionListener(this);
		clearButton.addActionListener(this);

		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);

		pack();
		setVisible(true);
	}

	// ActionListener용
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
	}

	// MouseMotionListener용
	public void mouseMoved(MouseEvent e) {

	}

	// WindowListener용
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Command cmd = new DrawCommand(canvas, e.getPoint());
		history.append(cmd);
		cmd.execute();
	}

	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}
