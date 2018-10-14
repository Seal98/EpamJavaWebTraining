package by.training.epam.repository;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import by.training.epam.action.BallAction;
import by.training.epam.action.BallActionImpl;
import by.training.epam.entity.Point;
import by.training.epam.entity.RoundFigure;
import by.training.epam.exception.FigureAlreadyExistException;
import by.training.epam.exception.FigureNotFoundException;
import by.training.epam.observer.RoundFigureObserver;
import by.training.epam.observer.RoundFigureSubject;

public class BallRepository implements FigureRepository, Comparator<RoundFigure>, RoundFigureSubject {

	private List<RoundFigure> balls;
	private List<RoundFigureObserver> observers;

	private BallRepository() {
		balls = new LinkedList<>();
		observers = new ArrayList<>();
	}

	/*
	 * private static class SingletonHandler { private static final BallRepository
	 * instance = new BallRepository(); }
	 * 
	 * public static BallRepository getInstance() { return
	 * SingletonHandler.instance; }
	 */

	private static BallRepository instance;

	public static BallRepository getInstance() {
		if (instance == null) {
			instance = new BallRepository();
		}
		return instance;
	}

	public RoundFigure getFigureById(int id) throws FigureNotFoundException {
		for (int i = 0; i < balls.size(); i++) {
			if (balls.get(i).getBallId() == id) {
				return balls.get(i).getDeepCopy();
			}
		}
		throw new FigureNotFoundException("Figure with this ID doesn't exist");
	}

	public List<RoundFigure> getFiguresWithVolumeInRange(double value1, double value2) {
		BallAction action = new BallActionImpl();
		List<RoundFigure> figures = new ArrayList<>();
		for (RoundFigure figure : balls) {
			if (action.ballVolume(figure) >= value1 && action.ballVolume(figure) <= value2) {
				figures.add(figure);
			}
		}
		return figures;
	}

	public List<RoundFigure> getFiguresWithSurfaceAreaInRange(double value1, double value2) {
		BallAction action = new BallActionImpl();
		List<RoundFigure> figures = new ArrayList<>();
		for (RoundFigure figure : balls) {
			if (action.ballSurfaceArea(figure) >= value1 && action.ballSurfaceArea(figure) <= value2) {
				figures.add(figure);
			}
		}
		return figures;
	}

	public List<RoundFigure> getFiguresWithDistanceToOriginInRange(double value1, double value2) {
		List<RoundFigure> figures = new ArrayList<>();
		for (RoundFigure figure : balls) {
			Point p = figure.getPoint();
			double distance = Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY() + p.getZ() * p.getZ());
			if (distance >= value1 && distance <= value2) {
				figures.add(figure);
			}
		}
		return figures;
	}

	public void sortBalls(BallsComparator comp) {
		qSort(0, balls.size()-1, comp);
	}

	private void qSort(int l, int r, BallsComparator comp) {
		int i = l;
		int j = r;
		int middle = (i + j) / 2;
		while (i <= j) {
			while (comp.compare(balls.get(i), balls.get(middle)) == -1) {
				i++;
			}
			while (comp.compare(balls.get(j), balls.get(middle)) == 1) {
				j--;
			}
			if (i <= j) {
				RoundFigure buff = balls.get(i);
				balls.set(i++, balls.get(j));
				balls.set(j--, buff);
			}
		}
		if (i < r) {
			qSort(i, r, comp);
		}
		if (j > l) {
			qSort(l, j, comp);
		}
	}

	@Override
	public List<RoundFigure> getFigures() {
		List<RoundFigure> figures = new LinkedList<>();
		for (RoundFigure figure : balls) {
			figures.add(figure.getDeepCopy());
		}
		return figures;
	}

	@Override
	public void addFigure(RoundFigure newFigure) throws FigureAlreadyExistException {
		for (int i = 0; i < balls.size(); i++) {
			if (newFigure.getBallId() == balls.get(i).getBallId()) {
				throw new FigureAlreadyExistException("Figure with this ID already exist inside repository");
			}
		}
		balls.add(newFigure);
	}

	@Override
	public void removeFigure(RoundFigure figure) {
		Iterator<RoundFigure> it = balls.iterator();
		while (it.hasNext()) {
			if (compare(it.next(), figure) == 0) {
				it.remove();
				return;
			}
		}
	}

	@Override
	public void updateFigure(RoundFigure figure) {
		for (int i = 0; i < balls.size(); i++) {
			if (figure.getBallId() == balls.get(i).getBallId()) {
				balls.set(i, figure);
				return;
			}
		}
	}

	@Override
	public int compare(RoundFigure ball1, RoundFigure ball2) {
		return ball1.equals(ball2) ? 0 : 1;
	}

	@Override
	public void addObserver(RoundFigureObserver newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void removeObserver(RoundFigureObserver observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers(RoundFigure updatedFigure) {
		BallAction action = new BallActionImpl();
		int ballId = updatedFigure.getBallId();
		double ballVolume = action.ballVolume(updatedFigure);
		double ballSurfaceArea = action.ballSurfaceArea(updatedFigure);
		for (RoundFigureObserver obs : observers) {
			obs.updateFigure(ballId, ballVolume, ballSurfaceArea);
		}
	}

}
