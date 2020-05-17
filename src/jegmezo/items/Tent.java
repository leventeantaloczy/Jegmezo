package jegmezo.items;

import java.io.IOException;

import graphics.ItemGraphics;
import javafx.scene.image.Image;
import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Tent extends Item{
	
	/**
	 * Tent konstruktora:
	 * Nevet es a fontossagat hamisra allitja
	 * 
	 * @param _name Ezt allitja be nevnek / azonositonak
	 */
	public Tent(String _name) throws IOException{
		super(_name);
		this.important = false;
		this.graphics = new ItemGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/tent.png"), 29.6, 29.6, false, false));

	}
	
	/**
	 * Tent hasznalata:
	 * Adott avatar hasznalja fel a satrat, ha azon a
	 * fielden ahol epp all semmi nincs feallitja.
	 * 
	 * @param a Adott avatar, aki hasznalni fogja a satrat
	 */
	@Override
	public void use(Avatar a) {
		if(a.getField().getShelter() == Shelter.None) {
			a.getField().setShelter(Shelter.Tent);
			/*try {
				Test.bw.write("Tent used\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	/**
	 * Name - Getter
	 * 
	 * @return name
	 */
	@Override
	public String getName() {return name;}
}
