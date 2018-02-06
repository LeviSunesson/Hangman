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

		System.out.println("difficulty choosen: " + DIFFICULTY);

		LIVES = 10/DIFFICULTY;
		
	}
	
	private static void Questions() throws FileNotFoundException {
		
		String secretWord = GetWord(new File("Words.txt"));
		
		while( LIVES > 0 ) {
			
			System.out.println("Guess a letter!");
			
			System.out.println(secretWord);
			
		}
		
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
}











