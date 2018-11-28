package body;

public class Car {

    // variables
    private double speed;
	private double acceleration;
	private double maxspeed = 41.67;
	private static final int visibility = 150;
	private Position pos;
	private Road route;
	private int waitingTimeToll;
	private boolean isWaiting;
	private long beginTimeWaiting;
	private double randomTime = 0;

	public Car(double speed,double acceleration, Position pos,Road route,int waitingTime) {
		this.route = route;
	    this.speed = speed;
	    this.acceleration = acceleration;
	    this.pos = pos;
	    this.waitingTimeToll=waitingTime;
	    this.isWaiting=false;
    }

    public Car(Road route) {
	    this(30.56, 0.0, new Position(),route,5);
    }

    // methods
	public void changeAcceleration() {
		SpeedLimiter obj = this.detectObject();
		if(!this.isWaiting && obj != null) {
			if(obj.getSpeedLimit() == 0 && this.getSpeed()==0)
			{
				this.passToll();
			}
			
			if(obj.getSpeedLimit()>=0) {
				double vf =obj.getSpeedLimit();
				double xf =obj.getXPosition();
				this.acceleration=(((vf*vf)-(speed*speed))/(2*(xf-pos.getX())))/1000;	
			}

		}
		else if(!this.isWaiting)
		{
			this.passToll();
		}
		else
        {
            this.acceleration = 0;
        }
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


	public void passToll() {
		if(this.beginTimeWaiting==0){
			randomTime=this.waitingTimeToll+(Math.random()*(3-0+0)+0);
			this.isWaiting=true;
			this.beginTimeWaiting=System.currentTimeMillis();
		}
		if(this.beginTimeWaiting!=0 ) {
				
			if((System.currentTimeMillis()-beginTimeWaiting)/1000>=randomTime) {
				this.isWaiting=false;
				this.beginTimeWaiting=0;
				this.setPosX(pos.getX()+0.01);
				this.setAcceleration(0.0056);
			}
		}

		
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