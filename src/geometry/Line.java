package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;

	public Line(Point startPoint, Point endPoint, boolean b, Color color) {
		super(color);
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public Line(Point startPoint, Point endPoint,Color edgeColor) {
		super(edgeColor);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return this.startPoint.distance(x, y) + this.endPoint.distance(x, y) - length() <= 2;
	}

@Override
	public boolean contains(Point clickPoint) {
	System.out.println("hehehe");
		return this.startPoint.distance(clickPoint.getX(), clickPoint.getY())
				+ this.endPoint.distance(clickPoint.getX(), clickPoint.getY()) - length() <= 2;
	}
	
	@Override
	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Line) {
			Line shapeToCompare = (Line) obj;
			return (int) (this.length() - shapeToCompare.length());
		}
		return 0;
	}

	public Point getStartPoint() {
		return this.startPoint; 
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public double length() {
		return startPoint.distance(endPoint.getX(), getEndPoint().getY());
	}

	public String toString() {
		return startPoint + "-- >" + endPoint;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getEdgeColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
			g.setColor(Color.black);
		}
	}

}
