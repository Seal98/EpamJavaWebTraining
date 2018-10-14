package by.training.epam.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureNotFoundException extends Exception{

	private static final long serialVersionUID = -7457105750560506333L;
	private static final Logger logger = LogManager.getLogger("readingFromFileException");

	public FigureNotFoundException() {
	}
	
	public FigureNotFoundException(String message) {
		super(message);
		logger.error(message);
	}
	
}
