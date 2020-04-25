package jegmezo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import jegmezo.avatars.Eskimo;
import jegmezo.avatars.PolarBear;
import jegmezo.avatars.Researcher;

public class Test {
//	private String[] initTest() {
//		//TODO letrehozni a dolgokat 
//		
//		//return;
//	}
	
	private String Avatar(String str,String name) {
		String vl = null;
		if(str.equals("e")) {
			Eskimo eskimo = new Eskimo(name);
			vl = "Eskimo letrejott";
		}
		if(str.equals("p")) {
			PolarBear bear = new PolarBear(name);
			vl = "PolarBear letrejott";
		}
		if(str.equals("r")) {
			Researcher reserchear = new Researcher(name);//Okostony
			vl = "Researcher letrejott";
		}
		return vl;
	}
	
	private void toFile(File f, String str) {
		
	}
	
	public void evaluateTest(BufferedReader br) throws IOException {

		while (br.readLine() != null) {
			String[] command = br.readLine().split(" ");

			switch (command[0].toLowerCase()) {
			case "init":
				//initTest();
				break;
			case "avatar":
				Avatar(command[1].toLowerCase(),command[2].toLowerCase());
				break;
			case "field":
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
				break;
			}
		}

	}

	
	 public static void main(String[] args) throws IOException { 
		 String path = Paths.get("").toAbsolutePath().toString();
		  
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String fileName = br.readLine();
		  
		 FileReader fr = new FileReader(path + "/" + fileName); BufferedReader bread =
		 new BufferedReader(fr);
		  
		  
		 Test t = new Test(); t.evaluateTest(bread); 
	  }	

}
