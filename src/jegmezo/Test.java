package jegmezo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import jegmezo.avatars.Eskimo;
import jegmezo.avatars.PolarBear;
import jegmezo.avatars.Researcher;
import jegmezo.fields.*;



public class Test {
	public static BufferedWriter bw;
	
//	private String[] initTest() {
//		//TODO letrehozni a dolgokat 
//		
//		//return;
//	}
	
	private void Avatar(String str, String name) throws IOException {
		if(str.equals("e")) {
			Eskimo eskimo = new Eskimo(name);
		}
		else if(str.equals("p")) {
			PolarBear bear = new PolarBear(name);
		}
		else if(str.equals("r")) {
			Researcher researcher = new Researcher(name);			//Okostony
		}
		else {
			bw.write("Nem jott letre " + name + " avatar\n");
		}
	}
	
	private void Field(String type, String name) throws IOException {
		if(type.equals("s")) {
			StableIce sIce = new StableIce(name);
		}
		else if(type.equals("u")) {
			UnstableIce uIce = new UnstableIce(name);
		}
		else if(type.equals("h")) {
			HoleField hField = new HoleField(name); 
		}
		else if(type.equals("b")) {
			Border border = new Border(name);	
		}
		else {
			bw.write("Nem jott letre " + name + " field\n");
		}
	}
	
	public void evaluateTest(BufferedReader br, String fileName) throws IOException {
		bw = new BufferedWriter(new FileWriter(fileName, true));
		
		String st = null;
		while ((st = br.readLine()) != null) {
			String[] command = st.split(" ");

			switch (command[0].toLowerCase()) {
			case "init":
				//initTest();
				break;
			case "avatar":
				Avatar(command[1].toLowerCase(), command[2].toLowerCase());
				break;
			case "field":
				Field(command[1].toLowerCase(), command[2].toLowerCase());
				break;
			case "move":
				break;
			case "bind":	
				break;
			case "take":
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
