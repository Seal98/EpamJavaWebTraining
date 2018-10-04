package by.training.epam.entity;

import java.io.Serializable;

public class Ball implements Serializable{
	private static final long serialVersionUID = -3572863857732708793L;
	private Point point;
	private double radius;
	
	public Ball() {
		point = new Point();
	}
	
	public Ball(double radius, Point point) {
		this.point = point;
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		
		if(((Ball)o).hashCode() != this.hashCode()) {
			return false;
		}
		return true;
	}
	
	public Ball getDeepCopy() {
		return new Ball(radius, point.getDeepCopy());
	}
	
	@Override
	public int hashCode() {
		return point.hashCode()*2 + (int)radius*3;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [ " + point + ", radius = " + radius + " ]";
	}
}
