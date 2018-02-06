import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainGameFunc {

	public static int DIFFICULTY;

	public static int LIVES;

	private static Scanner input = new Scanner(System.in);

	public static void Run() throws FileNotFoundException {

		Start();	
		Questions();
	}

	private static void Start() {

		System.out.println("Welcome to HangMan!");

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

		String secretWord = GetWord(new File("Words.txt"));
		char[] found = secretWord.toCharArray();
		for(int i = 0 ; i < found.length ; i++) {
			found[i] = '_';
		}

		boolean wrong = false;
		
		while( LIVES > 0 ) {

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
				
				LIVES--;
				
			}
			
			if (found == secretWord.toCharArray()) {
				
				System.out.println("Congrats you won!");
				
			}
			
		}
		
		System.out.println(secretWord);

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
	
	private static void printCharArr(char[] print) {
		
		for(char c : print) {

			System.out.print(c + " ");

		}
		
	}
}











