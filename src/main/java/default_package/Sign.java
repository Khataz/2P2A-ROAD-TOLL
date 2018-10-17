package default_package;

public class Sign {

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
}