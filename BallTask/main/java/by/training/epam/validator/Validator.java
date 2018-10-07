package by.training.epam.validator;

import java.util.List;

public interface Validator {
	
	public void validate(List<String> balls);
	
	public boolean isValid(String ball);

}
