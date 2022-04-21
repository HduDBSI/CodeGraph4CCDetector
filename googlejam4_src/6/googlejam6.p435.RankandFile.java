package googlejam6.p435;


import java.util.Scanner;

public class RankandFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//sc.next();
		for (int cases = 1; cases <= T; cases++) {
			int N = sc.nextInt();
			/*int[][] arr = new int[2*N-1][N];
			int[][] sorted = new int[N][N];
			for (int i = 0; i < 2*N-1; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					//System.out.print(s + " ");
					
				}
				//System.out.println();
			}
			for (int i = 0; i < 2*N-1; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			for (int round = 0; round < N; round++) {
				int min = 5000;
				int row = -1, col = -1;
				for (int i = 0; i < 2*N-1; i++) {
					for (int j = 0; j < round; j++)
						if (arr[i][j] != sorted[])
					if (arr[i][round] < min) {
						min = arr[i][round];
						row = i;
					} else if (arr[i][round] <= min) {
						col = i;
					}
				}
				for (int i = round; i < N; i++)
					sorted[round][i] = arr[row][i];
				for (int i = round; i < N; i++)
					sorted[i][round] = arr[col][i];

				System.out.println("BBBBBB");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(sorted[i][j] + " ");
					}
					System.out.println();
				}
		
			}*/
			int[] seen = new int[2501];
			for (int i = 0; i < 2*N-1; i++) {
				for (int j = 0; j < N; j++) {
					int k = sc.nextInt();
					seen[k]++;
				}
			}
			System.out.print("Case #" + cases + ":");
			for (int i = 0; i <= 2500; i++) {
				if (seen[i] % 2 == 1)
					System.out.print(" " + i);
			}
			System.out.println();
			
			/*System.out.println("Case #" + cases + ": ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(sorted[i][j] + " ");
				}
				System.out.println();
			}*/
		}
		sc.close();
	}

}
/*
1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3
*/