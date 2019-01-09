package body;

public class TeleToll extends AbstractToll {
	
	private final static double SPEED_LIMIT=0;
	private final static int WAITING_TIME=2;
	

	public TeleToll(Position position) {
		super(SPEED_LIMIT, position, WAITING_TIME);
	}


}