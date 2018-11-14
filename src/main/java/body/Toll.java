package body;



public class Toll extends AbstractToll {
	
	private final static double SPEED_LIMIT=0;
	private final static int WAITING_TIME=15;
	

	public Toll(Position position) {
		super(SPEED_LIMIT, position, WAITING_TIME);
	}

	
}