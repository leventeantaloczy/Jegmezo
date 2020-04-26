package jegmezo.items;

import java.util.List;

import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;
import jegmezo.GameArea;
import jegmezo.GameEnder;

public class Gun extends Item{

	
	public Gun(String _name){
		super(_name);
		this.important = true;
		
	}
	
	@Override
	public String getName() {return name;}
	
	/*
	 * Elsütni csak akkor tudja, ha ennek az a Avatarnak a taaskajaban van Cartridge es Flare
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Gun.use()");
		
		List<Item> items= a.getBackpack();
		int importantCounter = 0;
		Field field = a.getField();
		
		for(Item item : items) {
			if(item.getImportant())
				importantCounter++;
		}

		boolean end =(importantCounter > 2 && field.avatars.size() == GameArea.getNumberOfPlayers()) ?  true : false;
		
		if(end) {
			GameEnder.endGame();
		}else {
			System.out.println("Requirements not satisfied");
		}
		
		System.out.println(">Gun.use()");
	}

}
