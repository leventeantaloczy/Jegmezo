package jegmezo.avatars;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import graphics.AvatarGraphics;
import javafx.scene.image.Image;
import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.fields.Field;

public class Eskimo extends Avatar{
	
	static int eskimoCounter = 1;

	/**
	 * Eskimo konstruktora:
	 * Az activityPoints-ot 5-re alltija
	 * es beallitja a nevet is.
	 *
	 * @param _name Az avatar neve
	 */
	public Eskimo(String _name) throws IOException{
		super(_name);
		this.healthPoints = 5;
		this.graphics = new AvatarGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/eskimo1.png"), 29.6, 29.6, false, false));
		System.out.println("elso");
		eskimoCounter++;
		/*try {
			Test.bw.write(this.name + " created\n");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}*/
	}

	/**
	 * Eskimo iglut epit:
	 * Beallitja a az adott mezore az iglut
	 *
	 * @return Beallitva
	 */
	public int specialMove() {
		System.out.println("<Eskimo.build()");
		field.setShelter(Shelter.Igloo);
		this.setActivity(1);
		System.out.println(">Eskimo.build()");
		return 1;
	}


}
