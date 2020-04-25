package jegmezo.fields;

import java.util.Random;
import jegmezo.Shelter;
import jegmezo.avatars.Avatar;
import jegmezo.items.EmptyItem;

public class UnstableIce extends Field{
	
	
	public UnstableIce() {
		Random rand = new Random();
		this.kills = false;
		// (0, vagy 1) + 1 = 1, vagy 2
		//capacity = rand.nextInt(2) + 1;
		capacity = 1;
	}
	
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
	
	public void flip() {
		System.out.println("<UnstableIce.flip()");
		
		this.kills = true;
		this.item = new EmptyItem();
 		this.setShelter(Shelter.None);
 		this.setSnow(0);
		
		System.out.println(">UnstableIce.flip()");	
	}
}
