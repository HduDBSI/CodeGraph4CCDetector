package googlejam1.p596;

import java.util.*;
import java.io.*;

public class Mushroom {

	public static void main (String[] args) throws IOException {
		BufferedReader instr = new BufferedReader(new InputStreamReader(System.in));
		String oneLine;
		int counter = 0;
		while ((oneLine = instr.readLine()) != null) {
			if (counter == 0) {
				counter++;
				continue;
			}
			if (counter%2 == 1) {
				counter++;
				continue;
			}
			String[] input = oneLine.split("\\s+");
			List<Integer> mushroom_list1 = new ArrayList<Integer>();
			for (int i1 = 0; i1 < input.length; i1++) {
				int temp = Integer.parseInt(input[i1]);
				mushroom_list1.add(temp);
			}
			List<Integer> mushroom_list = mushroom_list1;
			int sum = 0;
			int len = mushroom_list.size();
			for (int i = 1; i < len; i++) {
				int diff = mushroom_list.get(i-1) - mushroom_list.get(i);
				if (diff > 0) {
					sum = sum + diff; 
				}
			}
			int first_sol = sum;
			int largest_diff = 0;
			int len1 = mushroom_list.size();
			for (int i = 1; i < len1; i++) {
				int diff = mushroom_list.get(i-1) - mushroom_list.get(i);
				if (diff > largest_diff) {
					largest_diff = diff;
				}
			}
			int sum1 = 0;
			for (int i = 0; i < len1 - 1; i++) {
				int num = mushroom_list.get(i);
				if (num > largest_diff) {
					sum1 += largest_diff;
				}
				else {
					sum1 += num;
				}
			}
			int second_sol = sum1;
			System.out.println("Case #" + counter/2 + ": " + first_sol + " " + second_sol);
			counter++;
		}
	}
}