
public class Player {

	public static int LIVES;
	private static int POINTS = 0;

	Player() {

	}

	Player(int life, int point) {

		this.LIVES  = life;
		this.POINTS = point;

	}

	public static void addPoint() {

		POINTS++;

	}

	public static void addPoint(int numberOfPoints) {

		POINTS += numberOfPoints;

	}

	public static void setLives(int life) {

		LIVES = life;

	}

	public static int getLives() {

		return LIVES;

	}

	public static int getPoints() {

		return POINTS;

	}

	public static void loseLife() {

		LIVES--;

	}

}
