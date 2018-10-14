package by.training.epam.reader;

import java.io.IOException;
import java.util.List;

import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.EmptyURIException;
import by.training.epam.exception.ReadingFromFileException;

public interface RoundFigureReader {

	public void readFigure() throws IOException, ReadingFromFileException;

	public void readFigure(String uri) throws EmptyURIException, IOException, ReadingFromFileException;

	public List<RoundFigure> getBalls();

}
