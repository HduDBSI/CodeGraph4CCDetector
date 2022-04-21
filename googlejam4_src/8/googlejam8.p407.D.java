package googlejam8.p407;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/*
UTILS :

ArrayList<Long>[] sol = (ArrayList<Long>[]) new ArrayList[size];
Collections.sort();
System.out.println("");
(String).toCharArray();

sc.nextLong();
sc.nextBigInteger();
sc.nextLine();
sc.nextDouble();
sc.nextInt();
sc.nextInt(int radix);
sc.nextBoolean();
 */


public class D {
	public static void main(String [] args) throws Exception
	{		
		Scanner sc = new Scanner(new File("D/large.txt"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/D.txt"))));
		int size = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<size; i++) {
			
			int length = sc.nextInt();
			System.out.println(length);
			
			// Case #
			writer.print("Case #" + (i+1) + ":");
			System.out.print("Case #" + (i+1) + ":");
			
			
			// Solve
			int max = -1;
			int index = -1;
			int[] line = new int[length];
			for(int j=0; j<length; j++) {
				line[j] = sc.nextInt();
				if(line[j]>max) {
					index = j;
					max = line[j];
				}
			}
			
			while(max!=0) {
				int i1 = -1;
				int i2 = -1;
				int count = 0;
				for(int j=0; j<length; j++) {
					if(line[j]==max) {
						i2 = i1;
						i1 = j;
						count++;
					}
				}
				
				
				if(count%2==0) {
					line[i1]--;
					line[i2]--;
					writer.print(" " + String.valueOf((char)(i1 + 65)) + String.valueOf((char)(i2 + 65)));
					System.out.print(" " + String.valueOf((char)(i1 + 65)) + String.valueOf((char)(i2 + 65)));
				}
				else {
					line[i1]--;
					writer.print(" " + String.valueOf((char)(i1 + 65)));
					System.out.print(" " + String.valueOf((char)(i1 + 65)));
				}
				
				
				
				max = 0;
				for(int j=0; j<length; j++) {
					if(line[j]>max) {
						index = j;
						max = line[j];
					}
				}
			}
			


			
			
			
			// Print result


			
			
			writer.println("");
			System.out.println("");
		}

		writer.close();
		sc.close();
	}
}