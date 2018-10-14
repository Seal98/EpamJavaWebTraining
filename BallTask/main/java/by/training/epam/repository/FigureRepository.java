package by.training.epam.repository;

import java.util.List;

import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.FigureAlreadyExistException;

public interface FigureRepository {
	
	public void addFigure(RoundFigure newFigure) throws FigureAlreadyExistException;
	
	public void removeFigure(RoundFigure figure);
	
	public void updateFigure(RoundFigure figure);
	
	public List<RoundFigure> getFigures();
}
