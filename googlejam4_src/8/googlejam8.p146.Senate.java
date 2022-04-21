package googlejam8.p146;
// Google Code Jam Round 1C 2016
// Problem A. Senate Evacuation

import java.util.*;
import java.io.*;

public class Senate{
	//static String filename = "A-sample";			// io filename here, change accordingly
	//static String filename = "A-small-attempt0";	
	static String filename = "A-large";	
	static String inname = filename + ".in";    
	static String outname = filename + ".out";  
	public static void main(String[] args){
		try{
			Scanner in = new Scanner(new BufferedReader(new FileReader(inname)));
			//Scanner in = new Scanner(System.in);
			BufferedWriter out = new BufferedWriter(new FileWriter(outname));
			int t = in.nextInt();
			in.nextLine();
			for (int cas = 1; cas <= t; cas++){
				int n = in.nextInt();
				int[] p = new int[n];
				for (int i = 0; i < n; i++) p[i] = in.nextInt();
				int n1 = p.length;
				int max1 = 0;
				int max2 = 0;
				for (int i = 0; i < n1; i++)
					if (p[i] > p[max1]) max1 = i;
				if (max1 == 0) max2 = 1;
				for (int i = 0; i < n1; i++)
					if (i != max1 && p[i] > p[max2]) max2 = i;
				String ans1 = "";
				int ptr = 0;
				while (p[max1] > p[max2]){
					for (; ptr < n1; ptr++){
						if (ptr == max1 || ptr == max2) continue;
						while (p[ptr] > 0){
							ans1 += (""+(char)('A'+max1)) + (""+(char)('A'+ptr)) + " ";
							p[max1]--;
							p[ptr]--;
							if (p[max1] <= p[max2]) break;
						}
						if (p[max1] <= p[max2]) break;
					}
				}
				for (; ptr < n1; ptr++){
					if (ptr == max1 || ptr == max2) continue;
					if (p[ptr] <= 0) continue;
					for (int i = ptr+1; i < n1; i++){
						if (i == max1 || i == max2) continue;
						while (p[i] > 0){
							ans1 += (""+(char)('A'+ptr)) + (""+(char)('A'+i)) + " ";
							p[i]--;
							p[ptr]--;
							if (p[ptr] <= 0) break;
						}
						if (p[ptr] <= 0) break;
					}
				}
				for (int i = 0; i < n1; i++){
					if (i == max1 || i == max2) continue;
					while (p[i] > 0){
						ans1 += (""+(char)('A'+i))+ " ";
						p[i]--;
					}
				}
				while (p[max1] > 0){
					ans1 += (""+(char)('A'+max1)) + (""+(char)('A'+max2)) + " ";
					p[max1]--;
					p[max2]--;
				}
				String ans = ans1;

				String s = in.nextLine();
				
				System.out.print("Case #" + cas + ": " + ans + "\n");
				out.write("Case #" + cas + ": " + ans + "\n");
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}