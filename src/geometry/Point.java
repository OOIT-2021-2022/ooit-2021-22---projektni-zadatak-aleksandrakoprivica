package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Point (int x, int y, Color color){
		this(x, y);
		this.setColor(color);
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x_coord) throws IllegalArgumentException {
		if (x_coord < 0) {
			throw new IllegalArgumentException("Value cannot be negative!");
		}
		this.x = x_coord;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y_coord) throws IllegalArgumentException {
		if (y_coord < 0) {
			throw new IllegalArgumentException("Value cannot be negative!");
		}
		this.y = y_coord;
	}

	public double distance(int x2, int y2) {
		double dx = x2 - this.x;
		double dy = y2 - this.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point)obj;
			if(this.x == p.x && this.y == p.y) {
				return true;
			}else{
				return false;
			}			
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public boolean contains(Point p) {
		return this.distance(p.getX(), p.getY()) <= 2;
	}
	
	public String toString() {
		return "("+ this.x+","+this.y+ ")";
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.x, this.y, this.x, this.y);
		if(this.selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.BLACK);
		}
	}
	
	public void moveBy(int x, int y) {
		this.x = this.x + x;
		this.y += y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			double d1 = this.distance(0, 0);
			double d2 = ((Point)obj).distance(0, 0);
			return (int)(d1 - d2);
		}else {
			return 0;
		}
	}
}
