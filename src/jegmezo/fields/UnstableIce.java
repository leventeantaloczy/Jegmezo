package jegmezo.fields;

public class UnstableIce extends Field{
	
	public UnstableIce() {
		Random rand = new Random();
		this.kills = false;
		// (0, vagy 1) + 1 = 1, vagy 2
		capacity = rand.nextInt(2) + 1;
	}
	
	public void addAvatar(Avatar a) {
		System.out.println("<Field.addAvatar()");
		
		avatars.add(a);
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
