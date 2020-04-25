package jegmezo;
import jegmezo.avatars.Avatar;
import jegmezo.avatars.Eskimo;
import jegmezo.avatars.Researcher;
import jegmezo.fields.*;
import jegmezo.items.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Controller {
	private static String command;
	
	public Controller(String str) {
		command = str;
	}
	
	public static void startGame() throws IOException {
		System.out.println("<Controller.startGame()");
		
		GameEnder gameEnder = new GameEnder();
		GameArea gameArea = new GameArea(gameEnder);
		runGame(gameEnder, gameArea);
		
		System.out.println(">Controller.startGame()");
	}
	
	/*
	 * Itt fog futni a jatek
	 */
	
	@SuppressWarnings("null")
	public static void runGame(GameEnder gameEnder, GameArea gameArea) throws IOException {
		System.out.println("<Controller.runGame()");
		
		System.out.println("Enter command for 1st Avatar!");
		boolean exit = true;
		
		StringTokenizer st = new StringTokenizer(command, "\n");
		String[] result = null;
		int i = 0;
		while(st.hasMoreTokens()) {
			result[i++] = st.nextToken();
		}
		
		int size = 0;
		do {
        	int k = 0;
    		StringTokenizer stok = new StringTokenizer(result[k++], " ");
    		String[] cmd = null;
    		int j = 0;
    		
    		while(stok.hasMoreTokens()) {
    			cmd[j++] = st.nextToken();
    		}
	    		
	        switch(cmd[0].toUpperCase()) {
	      		case "AVATAR":
				if(cmd[1].toUpperCase().equals("E")) {
					gameArea.addAvatar(new Eskimo(cmd[2].toLowerCase()));
				}else if(cmd[1].toUpperCase().equals("R")){
					gameArea.addAvatar(new Researcher(cmd[2].toLowerCase()));
				}
        			break;
        		
				default:
					System.out.println("Hibas input");
				    break;
        	}
			
			gameArea.changeActiveAvatar();
			size++;
		}while(size < result.length);
		
		/* Ez azert komment most, mert unreachable code (a while(1) miatt).
		 * Oda majd megy valami, ami figyeli a jatek veget.
		 * Zoli
		*/
		System.out.println(">Controller.runGame()");
	}
	
	/*
	 * Kap egy csomag mezot, amiket behavaz.
	 * Zoli
	 */
	public static void Storm(List<Field> fields) {
		System.out.println("<Controller.Storm()");
		
		Random rand = new Random();
		for(int i = 0; i < fields.size(); i++) {
			/*
			 * Igy 50% esellyel esik minden mezon a ho
			 */ 
	        	int probability = rand.nextInt(101);
	        	if(probability > 50) {
	        		fields.get(i).setSnow(1);
				for(int j = 0; j < fields.get(i).avatars.size(); j++) {
	        			fields.get(i).avatars.get(j).loseHealth();
	        		}
	        	}
		}
		
		System.out.println(">Controller.Storm()");
	}
	
	public static void main(String[] args) {
        System.out.println("A legjobb targy a Projlab!! -help ;)");
        try {
			startGame();
		} catch (IOException e) {
			System.out.println("IOexception: startgame");
			e.printStackTrace();
		}
    }
	
}
