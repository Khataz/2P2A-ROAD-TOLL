package body;

public class Sign implements SpeedLimiter {

    private double speedLimit;
	private Position position;

	public Sign(Position position, double speedLimit) {
		this.position = position;
	    this.speedLimit = speedLimit;
    }

    public Position getPosition() {
		return this.position;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public double getXPosition() {
	    return this.position.getX();
    }
}