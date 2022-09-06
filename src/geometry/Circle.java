package geometry;

import java.awt.Graphics;

public class Circle extends Shape{
	protected Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if (this.center.equals(pomocni.center) && this.radius == pomocni.radius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point clickPoint) {
		return center.distance(clickPoint.getX(), clickPoint.getY()) <= radius;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);		
	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle circleToCompare = (Circle)obj;
			return (int)(this.area() - circleToCompare.area());
		}			
		return 0;
	}
	
	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius
		return "Center=" + center + ", radius=" + radius;
	}

}
