package jegmezo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jegmezo.avatars.Eskimo;
import jegmezo.avatars.PolarBear;
import jegmezo.avatars.Researcher;
import jegmezo.avatars.Avatar;
import jegmezo.fields.*;
import jegmezo.items.*;



public class Test {
	public static BufferedWriter bw;
	private List<Avatar> avatars = new ArrayList<Avatar>();	
	private List<Field> fieldsOnArea = new ArrayList<Field>();
	
	
//	private String[] initTest() {
//		//TODO letrehozni a dolgokat 
//		
//		//return;
//	}
	
	private Avatar avatar(String str, String name) throws IOException {
		if(str.equals("e")) {
			return new Eskimo(name);
		}
		else if(str.equals("p")) {
			return new PolarBear(name);
		}
		else if(str.equals("r")) {
			return new Researcher(name);
		}
		else {
			bw.write("Nem jott letre " + name + " avatar\n");
			return null;
		}
	}
	
	private Field Field(String type, String name) throws IOException {
		
		if(type.equals("s")) {
			return new StableIce(name);
		}
		else if(type.equals("u")) {
			return new UnstableIce(name);
		}
		else if(type.equals("h")) {
			return new HoleField(name); 
		}
		else if(type.equals("b")) {
			return new Border(name);	
		}
		else {
			bw.write("Nem jott letre " + name + " field\n");
			return null;
		}
	}
	
	private Avatar findAvatar(String name) {
		System.out.println("aaa");
		for(Avatar a : avatars) {
			if(a.getName().equals(name))
				return a;
		}
		
		return null;
	}
	
	private Field findField(String name) {
		for(Field f : fieldsOnArea) {
			if(f.getName().equals(name))
				return f;
		}
		return null;
	}
	
	private void Move(String name, String where) throws IOException {
		//bw.write(name + " ");
		findAvatar(name).move(Direction.valueOf(where));
	}
	/*
	 * beallitja a szomszedot, eloszor eszak majd del kelet nyugat 
	 */
	private void Bind(String field1, String field2) throws IOException {
		findField(field1).setNeighbour(findField(field2));
	}
	
	
	private void Place(String name, String field) throws IOException {
		findField(field).addAvatar(findAvatar(name));
		findAvatar(name).setField(findField(field));
	}
	
	private void specialmove(String _name){
		findAvatar(_name).specialMove();
	}
	
	private void item(String itemType, String itemName, String field) {
		Field f = findField(field);
		switch(itemType.toLowerCase()) {
			case "rope":
				f.item = new Rope(itemName);
				break;
			case "tent":
				f.item = new Tent(itemName);
				break;
			case "emptyitem":
				f.item = new EmptyItem(itemName);
				break;
			case "flare":
				f.item = new Flare(itemName);
				break;
			case "food":
				f.item = new Food(itemName);
				break;
			case "fragileshovel":
				f.item = new FragileShovel(itemName);
				break;
			case "gun":
				f.item = new Gun(itemName);
				break;
			case "shovel":
				f.item = new Shovel(itemName);
				break;
			case "wetsuit":
				f.item = new WetSuit(itemName);
				break;
			case "cartridge":
				f.item = new Cartridge(itemName);
				break;
			default:
				System.out.println("Not correct");
		}
		
		try {
			bw.write(itemName + " added to " + f.getName() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * amelyik mezon all azt az itemeet veszi fel
	 */
	private void tobackpack(String avatarName) {
		findAvatar(avatarName).addToBackpack();
	}
	
	private void feed(String avatarName) {
		try {
			findAvatar(avatarName).useItem();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void snow(String fieldName) {
		findField(fieldName).setSnow(1);
	}
	
	private void use(String itemName, String avatarName) {
		//TODO
	}
	
	public void evaluateTest(BufferedReader br, String fileName) throws IOException {
		bw = new BufferedWriter(new FileWriter(fileName));
		
		String st = null;
		while ((st = br.readLine()) != null) {
			String[] command = st.split(" ");

			switch (command[0].toLowerCase()) {
				case "init":
					//TODO: initTest();
					break;
				case "avatar":
					avatars.add(avatar(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "field":
					fieldsOnArea.add(Field(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "move":
					Move(command[1].toLowerCase(), command[2]);
					break;
				case "bind":
					Bind(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "place":
					Place(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "specialmove":
					specialmove(command[1].toLowerCase());
					break;
				case "item":
					item(command[1].toLowerCase(), command[2].toLowerCase(), command[3].toLowerCase());
					break;
				case "tobackpack":
					tobackpack(command[1].toLowerCase());
					break;
				case "feed":
					break;
				case "snow":
					snow(command[1].toLowerCase());
					break;
				case "use":
					break;
				case "lunch": //???ILYEN NEM KELL MERT HA A POLARBEAR MEZORE LEP AKKOR TORTENIK VALAMI
					break;
				case "strom": //???EHHEZ EGESZ JATEKOT FEL KELL EPITENI MERT CONTROLLER CSINALJA A STORMOT
					break;
				case "freeze": //???SET HEALTHPOINTS TO 0 ??? ez egy egesz teszt hogy elfogy a healthpointja akkor mi tortenik
					break;
				case "activity":
					break;
				case "shoot":
					break;
				case "help":
					break;
				case "setused":
					break;
				case "savetofile":
					break;
			default:
				System.out.println("Rossz parancs");
				bw.write("Rossz parancs\n");
				break;
			}
		}
		bw.close();
	}

	
	 public static void main(String[] args) throws IOException { 
		 String path = Paths.get("").toAbsolutePath().toString();
		 Test t = new Test(); 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String fileName = br.readLine();
		 try {
			 while(!fileName.equals("exit")) { 
				 FileReader fr = new FileReader(path + "/" + fileName); 
				 BufferedReader bread = new BufferedReader(fr);
				 String[] newName = fileName.split("\\.");
				 t.evaluateTest(bread, newName[0] + "Out." + newName[1]); 
				 fileName = br.readLine();
			 }
		 }catch (NullPointerException e) {
			System.out.println(e);
		}

		  
		
	  }	

}
