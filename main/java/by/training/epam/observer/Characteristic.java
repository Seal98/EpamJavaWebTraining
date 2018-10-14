package by.training.epam.observer;

public class Characteristic {

	private int ballId;
	private double ballVolume;
	private double ballSurfaceArea;
	
	public Characteristic() {
	}
	
	public Characteristic(int ballId, double ballVolume, double ballSurfaceArea) {
		this.ballId = ballId;
		this.ballVolume = ballVolume;
		this.ballSurfaceArea = ballSurfaceArea;
	}

	public int getBallID() {
		return ballId;
	}
	
	public void setBallID(int ballID) {
		this.ballId = ballID;
	}
	
	public double getVolume() {
		return ballVolume;
	}
	
	public void setVolume(double volume) {
		this.ballVolume = volume;
	}
	
	public double getSurfaceArea() {
		return ballSurfaceArea;
	}
	
	public void setSurfaceArea(double surfaceArea) {
		this.ballSurfaceArea = surfaceArea;
	}
	
	
}
