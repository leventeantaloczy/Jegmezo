package jegmezo.fields;

import java.io.IOException;

import graphics.FieldGraphics;
import javafx.scene.image.Image;
import jegmezo.Test;

public class StableIce extends Field{
	
	/**
	 * StableIce konstruktora:
	 * Beallitja a kills-t hamis ertekre
	 */
	public StableIce() {
		this.kills = false;
		System.out.println("graphicsStableice");
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
	}
	
	/**
	 * StableIce konstruktora:
	 * Beallitja a nevet, kills-t hamisra
	 * 
	 * @param _name Erre a nevre fogja beallitani
	 */
	public StableIce(String _name) throws IOException {
		super(_name);
		this.kills = false;
		this.graphics = new FieldGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/hole.png"), 88.8, 88.8, false, false), this);
		//Test.bw.write(this.name + " created (StableIce) \n");
	}
}
