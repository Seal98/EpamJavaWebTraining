package by.training.epam.repository;

import by.training.epam.entity.RoundFigure;

public class BallsZPointComparator implements BallsComparator {

	@Override
	public int compare(RoundFigure figure1, RoundFigure figure2) {
		double figure1ZPoint = figure1.getPoint().getZ();
		double figure2ZPoint = figure2.getPoint().getZ();
		return figure1ZPoint == figure2ZPoint ? 0 : figure1ZPoint < figure2ZPoint ? -1 : 1;
	}

}
