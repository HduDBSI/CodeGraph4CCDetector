package googlejam8.p619;
import java.util.Scanner;

public class SenateEvacuation {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int T, N;
		int[] senates;
		
		T = keyboard.nextInt();
		keyboard.nextLine();
		for(int i = 0; i < T; i++) {
			N = keyboard.nextInt();
			senates = new int[N];
			for(int j = 0; j < N; j++) senates[j] = keyboard.nextInt();
			System.out.print("Case #"+ (i+1) +": ");
			boolean continuing = true;
			int maxid, maxid2, equals;
			while(continuing) {
				maxid = 0;
				maxid2 = -1;
				equals = 0;
				for(int i2 = 1; i2 < senates.length; i2++) {
					if(senates[i2] > senates[maxid]) {
						maxid = i2;
						equals = 0;
					}
					else if(senates[i2] == senates[maxid]) {
						equals++;
						maxid2 = i2;
					}
				}
				
				if(equals > 0 && senates[maxid] > 1) {
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(Character.toChars(maxid2 + 65));
					System.out.print(" ");
					senates[maxid] -= 1;
					senates[maxid2] -= 1;
				}
				else if(senates[maxid] > 1) {
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(" ");
					senates[maxid] -= 2;
				} else if(equals == 2) {
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(" ");
					senates[maxid] -= 1;
				} else if (equals > 0){
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(Character.toChars(maxid2 + 65));
					System.out.print(" ");
					senates[maxid] -= 1;
					senates[maxid2] -= 1;
				} else {
					System.out.print(Character.toChars(maxid + 65));
					System.out.print(" ");
					senates[maxid] -= 1;
				}
				continuing = false;
				for(int i1 = 0; i1 < senates.length; i1++) {
					if(senates[i1] > 0) continuing = true;
				}
			}
			System.out.println();	
		}
		keyboard.close();
	}

}