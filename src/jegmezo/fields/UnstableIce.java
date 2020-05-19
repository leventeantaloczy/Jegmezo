package jegmezo.fields;

import java.io.IOException;
import java.util.Random;

import graphics.FieldGraphics;
import javafx.scene.image.Image;
import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.items.EmptyItem;

public class UnstableIce extends Field{
	
	/**
	 * UnstableIce konstruktora 
	 */
	public UnstableIce() {
		Random rand = new Random();
		this.kills = false;
		// (0, vagy 1) + 1 = 1, vagy 2
		capacity = rand.nextInt(4) + 1;
		System.out.println("graphicsUnstable");
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/Ice.png"), 88.8, 88.8, false, false), this);

	}
	
	/**
	 * UnstableIce konstruktora
	 * 
	 * @param _name Erre allitja az UnstableIce nevet
	 */
	public UnstableIce(String _name) throws IOException {
		super(_name);
		Random rand = new Random();
		this.kills = false;
		capacity = rand.nextInt(2) + 1;
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/Ice.png"), 88.8, 88.8, false, false), this);

		//Test.bw.write(this.name + " created (UnstableIce) \n");
	}
	
	/**
	 * Avatar hozzadas:
	 * Hozzaadja az adott avatart az UnstableIce-hoz,
	 * ha annak kapacitasa kisebb lesz igy mint ahanyan rajta allnak, megfordul 
	 * 
	 * @param a Az elhelyezendo avatar
	 */
	@Override
	public void addAvatar(Avatar a) {
		System.out.println("<Field.addAvatar()");
		
		avatars.add(a);
		System.out.println("avatars.size() = " + this.avatars.size());
		System.out.println("capacity = " + capacity);
		if(this.avatars.size() > capacity)
			flip();
		
		System.out.println(">Field.addAvatar()");
	}
	
	/**
	 * Fordulas:
	 * Az UnstableIce megfordul ha tul sokan vannak rajta,
	 * Az esetleg elotte rajta talalhato itemek pedig eltunnek -> EmptyItem lesz rajta
	 * Ez vonatkozik Tent-re, Igloo-ra es mindenre ami elotte rajta volt
	 */
	public void flip() {
		System.out.println("<UnstableIce.flip()");
		
		this.graphics.setImage(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false));
		this.kills = true;
		try {
			this.item = new EmptyItem("EmptyItem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		this.setShelter(Shelter.None);
 		this.setSnow(-100);
		this.graphics.refreshField();
		System.out.println(">UnstableIce.flip()");	
	}
}
