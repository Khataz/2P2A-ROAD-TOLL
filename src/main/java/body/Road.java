package body;

import java.util.TreeMap;

public class Road {

    // variables
    private TreeMap<Position, SpeedLimiter> treeSigns;

    private Car car;

	private long timedebut;


    // constructors
    public Road() {
        treeSigns = new TreeMap<>();
        car = new Car(30.56, 0, new Position(0),this);
        timedebut=System.currentTimeMillis();
    }
    

    // methods
    public TreeMap<Position, SpeedLimiter> fillTreeSigns() {
        Sign s4 = new Sign(new Position(450), 13.89);
        treeSigns.put(s4.getPosition(), s4);

        Sign s1 = new Sign(new Position(100), 30.56);
        treeSigns.put(s1.getPosition(), s1);

        Sign s2 = new Sign(new Position(250), 25);
        treeSigns.put(s2.getPosition(), s2);

        Sign s3 = new Sign(new Position(400), 19.44);
        treeSigns.put(s3.getPosition(), s3);
        
        FastTeleToll t1 = new FastTeleToll(new Position(600));
        treeSigns.put(t1.getPosition(), t1);
        
	
        return treeSigns;
    }

    // accessors
    public TreeMap<Position, SpeedLimiter> getTreeSigns() {
        return treeSigns;
    }

    public SpeedLimiter getObjectAt(Position pos) {
        return getTreeSigns().get(pos);
    }

    public Car getCar() {
        return car;
    }

	public long getTimeDebut() {
		return timedebut;
	}

}
