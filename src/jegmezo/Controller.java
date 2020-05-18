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
	public static int numberOfPlayers;
	public static String command = null; 
	
	public Controller(int numofplayers) {
		this.numberOfPlayers = numofplayers;
	}
	
	public static void startGame(boolean init) throws IOException {
		System.out.println("<Controller.startGame()");
		
		gameEnder = new GameEnder();
		gameArea = new GameArea(numberOfPlayers, gameEnder);
		//scene 1: adat bekérése
		/*if(init) {
			System.out.println("if init");
			runGame();
		}*/
		
		System.out.println(">Controller.startGame()");
	}
	
	/*
	 * Itt fog futni a jatek
	 */
	public void setCommand(String cmd) {
		Controller.command = cmd;
		System.out.println(command + " command");
		switch(command.toUpperCase()) {
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
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			case "DIG":
				System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
				gameArea.avatars.get(gameArea.activeAvatar).digForItem();;
			    break;
			case "D":
				System.out.println("Ezen avatar cselekszik: " + gameArea.avatars.get(gameArea.activeAvatar).getName());
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Hibas input");
				break;
       	}
		command = null;
		gameArea.changeActiveAvatar();
		Storm(gameArea.fieldsOnArea);
		System.out.println("gameArea.activeAvatar = " + gameArea.activeAvatar);
		while(gameArea.avatars.get(gameArea.activeAvatar).getNPC()) {
			Field tmp = gameArea.avatars.get(gameArea.activeAvatar).getField();
			gameArea.avatars.get(gameArea.activeAvatar).move(Direction.East);
			gameArea.avatars.get(gameArea.activeAvatar).getField().getGraphics().refreshField();
			tmp.getGraphics().refreshField();
			gameArea.changeActiveAvatar();
			System.out.println("gameArea.activeAvatar = " + gameArea.activeAvatar);
			Storm(gameArea.fieldsOnArea);
		}
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
			 * Igy 20% esellyel esik minden mezon a ho
			 */ 
	        	int probability = rand .nextInt(101);
	        	if(probability < 10) {
	        		fields.get(i).setSnow(1);
	        		fields.get(i).getGraphics().refreshField();
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
	public GameEnder getGameEnder() {
		return gameEnder;
	}
	
	/*
	 * Tivadar
	 */
	public int countItem(String itemname) {
    	int counter = 0;
    	if(!( gameArea.avatars.get(gameArea.getActiveAvatar()).getBackpack().isEmpty())) {
			for(int j = 0; j < gameArea.avatars.get(gameArea.getActiveAvatar()).getBackpack().size(); j++) {
				if(gameArea.avatars.get(gameArea.getActiveAvatar()).getBackpack().get(j).getName().contains(itemname)) {
					counter++;
				}
			}
		}
    	return counter;
    }
}