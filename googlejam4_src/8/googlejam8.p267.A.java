package googlejam8.p267;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class A {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();

		for (int c = 0; c < cases; c++) {
			int no_of_parties = in.nextInt();
			int parties[] = new int[no_of_parties];

			int remaining = 0;
			for (int i = 0; i < no_of_parties; i++) {
				parties[i] = in.nextInt();
				remaining += parties[i];
			}	

			StringBuilder output = new StringBuilder("");
			output.append("Case #" + (c+1) + ":");

			while (remaining > 0) {
				output.append(" ");

				//find MAX number
				int max = 0;
				for (int i = 0; i < no_of_parties; i++) {
					if (parties[i] > max) max = parties[i];
				}
				//find number of maxes
				int no_of_max = 0;
				for (int i = 0; i < no_of_parties; i++) {
					if (parties[i] == max) no_of_max++;
				}

				//if more than 3 or not 1, remove 2
				if (no_of_max > 3 || no_of_max == 2) {
					int count = 2;
					for (int i = 0; i < no_of_parties; i++) {
						if (count == 0) break;
						if (parties[i] == max) {
							parties[i]--;
							output.append((char)(('A') + i));
							count--;
						}
					}
					remaining -= 2;
				}	
				else { //just remove one please
					int count = 1;
					for (int i = 0; i < no_of_parties; i++) {
						if (count == 0) break;
						if (parties[i] == max) {
							parties[i]--;
							output.append((char)(('A') + i));
							count--;
						}
					}
					remaining -= 1;
				}
				
				//TEST TEST TEST
				int maxpol = remaining/2 + 1;
				for (int i = 0; i < no_of_parties; i++) {
					if (parties[i] >= maxpol) {
						System.out.println("WARNING");
					}
				}
				//TEST TEST TEST PLS REMOVE LATER



			} //end remove while

			System.out.println(output);
		}

	}

} //EM

