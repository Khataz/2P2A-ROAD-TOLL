package ctrl;

import java.util.TreeMap;

import body.Car;
import body.Position;
import body.Road;
import body.Sign;
import body.SpeedLimiter;
import gui.RoadWindow;

public class Controller {

	 private long deltat = 1000000;
	    
	    private long time;
	    private long timedebut;
	    private long timeend;
	    private long beforetime;
	    private double beforespeed;
	    private Road road;
	    private RoadWindow window;
	    
	    public Controller() throws InterruptedException {
	    	this.road=new Road();
	    	this.timedebut=road.getTimeDebut();
	    	TreeMap<Position, SpeedLimiter> signs = road.fillTreeSigns();
	    	this.window = new RoadWindow(signs);
	    	Thread.sleep(1000);
	    	actualizeCar();
	    }
	
	  public void actualizeCar() {
		  	Car car = road.getCar();
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
	        	}
	        	
	        	window.actualiseVoit((int)car.getPos().getX());
	        	window.actualiseVitesse(car.getSpeed());
	    	}
	    }

	public void setTimedebut(long currentTimeMillis) {
		this.timedebut=currentTimeMillis;
	}
	
	public long getTime() {
		return this.time;
	}
	
	
	
	
	
}
