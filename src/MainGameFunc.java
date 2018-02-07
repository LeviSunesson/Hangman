import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainGameFunc {

	public static int DIFFICULTY;

	public static int LIVES;

	private static Scanner input = new Scanner(System.in);

	public static void Run() throws FileNotFoundException {

		System.out.println("Welcome to HangMan!");
		Start();	
		Questions();
	}

	private static void Start() {

		System.out.println("Choose difficulty ( 1 , 2 , 3 )");
		DIFFICULTY = input.nextInt();

		if ( DIFFICULTY > 3 ) {
			DIFFICULTY = 3;
		}
		if ( DIFFICULTY < 1 ) {
			DIFFICULTY = 1;
		}

		System.out.println("Difficulty chosen: " + DIFFICULTY);

		LIVES = (int) (10/Math.sqrt(DIFFICULTY));

	}

	private static void Questions() throws FileNotFoundException {

		int lives = LIVES;

		String secretWord = GetWord(new File("Words.txt"));
		char[] found = secretWord.toCharArray();
		for(int i = 0 ; i < found.length ; i++) {
			found[i] = '_';
		}

		boolean won = false;

		boolean wrong = false;

		while( lives > 0 && !won) {

			System.out.println(" ");
			System.out.println("Guess a letter!");

			String guessedString = input.next();
			guessedString = guessedString.toUpperCase();

			for (int i = 0 ; i < found.length ; i++) {
				if ( guessedString.charAt(0) == secretWord.charAt(i) ) {
					found[i] = guessedString.charAt(0);

					System.out.println(found[i]);

					wrong = true;

				}
			}

			printCharArr(found);

			if ( wrong == false ) {

				lives--;

			}

			wrong = false;

			System.out.println("");
			PaintMan.print(lives);

			String foundd = new String(found);

			if (foundd.equals(secretWord) ) {

				won = true;
				break;
			}

		}

		if ( !won ) {

			System.out.println("You lost the word was: ");

		} else if ( won ){

			System.out.println("You Won! The word was: ");

		}


		secretWord = secretWord.toLowerCase();
		char[] a = secretWord.toCharArray();
		a[0] = Character.toUpperCase(a[0]);
		String b = new String(a);

		System.out.print(b);

		End();

	}

	private static String GetWord(File Words) throws FileNotFoundException {

		Scanner fileReader = new Scanner(Words);

		ArrayList<String> words = new ArrayList<String>();

		while ( fileReader.hasNextLine() ) {
			words.add(fileReader.nextLine());
		}

		fileReader.close();

		return words.get((int) (Math.random()*words.size()));

	}

	private static void End() throws FileNotFoundException {

		boolean done = false;

		System.out.println("");
		System.out.println("Do you want to play again? ( Y/ N )");

		String answer = input.next();

		answer = answer.toUpperCase();
		while ( !done ) {
			if ( !answer.equals("Y") || !answer.equals("N") ) {

				System.out.println(" Y or N ");

				answer = input.next();
				answer = answer.toUpperCase();

			}

			if ( answer.equals("Y") ) {

				Start();
				Questions();
				done = true;

			}

			if ( answer.equals("N")) {

				done = true;

			}	
		}
	}

	private static void printCharArr(char[] print) {

		for(char c : print) {

			System.out.print(c + " ");

		}

	}
}