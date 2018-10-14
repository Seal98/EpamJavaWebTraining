package by.training.epam.entity;

public interface RoundFigure {

	void setRadius(double radius);

	double getRadius();

	Point getPoint();

	void setPoint(Point point);

	RoundFigure getDeepCopy();

	int getBallId();

	boolean equals(Object o);

	void setBallId(int ballId);
}
