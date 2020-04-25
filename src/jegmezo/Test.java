package jegmezo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	private static boolean exit = false;

	public static void main(String[] args) throws IOException {
		do {
			System.out.println("Which test would you like to run?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String command = br.readLine();
			
		    switch(command.toUpperCase()) {
		        case "INIT":
		        	Controller c1 = new Controller("init");
				c1.startGame(true);
		           	break;
		        case "MOVEAVATAR":
		        	Controller c2 = new Controller
		        		("avatar e e1;field s f1;field s f2;bind n f1 f2;take e1 f1;move e1 n;saveToFile Results");
				c2.startGame(false);
		           	break;
			case "EXIT":
				exit = true;
				break;
			default:
				System.out.println("Hibas input");
				break;
		    }
		}while(!exit);
    }
}
