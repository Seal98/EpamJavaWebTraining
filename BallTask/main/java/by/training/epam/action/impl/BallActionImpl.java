package by.training.epam.action.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.epam.action.BallAction;
import by.training.epam.entity.RoundFigure;
import by.training.epam.entity.impl.Ball;
import by.training.epam.exception.EmptyURIException;
import by.training.epam.reader.Reader;
import by.training.epam.reader.impl.ReadFromFileImpl;

public class BallActionImpl implements BallAction {

	private static final Logger logger = LogManager.getLogger(BallActionImpl.class);
	
	public boolean compare(List<RoundFigure> list1, List<RoundFigure> list2) {
		if(list1.size() != list2.size()) {
			return false;
		}
		for(int i=0; i < list1.size();i++) {
			if(!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public double ballSurfaceArea(Ball ball) {
		return 4 * Math.pow(ball.getRadius(), 2) * Math.PI;
	}

	@Override
	public double ballDiameter(Ball ball) {
		return ball.getRadius() * 2;
	}

	@Override
	public double ballVolume(Ball ball) {
		return Math.PI * Math.pow(ball.getRadius(), 3) * 4 / 3;
	}

	@Override
	public List<RoundFigure> create(String uri) {
		Reader reader = new ReadFromFileImpl();
		try {
			reader.read(uri);
		} catch (EmptyURIException e) {
			logger.error(e);
		}
		return reader.getBalls();
	}

}
