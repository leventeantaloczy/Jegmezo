package jegmezo.fields;

import java.io.IOException;

import graphics.FieldGraphics;
import javafx.scene.image.Image;


public class Border extends Field{
	
	/**
	 * Border konstruktora 
	 */
	public Border() {
		System.out.println("graphicsBorder");
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
	}
	
	/**
	 * Border konstruktora:
	 * Beallitja a nevet 
	 * 
	 * @param _name Beallitja a border nevet / azonositojat
	 */
	public Border(String _name) throws IOException {
		super(_name);
		//Test.bw.write(this.name + " created(Border) \n");
		System.out.println("graphicsBorder");
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
	}
	
	/**
	 * Accept:
	 * Border - false
	 *
	 * @return false
	 */
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println("border");
		/*try {
			Test.bw.write("Moved towards border\n");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.out.println(">Field.accept()");
		return false;
	}
}
