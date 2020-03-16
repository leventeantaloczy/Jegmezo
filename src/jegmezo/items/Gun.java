package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Gun extends Item{

	@Override
	public void use(Avatar a) {
		System.out.println("<Gun.use()");
		System.out.println(">Gun.use()");
		
	}

}
