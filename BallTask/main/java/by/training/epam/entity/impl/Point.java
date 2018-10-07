package by.training.epam.entity.impl;

import java.io.Serializable;

public class Point implements Serializable {
	
	private static final long serialVersionUID = -7570758214921268502L;
	private double x;
	private double y;
	private double z;

	public Point() {
	}

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setDot(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Point getDeepCopy() {
		return new Point(x, y, z);
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
		return ((int) x << 4 + (int) y << 2 + (int) z << 3) + (int) (x + z + y) * 7;
	}

	@Override
	public String toString() {
		return "(x = " + x + ", y = " + y + ", z = " + z + ")";
	}
}
