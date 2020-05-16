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
	static GameEnder gameEnder;
	static GameArea gameArea;

	
	public static void startGame(boolean init) throws IOException {
		System.out.println("<Controller.startGame()");
		
		gameEnder = new GameEnder();
		gameArea = new GameArea(gameEnder, init);
		/*if(init) {
			System.out.println("if init");
			runGame();
		}*/
		
		System.out.println(">Controller.startGame()");
	}
	
	/*
	 * Itt fog futni a jatek
	 */
	
	@SuppressWarnings("null")
	public static void runGame() throws IOException {
		System.out.println("<Controller.runGame()");
		
		System.out.println("Enter command for 1st Avatar!");
		boolean exit = true;
		
		do {
			gameArea.changeActiveAvatar();
			Storm(gameArea.fieldsOnArea);
			
			if(gameArea.avatars.get(gameArea.activeAvatar).getNPC()) {
				gameArea.avatars.get(gameArea.activeAvatar).move(Direction.East);
			}else {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        	String command = br.readLine();
			        switch(command.toUpperCase()) {
			        	/*case "S":
			        		
		            		break;*/
			      		case "SP":
			      			gameArea.avatars.get(gameArea.activeAvatar).specialMove();
			            	break;
						case "B":
							gameArea.avatars.get(gameArea.activeAvatar).addToBackpack();
						    break;
						case "T":
							gameArea.avatars.get(gameArea.activeAvatar).endTurn();
						    break;
						case "U":
							gameArea.avatars.get(gameArea.activeAvatar).useItem();
							break;
						case "MN":
							System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
							gameArea.avatars.get(gameArea.activeAvatar).move(Direction.North);
						    break;
						case "ME":
							System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
							gameArea.avatars.get(gameArea.activeAvatar).move(Direction.East);
						    break;
						case "MS":
							System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
							gameArea.avatars.get(gameArea.activeAvatar).move(Direction.South);
						    break;
						case "MW":
							System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
							gameArea.avatars.get(gameArea.activeAvatar).move(Direction.West);
						    break;
						case "D":
							System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
							gameArea.avatars.get(gameArea.activeAvatar).dropItem();
							break;
						case "EXIT":
							exit=false;
							break;
						default:
							System.out.println("Hibas input");
							break;
		        		}
					}
			}while(exit);
		
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
	        	int probability = rand .nextInt(101);
	        	if(probability > 50) {
	        		fields.get(i).setSnow(1);
				for(int j = 0; j < fields.get(i).avatars.size(); j++) {
	        			fields.get(i).avatars.get(j).loseHealth();
	        		}
	        	}
		}
		
		System.out.println(">Controller.Storm()");
	}
	
	public void mainThread() {
        System.out.println("A legjobb targy a Projlab!! -help ;)");
        try {
			startGame(true);
		} catch (IOException e) {
			System.out.println("IOexception: startgame");
			e.printStackTrace();
		}
    }
	public GameArea getGameArea() {
		return gameArea;
	}
}