package exercise10_the_frog_contest;

/**
 * A frog starting from x-axis and jumping towards the positive infinite
 * direction.
 * 
 * @author george
 *
 */
public class Frog {

	// frog's starting point
	private int startingPoint;
	// frog's moving rate
	private int movementRate;

	public Frog() {
	}

	public Frog(int startingPoint, int movingRate) {
		this.startingPoint = startingPoint;
		this.movementRate = movingRate;
	}

	public void setStartingPoint(int startingPoint) {
		this.startingPoint = startingPoint;
	}

	public int getStartingPoint() {
		return this.startingPoint;
	}

	public void setMovementRate(int movingRate) {
		this.movementRate = movingRate;
	}

	public int getMovementRate() {
		return this.movementRate;
	}

	public boolean landAtTheSameLocation(Frog frog) {
		int newPoint1 = this.startingPoint;
		int newPoint2 = frog.getStartingPoint();
		if (this.movementRate == frog.getMovementRate()) {
			if (this.startingPoint == frog.getStartingPoint()) {
				return true;
			}
		} else if (this.movementRate < frog.getMovementRate()) {
			if (this.startingPoint > frog.getStartingPoint()) {
				do {
					newPoint1 += this.movementRate;
					newPoint2 += frog.getMovementRate();
					if (newPoint1 == newPoint2)
						return true;
				} while (newPoint1 > newPoint2);
				return false;
			}
		} else if (this.movementRate > frog.getMovementRate()) {
			if (this.startingPoint < frog.getStartingPoint()) {
				do {
					newPoint1 += this.movementRate;
					newPoint2 += frog.getMovementRate();
					if (newPoint1 == newPoint2)
						return true;
				} while (newPoint1 < newPoint2);
				return false;
			}
		}
		return false;
	}

	public int findSameLandingLocation(Frog frog) {
		int newLocation1 = this.startingPoint;
		int newLocation2 = frog.getStartingPoint();
		do {
			newLocation1 += this.movementRate;
			newLocation2 += frog.getMovementRate();
		} while (newLocation1 != newLocation2);
		return newLocation1;
	}
}
