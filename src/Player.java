
public class Player {

	private static int LIVES;
	private static int POINTS;
	
	public static void addPoint() {
		
		POINTS++;
		
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
	
}
