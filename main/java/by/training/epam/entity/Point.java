package by.training.epam.entity;

import java.io.Serializable;

public class Point implements Serializable {
	
	private static final long serialVersionUID = -7570758214921268502L;
	private double pointX;
	private double pointY;
	private double pointZ;

	public Point() {
	}

	public Point(double pointX, double pointY, double pointZ) {
		this.pointX = pointX;
		this.pointY = pointY;
		this.pointZ = pointZ;
	}

	public void setX(double x) {
		this.pointX = x;
	}

	public void setY(double y) {
		this.pointY = y;
	}

	public void setZ(double z) {
		this.pointZ = z;
	}

	public void setDot(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	public double getX() {
		return pointX;
	}

	public double getY() {
		return pointY;
	}

	public double getZ() {
		return pointZ;
	}

	public Point getDeepCopy() {
		return new Point(pointX, pointY, pointZ);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		if (((Point) o).hashCode() != this.hashCode()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return ((int) pointX << 4 + (int) pointY << 2 + (int) pointZ << 3) + (int) (pointX + pointZ + pointY) * 7;
	}

	@Override
	public String toString() {
		return "(x = " + pointX + ", y = " + pointY + ", z = " + pointZ + ")";
	}
}
