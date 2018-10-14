package by.training.epam.repository;

import by.training.epam.entity.RoundFigure;

public class BallsIdComparator implements BallsComparator {

	@Override
	public int compare(RoundFigure figure1, RoundFigure figure2) {
		return figure1.getBallId() == figure2.getBallId() ? 0 : figure1.getBallId() < figure2.getBallId() ? -1 : 1;
	}

}
