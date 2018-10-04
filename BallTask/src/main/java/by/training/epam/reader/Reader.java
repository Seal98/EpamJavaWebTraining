package by.training.epam.reader;

import java.util.List;

import by.training.epam.entity.Ball;

public interface Reader {
	public void read();
	public List<Ball> getBalls();
}
