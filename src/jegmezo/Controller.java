package jegmezo;
import jegmezo.avatars.*;
import jegmezo.fields.*;
import jegmezo.items.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Controller {
	
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
	public static void runGame(GameEnder gameEnder, GameArea gameArea) throws IOException {
		System.out.println("<Controller.runGame()");
		
		System.out.println("Enter command for 1st Avatar!");
		
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        	String command = br.readLine();
		        switch(command) {
		        case "S":
	        		Storm(gameArea.fieldsOnArea);
	            		break;
	      		case "I":
				/*
				 * Valahogy meg kene tudni, hogy Eskimo-e es akkor build-elni.
				 * Zoli
				 */
	            		break;
			case "B":
				gameArea.avatars.get(gameArea.activeAvatar).addToBackpack(
						gameArea.avatars.get(gameArea.activeAvatar).field.item
						);
			    break;
			case "T":
				gameArea.avatars.get(gameArea.activeAvatar).endTurn();
			    break;
			case "U":
			    /*
			     * Ide kell majd egy "U..." minden fajta Item-hez
			     * Zoli
			     */
			    break;
			case "MN":
				gameArea.avatars.get(gameArea.activeAvatar).move(Direction.North);
			    break;
			case "ME":
				gameArea.avatars.get(gameArea.activeAvatar).move(Direction.East);
			    break;
			case "MS":
				gameArea.avatars.get(gameArea.activeAvatar).move(Direction.South);
			    break;
			case "MW":
				gameArea.avatars.get(gameArea.activeAvatar).move(Direction.West);
			    break;    
			case "CN":
				/*
				 * Valahogy meg kene tudni, hogy Reearcher-e es akkor check-elni.
				 * Zoli
				 */
			    break;
			case "CE":
			    // code block
			    break;
			case "CS":
			    // code block
			    break;
			case "CW":
			    // code block
			    break;    
			default:
			    break;
	        	}
		}
		
		/* Ez azert komment most, mert unreachable code (a while(1) miatt).
		 * Oda majd megy valami, ami figyeli a jatek veget.
		 * Zoli
		*/
		//System.out.println(">Controller.runGame()");
	}
	
	/*
	 * Kap egy csomag mezot, amiket behavaz.
	 * Zoli
	 */
	public void Storm(List<Field> fields) {
		System.out.println("<Controller.Storm()");
		
		Random rand = new Random();
		for(int i = 0; i < fields.size(); i++) {
			/*
			 * Igy 50% esellyel esik minden mezon a ho
			 */ 
	        	int probability = rand.nextInt(101);
	        	if(probability > 50) {
	        		fields.get(i).setSnow(1);
	        	}
		}
		
		System.out.println(">Controller.Storm()");
	}
	
	public static void main(String[] args) {
        System.out.println("A legjobb targy a Projlab!! -help ;)");
        startGame();
    }
	
}
