package jegmezo.avatars;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import graphics.AvatarGraphics;
import javafx.scene.image.Image;
import jegmezo.Direction;
import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.fields.Field;

public class PolarBear extends Avatar{

	/**
	 * PolarBear konstruktora
	 * Beallitja a nevet, eleteropontot, NPC-t
	 * 
	 * @param _name PolarBear neve / azonositoja
	 */
	public PolarBear(String _name) throws IOException {
		super(_name);
		this.healthPoints = 10000;
		this.setNPC(true);
		this.activityPoints = 1;
		
		this.graphics = new AvatarGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/medve.png"), 29.6, 29.6, false, false));

		/*try {
			Test.bw.write(this.name + " created\n");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}*/
	}

	/**
	 * A polarbear-nek nincsen specialis kepessege
	 * igy ez a fuggveny nem csinal semmit
	 * 
	 * @return 0
	 */
	@Override
	public int specialMove() {
		return 0;
	}
	
	/**
	 * PolarBear mozog:
	 * A maci elmozdul a megadott iranyba, ha arrafele
	 * van mezo.
	 * 
	 *  @param d Adott iranyba valo mozdulas
	 */
	public void move(Direction d) {
		System.out.println("<PolarBear.move()");
		System.out.println("ezen a mezon allok: " + this.field.id);
		Random rand = new Random();
		int way = rand.nextInt(4);
		Direction trueWay = Direction.valueOf(way);
		System.out.println("Direction: " + trueWay);
		
		if(!(field.getNeighbour(trueWay).avatars.isEmpty()) && field.getNeighbour(trueWay).getShelter() != Shelter.Igloo) {
			/*try {
                Test.bw.write(this.name + " ate avatar(s) on this field: " + field.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
			gameEnder.endGame();
		}
		
		if(field.getNeighbour(trueWay).accept()) {
			System.out.println("maki");
			try {
				field.getNeighbour(trueWay).addAvatar(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			field.removeAvatar(this);
			
			field = field.getNeighbour(trueWay);
			this.setActivity(1);
		}
		System.out.println("ezen a mezon allok: " + this.field.id);
		System.out.println(">PolarBear.move()");
	}
	
	/**
	 * Nem csinal semmit, mert a maci nem hal meg vizbeesve. 
	 */
	public void decrementDurability() {
		/*
		 * Nem hal meg a vizben.
		 * Zoli
		 */
	}
	
	@Override
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		this.activityPoints = 1;
		this.EndTurn = true;
		System.out.println(">Avatar.endTurn()");
	}
}
