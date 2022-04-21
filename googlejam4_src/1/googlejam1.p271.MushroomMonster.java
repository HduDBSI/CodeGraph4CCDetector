package googlejam1.p271;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MushroomMonster {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		int numCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numCases; i++) {
			int intervals = Integer.parseInt(br.readLine());
			
			String[] sv = br.readLine().split(" ");
			
			int[] iv = new int[intervals];
			
			for (int j = 0; j < intervals; j++) {
				iv[j] = Integer.parseInt(sv[j]);
			}
			
			int y = 0, a = 0, max = 0, z = 0;
			for (int j = 0; j < intervals - 1; j++) {
				y += (a = iv[j] - iv[j + 1]) > 0 ? a : 0;
				max = a > max ? a : max;
			}
			
			for (int j = 0; j < intervals - 1; j++) {
				z += (iv[j] < max) ? iv[j] : max;
			}
			
			System.out.println("Case #" + (i + 1) + ": " + y + " " + z);
		}

	}

}
