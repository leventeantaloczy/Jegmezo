package jegmezo.avatars;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import jegmezo.Direction;
import jegmezo.Test;
import jegmezo.fields.Field;

public class PolarBear extends Avatar{

	public PolarBear(String _name) throws IOException {
		super(_name);
		this.healthPoints = 100;
		this.setNPC(true);
		try {
			Test.bw.write(this.name + " created\n");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}
	}

	@Override
	public int specialMove() {
		return 0;
	}
	
	public void move(Direction d) {
		System.out.println("<PolarBear.move()");
		System.out.println("ezen a mezon allok: " + this.field.id);
		Random rand = new Random();
		int way = rand.nextInt(4);
		Direction trueWay = Direction.valueOf(way);
		System.out.println("Direction: " + trueWay);
		
		if(field.getNeighbour(trueWay).accept()) {
			System.out.println("maki");
			try {
				field.getNeighbour(trueWay).addAvatar(this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			field.removeAvatar(this);
			if(!(field.getNeighbour(trueWay).avatars.isEmpty())) {
				try {
                    Test.bw.write(this.name + " ate avatar(s) on this field: " + field.getName() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
				gameEnder.endGame();
			}
			field = field.getNeighbour(trueWay);
			this.setActivity(1);
		}
		System.out.println("ezen a mezon allok: " + this.field.id);
		System.out.println(">PolarBear.move()");
	}
	
	public void decrementDurability() {
		/*
		 * Nem hal meg a vizben.
		 * Zoli
		 */
	}
}
