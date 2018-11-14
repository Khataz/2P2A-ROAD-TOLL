package body;

public class Car {

    // variables
    private double speed;
	private double acceleration;
	private double maxspeed = 41.67;
	private static final int visibility = 150;
	private Position pos;
	private Road route;

	public Car(double speed,double acceleration, Position pos,Road route) {
		this.route = route;
	    this.speed = speed;
	    this.acceleration = acceleration;
	    this.pos = pos;
    }

    public Car(Road route) {
	    this(30.56, 0.0, new Position(),route);
    }

    // methods
	public void changeAcceleration() {
		SpeedLimiter obj = this.detectObject();
		if(obj != null) {
			double vf =obj.getSpeedLimit();
			double xf =obj.getXPosition();
			this.acceleration=(((vf*vf)-(speed*speed))/(2*(xf-pos.getX())))/1000;
	//		System.out.println("Je suis à " + pos.getX() + "m du depart pour aller à " + xf + "m du depart mon acceleration passe du coup à + " + this.getAcceleration());
			
		}
		if(obj == null)
			this.acceleration=0;

	}

	public SpeedLimiter detectObject() {
		if(route.getTreeSigns().ceilingKey(pos) == null)
			return null;			
		Position panneausuivant = route.getTreeSigns().ceilingKey(pos);
		if(panneausuivant.getX()-this.pos.getX()>visibility)
			return null;
		else 
			return route.getObjectAt(panneausuivant);
    }

	/**
	 * 
	 * @param Toll
	 */
	public void passToll(AbstractToll Toll) {
		//TODO
	}

	// accessors
    public double getSpeed() {
        return speed;
    }
    
    public double getmaxSpeed() {
        return maxspeed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public static int getVisibility() {
        return visibility;
    }

    public Position getPos() {
        return pos;
    }

    public void setPosX(double pos) {
        this.pos.setX(pos);
    }

}