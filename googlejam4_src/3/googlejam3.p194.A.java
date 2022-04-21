package googlejam3.p194;
import java.util.*;
import java.io.*;

public class A {
	
	public static void main(String[] args) throws IOException{
		
		File fileIn = new File("FILEIN.in");
		PrintWriter writer = new PrintWriter("FILEOUT.txt", "UTF-8");
		Scanner in = new Scanner(fileIn);
		int numCases = in.nextInt();
		
		for(int i = 0; i < numCases; i++){
			writer.printf("Case #%d: ", i+1);
			//writer.printf("Case #%d:\r\n", i+1);
			
			//BEGIN CODE HERE
			int R = in.nextInt(); //NUM OF GAMES
			int C = in.nextInt(); //LENGTH OF EACH GAME
			int W = in.nextInt(); //LENGTH OF SHIP
			
			int min = (R) * (C / W);
			if(W < C && W > 1 && (C % W != 0) && (C != W)) min += 1;
			min += W - 1;
			writer.println(min);
			//END CODE HERE
			
		}
		System.out.println("DONE");
		in.close();
		writer.close();
	}
}