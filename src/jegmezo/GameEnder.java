package jegmezo;

import java.io.IOException;

public class GameEnder {
	
	private static boolean end=false;
	
	public static void endGame() {
		System.out.println("<GameEnder.endGame()");
		/*try {
			Test.bw.write("Game Over\n");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}catch(IOException e1) {
			e1.printStackTrace();
		}*/
		end = true;
		System.out.println(">GameEnder.endGame()");
	}
	
	public boolean getEnd() {
		return end;
	}
}
