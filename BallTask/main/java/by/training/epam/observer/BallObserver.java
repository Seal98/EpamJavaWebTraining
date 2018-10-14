package by.training.epam.observer;

import java.util.ArrayList;
import java.util.List;

public class BallObserver implements RoundFigureObserver {

	private List<Characteristic> ballsCharacteristic;

	public BallObserver() {
		ballsCharacteristic = new ArrayList<>();
	}

	public BallObserver(int ballId, double ballVolume, double ballSurfaceArea) {
		ballsCharacteristic.add(new Characteristic(ballId, ballVolume, ballSurfaceArea));
	}

	@Override
	public void updateFigure(int ballId, double ballVolume, double ballSurfaceArea) {
		for (int i = 0; i < ballsCharacteristic.size(); i++) {
			if (ballsCharacteristic.get(i).getBallID() == ballId) {
				ballsCharacteristic.get(i).setVolume(ballVolume);
				ballsCharacteristic.get(i).setSurfaceArea(ballSurfaceArea);
				return;
			}
		}
	}

}
