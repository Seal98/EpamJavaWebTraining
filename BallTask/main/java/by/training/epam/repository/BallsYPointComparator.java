package by.training.epam.repository;

import by.training.epam.entity.RoundFigure;

public class BallsYPointComparator implements BallsComparator {

	@Override
	public int compare(RoundFigure figure1, RoundFigure figure2) {
		double figure1YPoint = figure1.getPoint().getY();
		double figure2YPoint = figure2.getPoint().getY();
		return figure1YPoint == figure2YPoint ? 0 : figure1YPoint < figure2YPoint ? -1 : 1;
	}

}