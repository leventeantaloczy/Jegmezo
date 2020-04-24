package jegmezo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import jegmezo.avatars.*;
import jegmezo.fields.*;
import jegmezo.items.*;

public class GameArea {
	/*packet lathatosag*/
	
	List<Avatar> avatars = new ArrayList<Avatar>();	//Ez alapjan lesznek a korok (tehat, hogy ki mikor es ki utan lephet)
	List<Field> fieldsOnArea = new ArrayList<Field>(); //Ez alapjan lesz, hogy hova dobunk havat
	int activeAvatar = 0;
	private static int numberOfPlayers;
	
	
	public GameArea(GameEnder gameEnder) {
		System.out.println("<GameArea.constructor()");
		
		/*
		* Egy jo kis init szekvencia. 
		* Felepit egy tesztpalyat field-ekbol, iteme-kbol ĂŠs tesz rajuk 2 avatart. 
		* Ezen kene maszkalni es figyelni, hogy jo-e amiket kiir. 
		* Zoli
		*/
		
		numberOfPlayers = dataReader("How many players will try to escape?", 3, true);
		int researcherNumber = dataReader("How many of them has a paper in ice unstability researching?", numberOfPlayers, false);
		
		/*Ezutan ezt a numberOfPlayers-t oda kell adni az Avatar-oknak, 
		pontosabban egynlove tenni a durability valtozojukkal.*/
		
		fieldAdder(numberOfPlayers + 3);
		setterOfTheNeighbourhood();

		putStaffOnGameArea(researcherNumber, gameEnder);
		
		System.out.println(">GameArea.constructor()");
	}
	
	private int dataReader(String question, int constraint, boolean lowerConstraint) {
		System.out.println("<GameArea.dataReader()");
		
		System.out.println(question);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int toReturn = 0;
		try {
			toReturn = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		if(lowerConstraint) {
			while(toReturn < constraint) {
				System.out.println("I'm afraid it won't work... Give a lower number, please");
				try {
					toReturn = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			while(toReturn > constraint) {
				System.out.println("I'm afraid it won't work... Give a higher number, please");
				try {
					toReturn = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">GameArea.dataReader()");
		return toReturn;
	}
	
	/*
	 * Field lerako.
	 */
	private void fieldAdder(int widgth) {
		System.out.println("<GameArea.fieldAdder()");
		for(int i=0; i < widgth - 1 + 2; i++) {
			for(int j=0; j < numberOfPlayers + 3 - 1 + 2; j++) {
				if(i == 0) {
					Border border = new Border();
					addField(border);
				}
				else if (i == numberOfPlayers + 3 - 1 + 2) {
					Border border = new Border();
					addField(border);
				}
				else if (j == 0) {
					Border border = new Border();
					addField(border);
				}
				else if (j == numberOfPlayers + 3 - 1 + 2) {
					Border border = new Border();
					addField(border);
				}
				else if (j == 1) {
					HoleField holeField = new HoleField();
					addField(holeField);
				}
				else if (j == widgth - 1 + 2 - 1) {
					UnstableIce unstableIce = new UnstableIce();
					addField(unstableIce);
				}
				else {
					StableIce stableIce = new StableIce();
					addField(stableIce);
				}
			}
		}
		
		System.out.println(">GameArea.fieldAdder()");
	}
	
	/*
	 * Szomszedossagok beallitasa. A Bordereknek nem allitjuk be a szomszedait, mert kopok ra.
	 * Zoli
	 */
	private void setterOfTheNeighbourhood() {
		System.out.println("<GameArea.setterOfTheNeighbourhood()");
		// Lepheto resz szelessege es magassaga.
		int widgth = numberOfPlayers + 3;
		for(int k=1; k < widgth - 1; k++) {
			for(int l=1; l < widgth - 1; l++) {
				// Eszaki szomszed
				fieldsOnArea.get(k*widgth + l).setNeighbour(fieldsOnArea.get((k - 1)*widgth + l));
				// Deli szomszed
				fieldsOnArea.get(k*widgth + l).setNeighbour(fieldsOnArea.get((k + 1)*widgth + l));
				// Keleti szomszed
				fieldsOnArea.get(k*widgth + l).setNeighbour(fieldsOnArea.get((k)*widgth + l + 1));
				// Nyugati szomszed
				fieldsOnArea.get(k*widgth + l).setNeighbour(fieldsOnArea.get((k)*widgth + l - 1));
			}
		}
		
		System.out.println(">GameArea.setterOfTheNeighbourhood()");
	}
	
	private void putStaffOnGameArea(int researcherNumber, GameEnder gameEnder) {
		System.out.println("<GameArea.putStaffOnGameArea()");

		int i;
		for(i = 0; i < researcherNumber; i++) {
			Researcher researcher = new Researcher();
			fieldsOnArea.get(numberOfPlayers + 2 + 2 + i).avatars.add(researcher);
			researcher.field = fieldsOnArea.get(numberOfPlayers + 2 + 2 + i);
			addAvatar(researcher);
			researcher.gameEnder = gameEnder;
		}
		for(int j = researcherNumber; j < numberOfPlayers; j++) {
			Eskimo eskimo = new Eskimo();
			fieldsOnArea.get(numberOfPlayers + 2 + 2 + i + j).avatars.add(eskimo);
			eskimo.field = fieldsOnArea.get(numberOfPlayers + 2 + 2 + i + j);
			eskimo.gameEnder = gameEnder;
			addAvatar(eskimo);
		}
		WetSuit wetSuit = new WetSuit();
		Flare flare = new Flare();
		Food food = new Food();
		Shovel shovel = new Shovel();
		Rope rope = new Rope();
		Cartridge cartridge = new Cartridge();
		Gun gun = new Gun();
		Tent tent = new Tent();
		int k = 1;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = tent; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = wetSuit; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = flare; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = food; k += 5;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = shovel; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = rope; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = cartridge; k++;
		fieldsOnArea.get(numberOfPlayers + 2 + 2 + k).item = gun; k++;
		
		for(int l = 0; l < fieldsOnArea.size(); l++) {
			fieldsOnArea.get(l).setDurability(avatars.size());
		}
		for(int l = 0; l < avatars.size(); l++) {
			avatars.get(l).setDurability(avatars.size());
		}
		
		System.out.println(">GameArea.putStaffOnGameArea()");		
	}
	
	private void addField(Field f) {
		System.out.println("<GameArea.addField()");
		fieldsOnArea.add(f);
		System.out.println(">GameArea.addField()");
	}
	
	private void addAvatar(Avatar a) {
		System.out.println("<GameArea.addAvatar()");
		avatars.add(a);
		System.out.println(">GameArea.addAvatar()");
	}
	
	/*
	 * Ez valt aktiv Avatart a tömbben
	 * Benedek
	 */
	public void changeActiveAvatar() {
		if(this.avatars.get(activeAvatar).EndTurn = true) {
			this.avatars.get(activeAvatar).setEndTurn();
			this.activeAvatar++;
			
			if(activeAvatar >= this.avatars.size())
				activeAvatar = 0;
			
			for(Field f : fieldsOnArea) {
				if(f.decrementDurability())
					f.setDurability(avatars.size());
			}
			
			for(Avatar a : avatars) {
				a.decrementDurability();
			}
		}
	}

	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
}
