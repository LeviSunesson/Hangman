import java.util.Scanner;
import java.util.ArrayList;

public class functionsMP {


	public static int DIFFICULTY;

	public static String GAMEMODE;

	public static int LEVEL;
	
	private static ArrayList<String> WORDS = new ArrayList<String>();

	private static ArrayList<String> guessedArr = new ArrayList<String>();

	public static ArrayList<Player> players = new ArrayList<Player>();

	private static Scanner input = new Scanner(System.in);

	private static void Setup(){

		Player player1 = new Player();
		
		Player player2 = new Player();
		
		ArrayList<String> levels = new ArrayList<String>();
		
		for (int j = 1; j <= 5; j++) {
			
			String s = "" + j;
			
			levels.add(s);
			
		}
		
		boolean state = false;
		
		System.out.println("Number of rounds " + levels);
		
		String diff = input.next();

		while(!state) {

			if( levels.contains(diff)) {

				LEVEL = Integer.parseInt(diff);

				state = true;

			}else {

				System.out.println(levels);

				diff = input.next();

			}
		}

		state = false;
		
		getWord();

		StartMultiplayer();

	}
	
	private static void getWord() {
		
		System.out.println("The Secret Word");

		String word = input.next();

		WORDS.add(word.toUpperCase());
		
	}

	public static void Run() {

		Setup();	
		Questions();
	}

	private static void StartMultiplayer() {

		boolean state = false;

		ArrayList<String> number = new ArrayList<String>();

		number.add("1");
		number.add("2");
		number.add("3");

		System.out.println("Choose difficulty " + number);
		String diff = input.next();

		while(!state) {

			if( number.contains(diff)) {

				DIFFICULTY = Integer.parseInt(diff);

				state = true;

			}else {

				System.out.println(number);

				diff = input.next();

			}
		}

		state = false;

		System.out.println("Difficulty chosen: " + DIFFICULTY);

		Player.setLives((int) (10/Math.sqrt(DIFFICULTY)));

	}

	private static void Questions() {

		//players.get(0);

		String secretWord = WORDS.get(0);

		char[] found = secretWord.toCharArray();
		for(int i = 0 ; i < found.length ; i++) {
			found[i] = '_';
		}

		boolean won = false;

		boolean wrong = false;

		while( Player.LIVES > 0 && !won) {

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

				PaintMan.printCharArr(found);

				if ( wrong == false ) {

					Player.loseLife();

				}

				wrong = false;

				System.out.println("");
				PaintMan.print(Player.getLives());

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

			Player.addPoint();

		}

		secretWord = secretWord.toLowerCase();
		char[] a = secretWord.toCharArray();
		a[0] = Character.toUpperCase(a[0]);
		String b = new String(a);

		System.out.print(b);

		End();

	}

	private static void End() {

		boolean done = false;

		//players.get(0);
		if ( Player.getPoints() == 2 ) {

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

				getWord();
				Questions();
				done = true;

			}else if ( answer.equals("N")) {

				done = true;

				return;

			}else if ( !answer.equals("Y") || !answer.equals("N") ) {

				System.out.println(" Y or N ");

				answer = input.next();
				answer = answer.toUpperCase();

			}

		}

	}

}
