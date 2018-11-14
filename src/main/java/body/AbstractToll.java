package body;

public abstract class AbstractToll implements SpeedLimiter {

	private boolean isOpen = false;
	private int waitingTime;
	private double speedLimit;
	private Position position;

	
	public AbstractToll(double speedlimit, Position position,int waitingTime) {
		this.speedLimit=speedlimit;
		this.position=position;
		this.waitingTime=waitingTime;
	}
	public void open() {
		// TODO - implement body.AbstractToll.open
		throw new UnsupportedOperationException();
	}

	public void close() {
		// TODO - implement body.AbstractToll.close
		throw new UnsupportedOperationException();
	}
	
	public Position getPosition() {
		return this.position;
	}

	public double getSpeedLimit() {
		return this.speedLimit;
	}

	public double getXPosition() {
		return this.getPosition().getX();
	}

}