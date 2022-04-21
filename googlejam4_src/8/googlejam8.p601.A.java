package googlejam8.p601;
import java.util.*;
import java.io.*;

public class A {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(new File("C:\\Users\\jainh\\Desktop\\A-small-attempt0.in"));
		FileWriter fw = new FileWriter("C:\\Users\\jainh\\Desktop\\A-small.out");
		
		int T = in.nextInt();
		in.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			int N = in.nextInt();
			int[] arr = new int[65 + N];
			int count = 0;
			for(int i = 65; i < 65 + N; i++) {
				arr[i] = in.nextInt();
				count += arr[i];
			}
			
			String returnString = "";
			while(count > 0) {
				int[] largestTwo1 = new int[4];
				
				for(int i = 65; i < arr.length; i++) {
					if (arr[i] > largestTwo1[0]) {
						largestTwo1[0] = arr[i];
						largestTwo1[1] = i;
						largestTwo1[2] = 0;
					} else if (arr[i] == largestTwo1[0]) {
						largestTwo1[2] = arr[i];
						largestTwo1[3] = i;
					}
				}
				int[] largestTwo = largestTwo1;
				if(largestTwo[0] == largestTwo[2]) {
					if (count == 3) {
						returnString += (char)largestTwo[1];
						returnString += " ";
						count -= 1;
						arr[largestTwo[1]] -= 1;
					} else {
						returnString += (char)largestTwo[1];
						returnString += (char)largestTwo[3];
						returnString += " ";
						count -= 2;
						arr[largestTwo[1]] -= 1;
						arr[largestTwo[3]] -= 1;
					}
					
				} else {
					returnString += (char)largestTwo[1];
					returnString += " ";
					count -= 1;
					arr[largestTwo[1]] -= 1;
				}
			}
			
			fw.write ("Case #" + tc + ": " + returnString + "\n");
		}
		in.close();
		fw.flush();
		fw.close();
	}
}