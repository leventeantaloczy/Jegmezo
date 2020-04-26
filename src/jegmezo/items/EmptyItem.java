package jegmezo.items;

import jegmezo.avatars.Avatar;

public class EmptyItem extends Item{
	
	public EmptyItem(String _name){
		super(_name);
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
	
	@Override
	public String getName() {return name;}
}
