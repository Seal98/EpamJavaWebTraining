package by.training.epam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.training.epam.action.BallActionImpl;
import by.training.epam.observer.RoundFigureObserver;
import by.training.epam.observer.RoundFigureSubject;
import by.training.epam.repository.BallRepository;

public class Ball implements RoundFigure, Serializable{

	private static final long serialVersionUID = -3572863857732708793L;
	private int ballId;
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
	public RoundFigure getDeepCopy() {
		return new Ball(radius, point.getDeepCopy());
	}

	@Override
	public void setRadius(double radius) {
		this.radius = radius;
		BallRepository.getInstance().notifyObservers(this);
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public Point getPoint() {
		return point.getDeepCopy();
	}

	@Override
	public void setPoint(Point point) {
		this.point = point.getDeepCopy();
		BallRepository.getInstance().notifyObservers(this);
	}

	@Override
	public int getBallId() {
		return ballId;
	}

	@Override
	public void setBallId(int ballId) {
		this.ballId = ballId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}

		if (((Ball) o).hashCode() != this.hashCode()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return point.hashCode() << 2 + (int) radius << 3;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [ " + point + ", radius = " + radius + " ]";
	}

}
