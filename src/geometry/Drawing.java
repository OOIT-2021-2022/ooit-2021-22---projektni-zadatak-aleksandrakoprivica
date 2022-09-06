package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{
	public Drawing() {
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		JPanel drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		Point p = new Point(10,15);
		p.draw(g);
		g.setColor(Color.red);
		Line line = new Line(new Point(20,30), new Point(40,50));
		line.draw(g);
		g.setColor(Color.black);
		Donut donut = new Donut (new Point(60,70), 50, 40, true);
		donut.draw(g);
	}
}