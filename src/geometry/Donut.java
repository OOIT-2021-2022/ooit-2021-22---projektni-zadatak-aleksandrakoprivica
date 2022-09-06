package geometry;

import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		/*
		 * this.center = center; // moze jer je protected // this.radius = radius; jer
		 * je private this.setRadius(radius); this.setSelected(selected);
		 * this.innerRadius = innerRadius;
		 */

		// drugi nacin
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			/*
			 * if (this.center.equals(pomocni.center) && this.getRadius() ==
			 * pomocni.getRadius() && this.innerRadius == pomocni.innerRadius) { return
			 * true; } else { return false; }
			 */
			if (super.equals(pomocni) && this.innerRadius == pomocni.innerRadius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return  super.contains(x, y) && center.distance(x, y) >= innerRadius;
	}
	
	public boolean contains(Point clickPoint) {
		return  super.contains(clickPoint) && center.distance(clickPoint.getX(), clickPoint.getY()) >= innerRadius;
	}
	
	public double area() {
		return  super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius,
				innerRadius*2, innerRadius*2);
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			Donut donutToCompare = (Donut)obj;
			return (int)(this.area() - donutToCompare.area());
		}			
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius, innerRadius=innerRadius
		return super.toString() + ", innerRadius=" + innerRadius;
	}

}