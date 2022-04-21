package googlejam1.p609;


import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("A-large.in"));
		BufferedWriter w = new BufferedWriter(new FileWriter("out.txt"));
		if (sc.hasNextInt()) {
			int testNumber = sc.nextInt();
			for (int i = 1; i <= testNumber; i++) {
				int input = sc.nextInt();
				int one = 0;
				int two = 0;
				int max = 0;
				int[] array = new int[input];
				for (int j = 0; j < input; j++) {
					array[j] = sc.nextInt();
					if (j != 0 && (array[j-1] - array[j]) >max) {
						max = array[j-1]-array[j];
					}
				}
				for (int j = 0; j < input-1; j++) {
					if (array[j] > array[j+1]) {
						one += array[j]-array[j+1];
					}
					if (max >= array[j]) {
						two += array[j];
					}
					if (max < array[j]) {
						two += max;
					}
				}
//				System.out.println("Case #"+i+": "+one+" "+two);
				w.write("Case #"+i+": "+one+" "+two+"\n");
			}
		}
		sc.close();
		w.close();
	}

}
