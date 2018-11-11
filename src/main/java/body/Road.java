package body;

import java.util.TreeMap;

public class Road {

    // variables
    private TreeMap<Position, Sign> treeSigns;

    private Car car;

	private long timedebut;
    /*private long deltat = 1000000;
    
    private long time;
    private long timedebut;
    private long timeend;
    private long beforetime;
    private double beforespeed;*/

    // constructors
    public Road() {
        treeSigns = new TreeMap<Position, Sign>();
        car = new Car(15, 0, new Position(0),this);
        timedebut=System.currentTimeMillis();
    }
    
    /*public void actualizeCar() {
    	time = System.currentTimeMillis();
    	beforetime=time;
    	System.currentTimeMillis();
    	timeend = System.currentTimeMillis()+deltat;
    	while(time<timeend) {
    		beforetime=time;
    		beforespeed=car.getSpeed();
    		time = System.currentTimeMillis();
    		
    		
        	car.setPosX(car.getPos().getX()+((time-beforetime)/(double)1000*car.getSpeed()));
        	
        	car.setSpeed(car.getSpeed()+car.getAcceleration()*(time-beforetime));
        	if (car.getSpeed()>car.getmaxSpeed())
        		car.setSpeed(car.getmaxSpeed());
        	if (car.getSpeed()<=0)
        		car.setSpeed(0);
        	
        	if((time-beforetime)!=0)
        	{
        		car.setAcceleration((car.getSpeed()-beforespeed)/(time-beforetime));
        		car.changeAcceleration();
        		System.out.println("A t = " + (time-timedebut)/(double)1000 + "s la voiture se trouve a x = " + car.getPos().getX() + "m avec une vitesse de " + car.getSpeed() + " et une acceleration de " + car.getAcceleration());
        	}
        	
        		
    	}
    }*/

    // methods
    public TreeMap<Position, Sign> fillTreeSigns() {
        Sign s4 = new Sign(new Position(450), 13.89);
        treeSigns.put(s4.getPosition(), s4);

        Sign s1 = new Sign(new Position(100), 30.56);
        treeSigns.put(s1.getPosition(), s1);

        Sign s2 = new Sign(new Position(250), 25);
        treeSigns.put(s2.getPosition(), s2);

        Sign s3 = new Sign(new Position(400), 19.44);
        treeSigns.put(s3.getPosition(), s3);
	
        return treeSigns;
    }

    // accessors
    public TreeMap<Position, Sign> getTreeSigns() {
        return treeSigns;
    }

    public Sign getSignAt(Position pos) {
        return getTreeSigns().get(pos);
    }

    public Car getCar() {
        return car;
    }

	public long getTimeDebut() {
		return timedebut;
	}

}
