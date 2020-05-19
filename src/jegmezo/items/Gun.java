package jegmezo.items;

import java.io.IOException;
import java.util.List;

import graphics.ItemGraphics;
import javafx.scene.image.Image;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;
import jegmezo.GameArea;
import jegmezo.GameEnder;
import jegmezo.Test;

public class Gun extends Item{

	/**
	 * Gun konstruktora:
	 * Beallitja a fontossagot igazra es a nevet
	 * 
	 *  @param _name Erre allitja be a Gun nevet
	 */
	public Gun(String _name) throws IOException{
		super(_name);
		this.important = true;
		this.graphics = new ItemGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/gun.png"), 29.6, 29.6, false, false));
		
	}
	
	
	
	/**
	 * Name - Getter
	 * 
	 *  @return name
	 */
	@Override
	public String getName() {return name;}
	
	/**
	 * Gun hasznalata:
	 * Adott avatar elsuti a fegyvert,
	 * ha megvannak hozza a hozzatartozo darabok (Cartridge, Flare),
	 * megkezdodik az EndGame. Egyebkent semmi nem tortenik.
	 * 
	 *  @param a Ez az avatar suti el.
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
			/*try {
				Test.bw.write("Gun used\n");
			} catch (IOException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}*/
			GameEnder.setWin(true);
			GameEnder.endGame();
		}else {
			/*try {
				Test.bw.write("Nothing happened\n");
			} catch (IOException e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println("Requirements not satisfied");
		}
		
		System.out.println(">Gun.use()");
	}

}
