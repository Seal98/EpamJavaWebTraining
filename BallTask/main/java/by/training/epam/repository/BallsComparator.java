package by.training.epam.repository;

import java.util.Comparator;

import by.training.epam.entity.RoundFigure;

public interface BallsComparator extends Comparator<RoundFigure>{
	
	public int compare(RoundFigure figure1, RoundFigure figure2);
	
}
