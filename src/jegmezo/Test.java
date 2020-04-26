package jegmezo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import jegmezo.avatars.Eskimo;
import jegmezo.avatars.PolarBear;
import jegmezo.avatars.Researcher;
import jegmezo.avatars.Avatar;
import jegmezo.fields.*;



public class Test {
	public static BufferedWriter bw;
	GameEnder ender = new GameEnder();
	GameArea gamearea;// = new GameArea(ender, true);
//	private String[] initTest() {
//		//TODO letrehozni a dolgokat 
//		
//		//return;
//	}
	
	private Avatar Avatar(String str, String name) throws IOException {
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
		for(Avatar a : gamearea.avatars) {
			if(a.getName().equals(name))
				System.out.println(a.getName());
				return a;
		}
		return null;
	}
	
	private Field findField(String name) {
		for(Field f : gamearea.fieldsOnArea) {
			if(f.getName().equals(name))
				return f;
		}
		return null;
	}
	
	private void Move(String name, String where) throws IOException {
		bw.write(name + " ");
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
	}
	
	public void evaluateTest(BufferedReader br, String fileName) throws IOException {
		bw = new BufferedWriter(new FileWriter(fileName, true));
		
		String st = null;
		while ((st = br.readLine()) != null) {
			String[] command = st.split(" ");

			switch (command[0].toLowerCase()) {
				case "init":
					//TODO: initTest();
					break;
				case "avatar":
					gamearea.avatars.add(Avatar(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "field":
					gamearea.fieldsOnArea.add(Field(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "move":
					Move(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "bind":
					Bind(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "place":
					Place(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "igloo":
					break;
				case "check":
					break;
				case "item":
					break;
				case "itemtofield":
					break;
				case "tobackpack":
					break;
				case "feed":
					break;
				case "snow":
					break;
				case "use":
					break;
				case "lunch":
					break;
				case "strom":
					break;
				case "freeze":
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
		 while(!fileName.equals("exit")) { 
			 FileReader fr = new FileReader(path + "/" + fileName); 
			 BufferedReader bread = new BufferedReader(fr);
			 String[] newName = fileName.split("\\.");
			 t.evaluateTest(bread, newName[0] + "Out." + newName[1]); 
			 fileName = br.readLine();
		 }
		  
		
	  }	

}
