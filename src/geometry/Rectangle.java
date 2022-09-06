package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape{
	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return upperLeftPoint.getX() <= x && upperLeftPoint.getX() + width >= x && upperLeftPoint.getY() <= y
				&& upperLeftPoint.getY() + height >= y;
	}
	
	public boolean contains(Point clickPoint) {
		return upperLeftPoint.getX() <= clickPoint.getX() && upperLeftPoint.getX() + width >= clickPoint.getX() && 
				upperLeftPoint.getY() <= clickPoint.getY()
				&& upperLeftPoint.getY() + height >= clickPoint.getY();
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * width + 2 * height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);		
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);		
	}

	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle rectangleToCompare = (Rectangle)obj;
			return (int)(this.area() - rectangleToCompare.area());
		}		
		return 0;
	}

	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "Upper left point:" + upperLeftPoint + ", width =" + width + ",height = " + height;
	}

}