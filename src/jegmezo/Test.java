package jegmezo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import jegmezo.avatars.Eskimo;
import jegmezo.avatars.Researcher;

public class Test {
	private static boolean exit = false;

	public void evaluateTest(BufferedReader br) throws IOException {

		while (br.readLine() != null) {
			String[] command = br.readLine().split(" ");

			switch (command[0].toLowerCase()) {
			case "init":
				break;
			case "avatar":
				break;
			case "field":
				break;
			case "move":
				break;
			case "bind":
				break;
			case "take":
				break;
			case "igloo":
				break;
			case "check":
				break;
			case "item":
				break;
			case "itemtofield":
				break;
			case "tobackpack":
				break;
			case "feed":
				break;
			case "snow":
				break;
			case "use":
				break;
			case "lunch":
				break;
			case "strom":
				break;
			case "freeze":
				break;
			case "activity":
				break;
			case "shoot":
				break;
			case "help":
				break;
			case "setused":
				break;
			case "savetofile":
				break;
			default:
				break;
			}
		}

	}

	/*
	 * public static void main(String[] args) throws IOException { String path =
	 * Paths.get("").toAbsolutePath().toString();
	 * 
	 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 * String fileName = br.readLine();
	 * 
	 * FileReader fr = new FileReader(path + "/" + fileName); BufferedReader bread =
	 * new BufferedReader(fr);
	 * 
	 * 
	 * Test t = new Test(); t.evaluateTest(bread); }
	 */

}
