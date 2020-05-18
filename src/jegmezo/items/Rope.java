package jegmezo.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import graphics.ItemGraphics;
import javafx.scene.image.Image;
import jegmezo.Direction;
import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class Rope extends Item{
	
	/**
	 * Rope konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet
	 * 
	 *  @param _name Erre a nevre allitja be a Rope nevet
	 */
	public Rope(String _name) throws IOException{
		super(_name);
		this.important = false;
		this.graphics = new ItemGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/rope.png"), 29.6, 29.6, false, false));

	}
	
	/**
	 * Name - Getter 
	 *
	 * @return name
	 */
	@Override
	public String getName() {return name;}
	
	/**
	 * Rope hasznalata:
	 * Az adott avatart menti meg a kotel
	 *  
	 *  @param a Ez az avatar lesz megmentve a Rope-pal
	 */
	@Override
	public void use(Avatar a, Direction d) {
		System.out.println("<Rope.use()");
		
		System.out.println("Melyik iranyba?");
		Field f;
		try {
			f = a.getField().getNeighbour(d);
			if(f.avatars.size() > 0) {
				for(Avatar av : f.avatars){
					Field fi = av.getField();
					av.getField().removeAvatar(av);
					av.setField(a.getField());
					av.getField().addAvatar(av);
					av.getField().getGraphics().refreshField();
					fi.getGraphics().refreshField();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(">Rope.use()");
	}

	@Override
	public void use(Avatar a) {
		// TODO Auto-generated method stub
		
	}

}