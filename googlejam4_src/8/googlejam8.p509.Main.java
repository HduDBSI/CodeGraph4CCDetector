package googlejam8.p509;


import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		FileReader file = null;
		try {
			file = new FileReader("E:\\Windows\\chrome download\\A-large.in");
		}
		catch (FileNotFoundException e) {
			
		}
		BufferedReader in = new BufferedReader(file);
		int tests = 0;
		try {
			tests = Integer.parseInt(in.readLine());
		}
		catch (IOException e) {
			
		}
		for (int i = 1; i <= tests; i++) {
			System.out.print("Case #" + i + ":");
			int n = 0;
			try {
				n = Integer.parseInt(in.readLine());
			}
			catch (IOException e) {
				
			}
			int[] senators = new int[n];
			int sum = 0;
			String[] s = null;
			try {
				s = in.readLine().split(" ");
			}
			catch (IOException e) {
				
			}
			for (int j = 0; j < n; j++) {
				int senator = 0;
				senator = Integer.parseInt(s[j]);
				sum += senator;
				senators[j] = senator;
			}
			while (sum > 0) {
				int index1 = 0;
				for (int j = 0; j < senators.length; j++) {
					if (senators[j] > senators[index1]) {
						index1 = j;
					}
				}
				senators[index1]--;
				sum--;
				int index2 = 0;
				for (int j = 0; j < senators.length; j++) {
					if (senators[j] > senators[index2] && sum != 0) {
						index2 = j;
					}
				}
				senators[index2]--;
				sum--;
				int index3 = 0;
				boolean b = false;
				for (int j = 0; j < senators.length; j++) {
					if (senators[j] > senators[index3] && sum != 0) {
						index3 = j;
					}
				}
				if (senators[index3] == 0 || (sum - 1) / senators[index3] >= 1) {
					b = true;
				}
				else {
					senators[index2]++;
					sum++;
				}
				char x = (char) ('a' + index1);
				char y;
				if (b) {
					y = (char) ('a' + index2);
					System.out.print(" " + x + y);
				}
				else {
					System.out.print(" " + x);
				}
			}
			System.out.println("");
		}
	}
}