package jegmezo.fields;

import java.io.IOException;
import java.util.Random;
import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.items.EmptyItem;

public class UnstableIce extends Field{
	
	
	public UnstableIce() {
		Random rand = new Random();
		this.kills = false;
		// (0, vagy 1) + 1 = 1, vagy 2
		capacity = rand.nextInt(2) + 1;

	}
	
	public UnstableIce(String _name) throws IOException {
		super(_name);
		Random rand = new Random();
		this.kills = false;
		capacity = rand.nextInt(2) + 1;
		Test.bw.write(this.name + " created\n");
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
