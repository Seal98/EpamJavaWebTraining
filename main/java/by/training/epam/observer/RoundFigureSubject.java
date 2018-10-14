package by.training.epam.observer;

import by.training.epam.entity.RoundFigure;

public interface RoundFigureSubject {
	
	void addObserver(RoundFigureObserver newObserver);
	
	void removeObserver(RoundFigureObserver observer);
	
	void notifyObservers(RoundFigure updatedFigure);
	
}
