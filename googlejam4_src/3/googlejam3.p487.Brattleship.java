package googlejam3.p487;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Brattleship {
	
	
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("A-small-attempt0.in"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("A-small-attempt0.out"));
			
			int numCases = Integer.parseInt(br.readLine());
			
			int casectr = 1;
			for (int c = 0; c < numCases; c++, casectr++) {
				String[] line = br.readLine().split(" ");
				int row = Integer.parseInt(line[0]); // small: row = 1
				int col = Integer.parseInt(line[1]);
				int width = Integer.parseInt(line[2]);
				
				int res = 0;
				switch (col) {
				case 1:
					res = 1;
					break;
				case 2:
					res = 2;
					break;
				case 3:
					res = 3;
					break;
				case 4:
					switch (width) {
					case 1:
						res = 4;
						break;
					case 2:
						res = 3;
						break;
					case 3:
						res = 4;
						break;
					case 4:
						res = 4;
						break;
					}
					break;
				case 5:
					switch (width) {
					case 1:
						res = 5;
						break;
					case 2:
						res = 4;
						break;
					case 3:
						res = 4;
						break;
					case 4:
						res = 5;
						break;
					case 5:
						res = 5;
						break;
					}
					break;
				case 6:
					switch (width) {
					case 1:
						res = 6;
						break;
					case 2:
						res = 4;
						break;
					case 3:
						res = 4;
						break;
					case 4:
						res = 5;
						break;
					case 5:
						res = 6;
						break;
					case 6:
						res = 6;
						break;
					}
					break;
				case 7:
					switch (width) {
					case 1:
						res = 7;
						break;
					case 2:
						res = 5;
						break;
					case 3:
						res = 5;
						break;
					case 4:
						res = 5;
						break;
					case 5:
						res = 6;
						break;
					case 6:
						res = 7;
						break;
					case 7:
						res = 7;
						break;
					}
					break;
				case 8:
					switch (width) {
					case 1:
						res = 8;
						break;
					case 2:
						res = 5;
						break;
					case 3:
						res = 5;
						break;
					case 4:
						res = 5;
						break;
					case 5:
						res = 6;
						break;
					case 6:
						res = 7;
						break;
					case 7:
						res = 8;
						break;
					case 8:
						res = 8;
						break;
					}
					break;
				case 9:
					switch (width) {
					case 1:
						res = 9;
						break;
					case 2:
						res = 6;
						break;
					case 3:
						res = 5;
						break;
					case 4:
						res = 6;
						break;
					case 5:
						res = 6;
						break;
					case 6:
						res = 7;
						break;
					case 7:
						res = 8;
						break;
					case 8:
						res = 9;
						break;
					case 9:
						res = 9;
						break;
					}
					break;
				case 10:
					switch (width) {
					case 1:
						res = 10;
						break;
					case 2:
						res = 6;
						break;
					case 3:
						res = 6;
						break;
					case 4:
						res = 6;
						break;
					case 5:
						res = 6;
						break;
					case 6:
						res = 7;
						break;
					case 7:
						res = 8;
						break;
					case 8:
						res = 9;
						break;
					case 9:
						res = 10;
						break;
					case 10:
						res = 10;
						break;
					}
					break;
				}
					
				bw.write("Case #" + casectr + ": " + res);
				bw.newLine();
			}
			
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}