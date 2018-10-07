package by.training.epam.entity;

import by.training.epam.entity.impl.Point;

public interface RoundFigure {
	
	void setRadius(double radius);
	
	double getRadius();
	
	Point getPoint();
	
	void setPoint(Point point);
	
	RoundFigure getDeepCopy();
}
