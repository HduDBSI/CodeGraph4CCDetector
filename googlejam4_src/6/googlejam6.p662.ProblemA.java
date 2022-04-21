package googlejam6.p662;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author andrew
 *
 */
public class ProblemA {
	static final String PROBLEM = "rankfile";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File(PROBLEM+".in"));
		int n = s.nextInt();
		s.nextLine();
		
		FileWriter fw = new FileWriter(new File(PROBLEM+".out"));
		for (int i=0; i<n; i++) {
			int size = s.nextInt();
			ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
			for (int j=0; j<size * 2 - 1; j++) {
				ArrayList<Integer> thisSet = new ArrayList<Integer>();
				for (int p=0; p<size; p++) {
					thisSet.add(s.nextInt());
				}
				data.add(thisSet);
			}
			
			int[] distributions = new int[2501];
				for (ArrayList<Integer> arr: data) {
					for (int x: arr) {
						System.out.print(x+" ");
						distributions[x]++;
					}
					System.out.println();
				}
			int[] odd = new int[size * size];
			int oddCount = 0;
			for (int p=0; p<distributions.length; p++) {
				if (distributions[p] % 2 == 1) {
					odd[oddCount++] = p;
				}
			}
			for (int p=0; p<odd.length; p++) {
				if (odd[p] == 0) {
					odd[p] = Integer.MAX_VALUE;
				}
			}
			Arrays.sort(odd);
			String output = "";
			for (int p=0; p<size; p++) {
				output+= " "+odd[p];
			}
			fw.write("Case #"+(i+1)+":"+output+"\n");
		}
		
		
		//fw.write(""+answer);
		fw.close();
		s.close();
	}

}
