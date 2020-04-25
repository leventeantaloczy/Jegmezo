package jegmezo.avatars;

import java.util.Random;

import jegmezo.Direction;
import jegmezo.fields.Field;

public class PolarBear extends Avatar{

	public PolarBear(String _name) {
		super(_name);
		this.healthPoints = 100;
	}

	@Override
	public int specialMove() {
		return 0;
	}
	
	public void move(Direction d) {
		System.out.println("<PolarBear.move()");
		Random rand = new Random();
		int way = rand.nextInt(2) + 0;
		
		Field f = field.getNeighbour(Direction.valueOf(way));
		
		if(f.accept()) {
			f.addAvatar(this);
			field.removeAvatar(this);
			if(!f.avatars.isEmpty()) {
				gameEnder.endGame();
			}
			this.setActivity(1);
		}
		System.out.println(">PolarBear.move()");
	}
	
		public void decrementDurability() {
		/*
		 * Nem hal meg a vizben.
		 * Zoli
		 */
	}
}
