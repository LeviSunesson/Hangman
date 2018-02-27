import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameStart {

	private static String GAMEMODE;

	public static ArrayList<String> WORDS = new ArrayList<String>();

	public static void main(String[] args) throws FileNotFoundException {

		// Launch game

		Setup();

	}

	private static void Setup() throws FileNotFoundException {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to HangMan!");

		boolean state = false;

		ArrayList<String> ans = new ArrayList<String>();

		ans.add("S");
		ans.add("M");

		System.out.println("Singleplayer or Multiplayer" + ans);
		String diff = input.next().toUpperCase();

		while(!state) {

			if( ans.contains(diff)) {

				GAMEMODE = diff;

				state = true;

			}else {

				System.out.println(ans);

				diff = input.next();

			}
		}

		state = false;

		if (GAMEMODE.equals("S")) {

			MainGameFunc.Run();

		}else if (GAMEMODE.equals("M")) {

			functionsMP.Run();

		}

		input.close();

	}

}
