package jegmezo.fields;

import java.io.IOException;

import graphics.FieldGraphics;
import javafx.scene.image.Image;
import jegmezo.Test;

public class HoleField extends Field{
	
	/**
	 * HoleField konstruktora:
	 * Beallitja a kills-t igaz ertekre 
	 */
	public HoleField() {
		this.kills = true;
		System.out.println("graphicsHole");
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
	}
	
	/**
	 * HoleField konstruktora:
	 * Beallitja a nevet es a kills-t igazra allitja
	 * 
	 * @param _name HoleField neve / azonositoja erre lesz beallitva
	 */
	public HoleField(String _name) throws IOException {
		super(_name);
		this.kills = true;
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
		//Test.bw.write(this.name + " created (HoleField) \n");
	}
}
