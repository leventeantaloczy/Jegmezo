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
	
	/*
	 * A 2 List-ben taroljuk a jatekban levo osszes Field-et es Avatart
	 * avatars: Ez alapjan lesznek a korok (tehat, hogy ki mikor es ki utan lephet)
	 * fieldsOnArea: Ez alapjan lesz, hogy hova dobunk havat
	 */
	List<Avatar> avatars = new ArrayList<Avatar>();	
	List<Field> fieldsOnArea = new ArrayList<Field>(); 
	/*
	 * Ebbenn taroljuk az aktiv Avatar indexet.
	 */
	int activeAvatar = 0;
	/*
	 * A jatekosok szama. A felhasznalo adhatja meg. Ehhez skalazodik a palya.
	 */
	private static int numberOfPlayers;
	
	/*
 	 * Konstruktor. 
 	 * Ha az init trua, akkor felhasznaloi bemenet alapjan pit palyat. 
 	 * Ha nem, akkor csak letrejon az attributumaival.
 	 */
	public GameArea(GameEnder gameEnder, boolean init) throws IOException {
		System.out.println("<GameArea.constructor()");
		
		/*
		* Egy jo kis init szekvencia. 
		* Felepit egy tesztpalyat field-ekbol, iteme-kbol ĂŠs tesz rajuk 2 avatart. 
		* Ezen kene maszkalni es figyelni, hogy jo-e amiket kiir. 
		* Zoli
		*/
		if(init) {
			numberOfPlayers = dataReader("How many players will try to escape?", 3, true);
			int researcherNumber = dataReader("How many of them has a paper in ice unstability researching?", numberOfPlayers, false);

			/*Ezutan ezt a numberOfPlayers-t oda kell adni az Avatar-oknak, 
			pontosabban egynlove tenni a durability valtozojukkal.*/

			fieldAdder(numberOfPlayers + 3);
			setterOfTheNeighbourhood();

			putStaffOnGameArea(researcherNumber, gameEnder);
		}
		
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
		int cnt = 0;
		for(int i = 0; i < widgth + 2; i++) {
			for(int j = 0; j < widgth + 2; j++) {
				if(i == 0) {
					Border border = new Border();
					border.id = cnt;
					cnt++;
					addField(border);
					System.out.println("added border as id " + border.id);
				}
				else if (i == widgth + 1) {
					Border border = new Border();
					border.id = cnt;
					cnt++;
					addField(border);
					System.out.println("added border as id " + border.id);
				}
				else if (j == 0) {
					Border border = new Border();
					border.id = cnt;
					cnt++;
					addField(border);
					System.out.println("added border as id " + border.id);
				}
				else if (j == widgth + 1) {
					Border border = new Border();
					border.id = cnt;
					cnt++;
					addField(border);
					System.out.println("added border as id " + border.id);
				}
				else if (j == 1) {
					HoleField holeField = new HoleField();
					holeField.id = cnt;
					cnt++;
					addField(holeField);
					System.out.println("added holefield as id " + holeField.id);
				}
				else if (j == widgth + 1 - 1) {
					UnstableIce unstableIce = new UnstableIce();
					unstableIce.id = cnt;
					cnt++;
					addField(unstableIce);
					System.out.println("added unstableIce as id " + unstableIce.id);
				}
				else {
					StableIce stableIce = new StableIce();
					stableIce.id = cnt;
					cnt++;
					addField(stableIce);
					System.out.println("added stableIce as id " + stableIce.id);
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
		for(int k=1; k < widgth + 1; k++) {
			for(int l=1; l < widgth + 1; l++) {
				// Eszaki szomszed
				fieldsOnArea.get(k*(widgth + 2) + l).setNeighbour(fieldsOnArea.get((k - 1)*(widgth + 2) + l));
				System.out.println("ezen field: " + fieldsOnArea.get(k*(widgth + 2) + l).id + "eszaki szomszedja: " + fieldsOnArea.get((k - 1)*(widgth + 2) + l).id);
				// Deli szomszed
				fieldsOnArea.get(k*(widgth + 2) + l).setNeighbour(fieldsOnArea.get((k + 1)*(widgth + 2) + l));
				System.out.println("ezen field: " + fieldsOnArea.get(k*(widgth + 2) + l).id + "deli szomszedja: " + fieldsOnArea.get((k + 1)*(widgth + 2) + l).id);
				
				// Keleti szomszed
				fieldsOnArea.get(k*(widgth + 2) + l).setNeighbour(fieldsOnArea.get((k)*(widgth + 2) + l + 1));
				System.out.println("ezen field: " + fieldsOnArea.get(k*(widgth + 2) + l).id + "keleti szomszedja: " + fieldsOnArea.get((k)*(widgth + 2) + l + 1).id);
				
				// Nyugati szomszed
				fieldsOnArea.get(k*(widgth + 2) + l).setNeighbour(fieldsOnArea.get((k)*(widgth + 2) + l - 1));
				System.out.println("ezen field: " + fieldsOnArea.get(k*(widgth + 2) + l).id + "nyugati szomszedja: " + fieldsOnArea.get((k)*(widgth + 2) + l - 1).id);
				
			}
		}
		
		System.out.println(">GameArea.setterOfTheNeighbourhood()");
	}
	
	private void putStaffOnGameArea(int researcherNumber, GameEnder gameEnder) throws IOException {
		System.out.println("<GameArea.putStaffOnGameArea()");

		int i;
		int width = numberOfPlayers + 3;
		for(i = 0; i < researcherNumber; i++) {
			String name = "r" + i;
			Researcher researcher = new Researcher(name);
			fieldsOnArea.get((width + 2) + 2 + i).avatars.add(researcher);
			researcher.field = fieldsOnArea.get((width + 2) + 2 + i);
			addAvatar(researcher);
			System.out.println("Researcher on id " + researcher.field.id);
			researcher.gameEnder = gameEnder;
		}
		for(int j = researcherNumber; j < numberOfPlayers; j++) {
			String name = "e" + (j - researcherNumber);
			Eskimo eskimo = new Eskimo(name);
			fieldsOnArea.get((width + 2) + 2 + j).avatars.add(eskimo);
			eskimo.field = fieldsOnArea.get((width + 2) + 2 + j);
			eskimo.gameEnder = gameEnder;
			addAvatar(eskimo);
			//System.out.println("Eskimo");
			System.out.println("Eskimo on id " + eskimo.field.id);
		}
		WetSuit wetSuit = new WetSuit();
		Flare flare = new Flare();
		Food food = new Food();
		Shovel shovel = new Shovel();
		Rope rope = new Rope();
		Cartridge cartridge = new Cartridge();
		Gun gun = new Gun();
		Tent tent = new Tent();
		int k = 0;
		fieldsOnArea.get((width + 2) + 2 + k).item = tent; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = wetSuit; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = flare; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = food; k += 5;
		fieldsOnArea.get((width + 2) + 2 + k).item = shovel; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = rope; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = cartridge; k++;
		fieldsOnArea.get((width + 2) + 2 + k).item = gun; k++;
		
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
	
	public void addAvatar(Avatar a) {
		System.out.println("<GameArea.addAvatar()");
		avatars.add(a);
		System.out.println(">GameArea.addAvatar()");
	}
	
	/*
	 * Ez valt aktiv Avatart a tömbben
	 * Benedek
	 */
	public void changeActiveAvatar() {
		System.out.println(">>changeActiveAvatar");
		if((this.avatars.get(activeAvatar).EndTurn == true) || (this.avatars.get(activeAvatar).field.getKills() == true) ) {
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
		System.out.println("<<changeActiveAvatar");
	}

	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
}
