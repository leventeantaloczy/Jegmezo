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
		
		System.out.println("Creating and adding different tipes of fields as many times and as randomly as we later decide");
		
		HoleField holeField = new HoleField();
		StableIce stableIce = new StableIce();
		UnstableIce unstableIce = new UnstableIce();
		Border border = new Border();
		
		addField(holeField);
		addField(stableIce);
		addField(unstableIce);
		addField(border);
		
		System.out.println("Creating and adding as many avatars as many are needed");

		Eskimo eskimo = new Eskimo(5);
		Researcher researcher = new Researcher(4);
		
		addAvatar(eskimo);
		addAvatar(researcher);
		
		System.out.println("Putting avatars on Fields");
		
		eskimo.field = stableIce;
		researcher.field = unstableIce;
		
		System.out.println("Setting up the neighbourhood");
		
		/*
		* TODO
		* Ide a majdan megvalósított Field.setNeighbour()-t felhasználva
		* kéne felépíteni a térképen lévő Field-ek közti szomszédságokat
		* Zoli
		*/
		
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
