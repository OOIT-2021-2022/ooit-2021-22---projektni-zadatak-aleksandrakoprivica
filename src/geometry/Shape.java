package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{
	protected boolean selected;
	private Color edgeColor;
	private Color innerColor;
	private Color color;

	
	public Shape() {

	}

	public Shape(boolean selected, Color edgeColor, Color innerColor) {
		super();
		this.selected = selected;
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
	}
	
	
	

	public Shape(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Shape( Color edgeColor, Color innerColor) {
		super();
		this.selected = false;
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
	}

	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(Point x);
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
