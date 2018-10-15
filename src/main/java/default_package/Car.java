package default_package;

public class Car {

	private double speed;
	private double acceleration;
	private static final int visibility = 150;
	private Position pos;

	public Car(double speed, double acceleration, Position pos) {
	    this.speed = speed;
	    this.acceleration = acceleration;
	    this.pos = pos;
    }

    public Car() {
	    this(30.0, 0.0, new Position());
    }

	public void changeAcceleration(Sign sign) {
	    //TODO
	}

	public Object detectObject() {
        // TODO
        return null;
    }

	/**
	 * 
	 * @param Toll
	 */
	public void passToll(AbstractToll Toll) {
		//TODO
	}

}