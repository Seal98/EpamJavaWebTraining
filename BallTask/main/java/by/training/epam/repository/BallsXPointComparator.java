package by.training.epam.repository;

import by.training.epam.entity.RoundFigure;

public class BallsXPointComparator implements BallsComparator {

	@Override
	public int compare(RoundFigure figure1, RoundFigure figure2) {
		double figure1XPoint = figure1.getPoint().getX();
		double figure2XPoint = figure2.getPoint().getX();
		return figure1XPoint == figure2XPoint ? 0 : figure1XPoint < figure2XPoint ? -1 : 1;
	}

}