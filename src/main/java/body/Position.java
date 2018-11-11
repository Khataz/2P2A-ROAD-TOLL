package body;

public class Position implements Comparable{

	private double x;

	public Position() {
	    this(0.0);
    }

    public Position(double x) {
	    this.x = x;
    }

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x=x;
		
	}

    public int compareTo(Object o) {
        if (o instanceof Position) {
            return (int) (this.getX()-((Position) o).getX());
        }
        else
            throw new IllegalArgumentException("Mettre une position en param");
    }
}