package body;

public class FastTeleToll extends AbstractToll {
	
	private final static double SPEED_LIMIT=8.33;
	private final static int WAITING_TIME=0;

	public FastTeleToll(Position position) {
		super(SPEED_LIMIT, position, WAITING_TIME);
	}
}