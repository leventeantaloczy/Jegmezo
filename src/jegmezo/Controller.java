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
	public static int tempCapacity;
	
	public Controller(int numofplayers) {
		this.numberOfPlayers = numofplayers;
	}
	
	public static void startGame(boolean init) throws IOException {
		System.out.println("<Controller.startGame()");
		
		gameEnder = new GameEnder();
		gameArea = new GameArea(numberOfPlayers, gameEnder);
		//scene 1: adat bek�r�se
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
			case "FOOD":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
					break;
			case "GUN":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}		
				break;
			case "FSHOVEL":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "SHOVEL":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "CARTRIDGE":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "WETSUIT":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "ROPEN":
					gameArea.avatars.get(gameArea.activeAvatar).useRope(Direction.North);
				break;
			case "ROPES":
					gameArea.avatars.get(gameArea.activeAvatar).useRope(Direction.South);
				break;
			case "ROPEW":
					gameArea.avatars.get(gameArea.activeAvatar).useRope(Direction.West);
				break;
			case "ROPEE":
					gameArea.avatars.get(gameArea.activeAvatar).useRope(Direction.East);
				break;
			case "FLARE":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "TENT":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).useItem(command);
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPFOOD":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Food");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
					break;
			case "DROPGUN":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Gun");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}		
				break;
			case "DROPFSHOVEL":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("fShovel");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPSHOVEL":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Shovel");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPCARTRIDGE":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Cartridge");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPWETSUIT":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("WetSuit");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPROPE":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Rope");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}				
				break;
			case "DROPTENT":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Tent");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "DROPFLARE":
				try {
					gameArea.avatars.get(gameArea.activeAvatar).dropItem("Flare");
				} catch (NumberFormatException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			case "RESN":
				tempCapacity = gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.North);
				break;
			case "RESS":
				tempCapacity = gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.South);
				break;
			case "RESW":
				tempCapacity = gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.West);
				break;
			case "RESE":
				tempCapacity = gameArea.avatars.get(gameArea.activeAvatar).specialMove(Direction.East);
				break;
			default:
				System.out.println("Hibas az input");
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
			 * Igy 	0% esellyel esik minden mezon a ho
			 */ 
	        	int probability = rand .nextInt(101);
	        	if(probability < 3) {
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