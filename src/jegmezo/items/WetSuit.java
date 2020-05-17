package jegmezo.items;

import java.io.IOException;

import graphics.ItemGraphics;
import javafx.scene.image.Image;
import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class WetSuit extends Item{
	
	/**
	 * WetSuit konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet. 
	 *
	 * @param _name Beallitja erre a nevet / azonositot
	 */
	public WetSuit(String _name) throws IOException{
		super(_name);
		this.important = false;
		this.graphics = new ItemGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/Wetsuit.png"), 29.6, 29.6, false, false));

	}
	
	/**
	 * WetSuit hasznalata:
	 * Beallitodik, hogy az adott avatar viseli ezt az itemet,
	 * igy az a vizbeeseskor nem hal meg.
	 * 
	 * @param a Adott avatar, aki majd felveszi / hasznalja
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<WetSuit.use()");
		a.wearsWetsuit = true;
		/*try {
			Test.bw.write("WetSuit used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(">WetSuit.use()");
	}
	
	/**
	 * Name - Getter
	 * 
	 * @return name
	 */
	@Override
	public String getName() {return name;}

}
