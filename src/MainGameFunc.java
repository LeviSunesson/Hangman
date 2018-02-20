import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MainGameFunc {

	public static int DIFFICULTY;

	public static int LIVES;

	private static ArrayList<String> WORDS = new ArrayList<String>();

	private static ArrayList<String> guessedArr = new ArrayList<String>();

	private static Scanner input = new Scanner(System.in);

	private static void Setup(File Words) throws FileNotFoundException {

		Scanner fileReader = new Scanner(Words);

		while ( fileReader.hasNextLine() ) {
			WORDS.add(fileReader.nextLine());
		}

		fileReader.close();

		while( WORDS.size() > 10 ) {

			WORDS.remove((int) (Math.random()*WORDS.size()));

		}

		System.out.println("Welcome to HangMan!");

	}

	public static void Run() throws FileNotFoundException {

		Setup(new File("Words.txt"));
		Start();	
		Questions();
	}

	private static void Start() {

		boolean state = false;

		ArrayList<String> nubm = new ArrayList<String>();

		nubm.add("1");
		nubm.add("2");
		nubm.add("3");

		System.out.println("Choose difficulty " + nubm);
		String diff = input.next();

		while(!state) {

			if( nubm.contains(diff)) {

				DIFFICULTY = Integer.parseInt(diff);

				state = true;

			}else {

				System.out.println(nubm);

				diff = input.next();

			}
		}

		state = false;

		System.out.println("Difficulty chosen: " + DIFFICULTY);

		LIVES = (int) (10/Math.sqrt(DIFFICULTY));

	}

	private static void Questions() {

		int lives = LIVES;

		String secretWord = GetWord();
		
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

			if ( !guessedArr.contains(guessedString) ) {

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

				guessedArr.add(guessedString);

			}else if( guessedArr.contains(guessedString) ) {

				System.out.println("You have already guessed that");

			}



			String foundd = new String(found);
			if (foundd.equals(secretWord) ) {

				won = true;
				break;
			}


			System.out.println(guessedArr);

		}

		if ( !won ) {

			System.out.println("You lost, the word was: ");
			
			
		} else if ( won ){

			System.out.println("You Won! The word was: ");

			WORDS.remove(secretWord);
			
		}

		secretWord = secretWord.toLowerCase();
		char[] a = secretWord.toCharArray();
		a[0] = Character.toUpperCase(a[0]);
		String b = new String(a);

		System.out.print(b);

		End();

	}

	private static String GetWord() {

		return WORDS.get((int) (Math.random()*WORDS.size()));

	}

	private static void End() {

		boolean done = false;

		if ( WORDS.size() < 1 ) {

			System.out.println("");
			System.out.println("You have completed the entire game!");

			return;

		} 

		System.out.println("");
		System.out.println("Do you want to play again? ( Y / N )");

		String answer = input.next();
		answer = answer.toUpperCase();

		while ( !done ) {
			if ( answer.equals("Y") ) {

				guessedArr.removeAll(guessedArr);

				Start();
				Questions();
				done = true;

			}

			if ( answer.equals("N")) {

				done = true;

				return;

			}
			if ( !answer.equals("Y") || !answer.equals("N") ) {

				System.out.println(" Y or N ");

				answer = input.next();
				answer = answer.toUpperCase();

			}


		}
	}

	private static void printCharArr(char[] print) {

		for(char c : print) {

			System.out.print(c + " ");

		}

	}
}