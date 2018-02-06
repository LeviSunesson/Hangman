import java.util.*;

public class MainGameFunc {

	public static int DIFFICULTY;

	private static Scanner input = new Scanner(System.in);

	public static void Start() {

		System.out.println("Welcome to HangMan!");

		System.out.println("Choose difficulty ( 1 , 2 , 3 )");
		DIFFICULTY = input.nextInt();

		if ( DIFFICULTY > 3 ) {
			DIFFICULTY = 3;
		}
		if ( DIFFICULTY < 1 ) {
			DIFFICULTY = 1;
		}

		System.out.println("difficulty choosen: " + DIFFICULTY);

	}

}
