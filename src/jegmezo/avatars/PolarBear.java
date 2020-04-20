package jegmezo.avatars;

import java.util.Random;

import jegmezo.Direction;
import jegmezo.fields.Field;

public class PolarBear extends Avatar{

	public PolarBear(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int specialMove() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void move(Direction d) {
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
		
	}

}
