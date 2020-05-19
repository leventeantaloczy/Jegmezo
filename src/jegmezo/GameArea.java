package jegmezo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public List<Avatar> avatars = new ArrayList<Avatar>();	
	public List<Field> fieldsOnArea = new ArrayList<Field>(); 
	/*
	 * Ebbenn taroljuk az aktiv Avatar indexet.
	 */
	int activeAvatar = 0;
	/*
	 * A jatekosok szama. A felhasznalo adhatja meg. Ehhez skalazodik a palya.
	 */
	private static int numberOfPlayers = 1;
	
	/*
 	 * Konstruktor. 
 	 * Ha az init trua, akkor felhasznaloi bemenet alapjan pit palyat. 
 	 * Ha nem, akkor csak letrejon az attributumaival.
 	 */
	public GameArea(int numberOfPlayers, GameEnder gameEnder){
		System.out.println("<GameArea.constructor()");
		GameArea.numberOfPlayers = numberOfPlayers;
		init(gameEnder, true);
		System.out.println(">GameArea.constructor()");
	}
	

	
	public void init(GameEnder gameEnder, boolean init) {
		Random rand = new Random();
		
		
		/*
		* Egy jo kis init szekvencia. 
		* Felepit egy tesztpalyat field-ekbol, iteme-kbol Ês tesz rajuk 2 avatart. 
		* Ezen kene maszkalni es figyelni, hogy jo-e amiket kiir. 
		* Zoli
		*/
		if(init) {
			//numberOfPlayers = dataReader("How many players will try to escape?", 3, true);
			int researcherNumber = rand.nextInt(numberOfPlayers - 2) + 1;

			/*Ezutan ezt a numberOfPlayers-t oda kell adni az Avatar-oknak, 
			pontosabban egynlove tenni a durability valtozojukkal.*/

			fieldAdder(9);
			try {
				setterOfTheNeighbourhood();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				putStaffOnGameArea(researcherNumber, gameEnder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Field lerako.	
	 */
	private void fieldAdder(int widgth) {
	    Random rand = new Random();
		System.out.println("<GameArea.fieldAdder()");
		int cnt = 0;
		for(int i = 0; i < widgth + 2; i++) {
			for(int j = 0; j < widgth + 2; j++) {
				int probHole = rand.nextInt(101);
				System.out.println("ido huzas");
				System.out.println("meg ido huzas");
				int probUnstable = rand.nextInt(101);
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
		        //10%
				else if (probHole < 10) {
					HoleField holeField = new HoleField();
					holeField.id = cnt;
					cnt++;
					addField(holeField);
					System.out.println("added holefield as id " + holeField.id);
				}
				//30%
				else if (probUnstable < 20) {
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
	private void setterOfTheNeighbourhood() throws IOException {
		System.out.println("<GameArea.setterOfTheNeighbourhood()");
		// Lepheto resz szelessege es magassaga.
		int widgth = 9;
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
		int width = 9;
		for(i = 0; i < researcherNumber; i++) {
			String name = "r" + i;
			Researcher researcher = new Researcher(name);
			researcher.gameEnder = gameEnder;
			putrandomAvatar(researcher);
			System.out.println("Researcher on id " + researcher.getField().id);
			researcher.gameEnder = gameEnder;
		}
		for(int j = researcherNumber; j < numberOfPlayers; j++) {
			String name = "e" + (j - researcherNumber);
			Eskimo eskimo = new Eskimo(name);
			eskimo.gameEnder = gameEnder;
			putrandomAvatar(eskimo);
			System.out.println("Eskimo on id " + eskimo.getField().id);
		}
		
		for(int l = 0; l < (int) Math.ceil(numberOfPlayers / 2); l++ ) {
			String name = "b" + l;
			PolarBear bear = new PolarBear(name);
			bear.gameEnder = gameEnder;
			putrandomAvatar(bear);
			System.out.println("Bear on id " + bear.getField().id);
		}
		
		
		WetSuit wetSuit = new WetSuit("WetSuit");
		Flare flare = new Flare("Flare");
		Food food = new Food("Food");
		Shovel shovel = new Shovel("Shovel");
		Rope rope = new Rope("Rope");
		Cartridge cartridge = new Cartridge("Cartridge");
		Gun gun = new Gun("Gun");
		Tent tent = new Tent("Tent");
		FragileShovel fShovel = new FragileShovel("fShovel");
		
		putrandomField(wetSuit);
		putrandomField(flare);
		putrandomField(food);
		putrandomField(shovel);
		putrandomField(rope);
		putrandomField(cartridge);
		putrandomField(gun);
		putrandomField(tent);
		putrandomField(fShovel);

		
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
	 * Ez valt aktiv Avatart a t�mbben
	 * Benedek
	 */
	public void changeActiveAvatar() {
		System.out.println(">>changeActiveAvatar");
		if((this.avatars.get(activeAvatar).EndTurn == true) || (this.avatars.get(activeAvatar).getField().getKills() == true) ) {
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
	
	public int getActiveAvatar() {
		return activeAvatar;
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public void setNumberOfPlayers(int num) {
		numberOfPlayers = num;
	}
	private void putrandomField(Item item) {
		Random rand = new Random();
		boolean flag = true;
		System.out.println("put random field");
		System.out.println("barmi mas");
		while(flag) {
			int place = rand.nextInt(95) + 13;
			while(place % 11 == 0 || place % 11 == 10 || fieldsOnArea.get(place).getKills()) {
				place = rand.nextInt(95) + 13;
			}
			if(fieldsOnArea.get(place).item == null) {
				fieldsOnArea.get(place).item = item;
				flag = false;
			}
		}
	}
	
	private void putrandomAvatar(Avatar a) {
		Random rand = new Random();
		System.out.println("put random avatar");
		System.out.println("barmi mas");
		int place = rand.nextInt(95) + 13;
		while(place % 11 == 0 || place % 11 == 10 || fieldsOnArea.get(place).getKills() /*|| fieldsOnArea.get(place).avatars.isEmpty()*/) {
			place = rand.nextInt(95) + 13;
		}
		fieldsOnArea.get(place).avatars.add(a);
		try {
			a.setField(fieldsOnArea.get(place));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addAvatar(a);
	}
}