package googlejam3.p188;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class question1 {

	
	public static void main(String[] args) throws FileNotFoundException, IOException {	
		String file = "small1.in";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    Integer N = Integer.parseInt(br.readLine());
		    for (int n = 0; n < N; n++) {
		    	String[] RCW = br.readLine().split(" ");
		    	Integer R = Integer.parseInt(RCW[0]);
		    	Integer C = Integer.parseInt(RCW[1]);
		    	Integer W = Integer.parseInt(RCW[2]);
		    	
		    	int guess_per_row = C / W;
		    	
		    	int last = ((C / W) + W - 1) + ((R-1) * guess_per_row);
		    	
		    	if (C%W != 0) last += 1;

		    	System.out.println("Case #" + (n+1) + ": " + last);	

		    }
		}
		

	}
	
	/*
	public int brute_force(int C, int[] moves) {
		int max = 0;
		for (int i = 0; i < C; i++) {
			if (moves[i] == 0) { 
				int[] temp = Arrays.copyOf(moves, C);
				temp[i] = 1;
				int hit = 
			}
				int minmax = brute_force(moves)
		}
	}*/
	
	
}
