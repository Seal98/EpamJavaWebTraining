package by.training.epam.reader;

import java.util.List;

import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.EmptyURIException;

public interface Reader {
	
	public void read();

	public void read(String uri) throws EmptyURIException;
	
	public List<RoundFigure> getBalls();

}
