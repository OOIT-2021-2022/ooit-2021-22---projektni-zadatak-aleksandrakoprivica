package geometry;

import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		//this(startPoint, endPoint);
		//setSelected(selected);
		//drugi nacin
		super(selected);
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
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());		
	}
	
	@Override
	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);	
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Line) {
			Line lineToCompare = (Line)obj;
			return (int)(this.length() - lineToCompare.length());
		}			
		return 0;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public String toString() {
		return startPoint + "-- >" + endPoint;
	}

}
