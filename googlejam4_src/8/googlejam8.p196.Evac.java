package googlejam8.p196;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Evac {
	
	public static int[] party;
	public static int N, sum;

	public static void main(String[] args) throws IOException {

		File input = new File("input.txt");
		Scanner scanner = new Scanner(input);
		
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			
			N = scanner.nextInt();
			party = new int[N];
			sum = 0;
			
			for (int j = 0; j < N; j++) {

				party[j] = scanner.nextInt();
				sum += party[j];
			}

			System.out.printf("Case #%d: ", i + 1);
			if (N == 2) {
				for (int j = 1; j < party[0]; j++)
					System.out.print("AB ");
				System.out.println("AB");
			} else
				while (sum > 0) {
					
					int gold, silver, bronze;
					gold = silver = bronze = -1;
					for (int i1 = 0; i1 < N; i1++)
						if (gold == -1 || party[i1] > party[gold]) {
							bronze = silver;
							silver = gold;
							gold = i1;
						}
						else if (silver == -1 || party[i1] > party[silver]) {
							bronze = silver;
							silver = i1;
						}
						else if (bronze == -1 || party[i1] > party[bronze])
							bronze = i1;
					int x = party[gold] - 1;
					int y = party[bronze];
					
					if ((x > y ? x : y) > (sum - 2) / 2) {
						
						sum--;
						party[gold]--;
						System.out.print((char) ((int) 'A' + gold));
					}
					else {
						
						sum -= 2;
						party[gold]--;
						party[silver]--;
						System.out.print((char) ((int) 'A' + gold));
						System.out.print((char) ((int) 'A' + silver));
					}
					
					if (sum == 0)
						System.out.println();
					else
						System.out.print(' ');
				}
		}
		
		scanner.close();
	}

}
