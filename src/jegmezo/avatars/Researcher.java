package jegmezo.avatars;
import jegmezo.fields.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import graphics.AvatarGraphics;
import javafx.scene.image.Image;
import jegmezo.Direction;

public class Researcher extends Avatar{
	
	static int researcherCounter = 1;
	
	/**
	 * Researcher konstruktora:
	 * Beallitja a nevet es az activityPoints-ot 4-re allitja
	 * 
	 * @param _name Beallitja a researcher nevet
	 */
	public Researcher(String _name) throws IOException {
		super(_name); 
		this.healthPoints = 4;
		this.graphics = new AvatarGraphics(new Image(getClass().getClassLoader().getResourceAsStream("resources/researcher" + researcherCounter + ".png"), 29.6, 29.6, false, false));
		researcherCounter++;
		/*try {
			Test.bw.write(this.name + " created\n");
		}catch(NullPointerException e) {
			System.out.println("NullPointerException: " + e);
		}*/
	}
	
	/*
	 * A d iranyu mezot leelenorzi és visszater annak kapacitas ertekevel
	 * Levente
	 */
	
	/**
	 * Researcher fieldet csekkol:
	 * Megnez egy szomszedos mezot.
	 * 
	 *  @return Beallitva
	 */
	public int specialMove(){
		System.out.println("<Researcher.checkField()");
		
		Field f = new StableIce(); 
		
		/*try {
			Test.bw.write(this.name + " checked " + f.getName() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("Melyik iranyba?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String direction = br.readLine();
			switch(direction.toLowerCase()) {
				case "n":{
					f = field.getNeighbour(Direction.North);
					break;
				}
				case "s":{
					f = field.getNeighbour(Direction.South);
					break;
				}
				case "e":{
					f = field.getNeighbour(Direction.East);
					break;
				}
				case "w":{
					f = field.getNeighbour(Direction.West);
					break;
				}
				default:
					System.out.println("Helytelen");
					break;
			}
		}catch(IOException e){
			
		}
		
		this.setActivity(1);
		
		System.out.println(">Researcher.checkField()");
		return f.getCapacity();
	}
	
}
