package jegmezo.items;

import jegmezo.avatars.Avatar;

public class EmptyItem extends Item{
	
	public EmptyItem(){
		this.important = false;
	}
	
	/*
	 * emptyItem nem fog semmit sem csinálni
	 * Levente
	 */
	
	public void use(Avatar a) {
		System.out.println("<EmptyItem.use()");
		System.out.println(">EmptyItem.use()");
		return;
	}
}
