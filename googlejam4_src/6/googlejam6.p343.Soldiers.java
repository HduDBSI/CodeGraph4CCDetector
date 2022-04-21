package googlejam6.p343;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Soldiers {
	public static void main(String [] args)
	{		

		// Input

		File file = new File("soldiers/large.txt");

		String[] problem = null;
		int size = 0;
		ArrayList<Integer>[] sol = null;
		try {

			Scanner sc = new Scanner(file);

			size = sc.nextInt();

			sc.nextLine();

			problem = new String[size];

			sol =  new ArrayList[size];
			
			for (int i=0; i<size; i++) {
				sol[i] = new ArrayList<Integer>();
				int N = sc.nextInt();
				int[] digits = new int[3000];
				for(int j=0; j<N*(2*N-1); j++) {
					digits[sc.nextInt()]++;
				}
				for(int j=0; j<3000; j++) {
					if(digits[j]%2==1) {
						sol[i].add(j);
					}
				}
				Collections.sort(sol[i]);
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		// Output

		PrintWriter writer = null;
		try {
			writer = new PrintWriter("sol.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i=0; i<size; i++) {

			writer.print("Case #" + (i+1) + ":");
			long index = i+1;
			System.out.print("Case #" + index + ":");

			for(int j : sol[i]) {
				writer.print(" " + j);
				System.out.print(" " + j);
			}
			writer.println("");
			System.out.println("");
		}
		writer.close();

	}
}
