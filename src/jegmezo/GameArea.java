package jegmezo;
import java.util.List;

import jegmezo.avatars.*;
//import javafx.scene.layout.Border;
import jegmezo.fields.*;
import jegmezo.items.*;

public class GameArea {
	
	private List<Avatar> avatars;	//Ez alapján lesznek a körök (tehát, hogy ki mikor és ki után léphet
	private List<Field> fieldsOnArea;
	
	public GameArea() {
		System.out.println("<GameArea.constructor()");
		
		/*
		* Egy jo kis init szekvencia. 
		* Felepit egy tesztpalyat field-ekbol, iteme-kbol és tesz rajuk 2 avatart. 
		* Ezen kene maszkalni es figyelni, hogy jo-e amiket kiir. 
		* Zoli
		*/
		System.out.println("Creating and adding different tipes of fields for skeletoning purpose");
		
		HoleField holeField = new HoleField();
		StableIce stableIce1 = new StableIce();
		StableIce stableIce2 = new StableIce();
		StableIce stableIce3 = new StableIce();
		StableIce stableIce4 = new StableIce();
		StableIce stableIce5 = new StableIce();
		StableIce stableIce6 = new StableIce();
		UnstableIce unstableIce = new UnstableIce();
		Border border1 = new Border();
		Border border2 = new Border();
		Border border3 = new Border();
		Border border4 = new Border();
		Border border5 = new Border();
		Border border6 = new Border();
		Border border7 = new Border();
		Border border8 = new Border();
		Border border9 = new Border();
		
		addField(holeField);
		addField(stableIce1);
		addField(stableIce2);
		addField(stableIce3);
		addField(stableIce4);
		addField(stableIce5);
		addField(stableIce6);
		addField(unstableIce);
		addField(border1);
		addField(border2);
		addField(border3);
		addField(border4);
		addField(border5);
		addField(border5);
		addField(border6);
		addField(border7);
		addField(border8);
		addField(border9);
		
		System.out.println("Creating and adding as many avatars as a proper test needs");

		Eskimo eskimo = new Eskimo();
		Researcher researcher = new Researcher();
		
		addAvatar(eskimo);
		addAvatar(researcher);
		
		System.out.println("Putting avatars on Fields");
		
		eskimo.field = unstableIce;
		researcher.field = stableIce4;
		
		System.out.println("Setting up the neighbourhood");
		
		holeField.setNeighbour(border1);
		holeField.setNeighbour(unstableIce);
		holeField.setNeighbour(stableIce1);
		//Nincs nyugati szomszéd, mert minek
		stableIce1.setNeighbour(border2);
		stableIce1.setNeighbour(stableIce3);
		stableIce1.setNeighbour(stableIce2);
		stableIce1.setNeighbour(holeField);
		stableIce2.setNeighbour(border3);
		stableIce2.setNeighbour(stableIce4);
		stableIce2.setNeighbour(border4);
		stableIce2.setNeighbour(stableIce1);
		unstableIce.setNeighbour(holeField);
		unstableIce.setNeighbour(stableIce5);
		unstableIce.setNeighbour(stableIce3);
		//Nincs nyugati szomszéd, mert minek
		stableIce3.setNeighbour(stableIce1);
		stableIce3.setNeighbour(stableIce6);
		stableIce3.setNeighbour(stableIce4);
		stableIce3.setNeighbour(unstableIce);
		stableIce4.setNeighbour(stableIce2);
		stableIce4.setNeighbour(border6);
		stableIce4.setNeighbour(border5);
		stableIce4.setNeighbour(stableIce3);
		stableIce5.setNeighbour(unstableIce);
		stableIce5.setNeighbour(border7);
		stableIce5.setNeighbour(stableIce6);
		//Nincs nyugati szomszéd, mert minek
		stableIce6.setNeighbour(stableIce3);
		stableIce6.setNeighbour(border8);
		stableIce6.setNeighbour(border6);
		stableIce6.setNeighbour(stableIce5);
		
		System.out.println("Creating and putting items on Fields");
		
		WetSuit wetSuit = new WetSuit();
		Flare flare = new Flare();
		Food food = new Food();
		Shovel shovel = new Shovel();
		Rope rope = new Rope();
		Cartridge cartridge = new Cartridge();
		Gun gun = new Gun();
		
		stableIce1.item = wetSuit;
		stableIce2.item = flare;
		unstableIce.item = food;
		stableIce3.item = shovel;
		stableIce4.item = rope;
		stableIce5.item = cartridge;
		stableIce6.item = gun;
		
		System.out.println(">GameArea.constructor()");
	}
	
	public void addField(Field f) {
		System.out.println("<GameArea.addField()");
		System.out.println(">GameArea.addField()");
	}
	
	public void addAvatar(Avatar a) {
		System.out.println("<GameArea.addAvatar()");
		System.out.println(">GameArea.addAvatar()");
	}
}
