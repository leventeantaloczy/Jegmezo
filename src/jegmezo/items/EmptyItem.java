package jegmezo.items;

import jegmezo.avatars.Avatar;

public class EmptyItem extends Item{
	
	/*
	 * emptyItem nem fog semmit sem csinálni
	 * Levente
	 */
	
	public void use(Avatar a) {
		System.out.println("<EmptyItem.use()");
		System.out.println(">EmptyItem.use()");
	}
}
