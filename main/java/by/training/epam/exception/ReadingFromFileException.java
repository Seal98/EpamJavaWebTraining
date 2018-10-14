package by.training.epam.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadingFromFileException extends Exception{
	private static final long serialVersionUID = 6961815337106678653L;
	private static final Logger logger = LogManager.getLogger("readingFromFileException");
	
	public ReadingFromFileException() {
	}

	public ReadingFromFileException(String exceptionMessage) {
		super(exceptionMessage);
		logger.error(exceptionMessage);
	}
	
	public ReadingFromFileException(String exceptionMessage, Exception e) {
		super(exceptionMessage, e);
	}
}
