package googlejam8.p610;
import java.util.Arrays;
import java.util.Scanner;

public class SenateEvacuation {

	static Scanner sc = new Scanner(System.in);
	static int T;
	static int[] P;
	public static void main(String[] args) {
		T = sc.nextInt();
		for (int c = 0; c < T; c++) {
			System.out.print("Case #"+(c+1)+":");
			int len = sc.nextInt();
			P = new int[len];
			int tot = 0;
			for (int i = 0; i < len; i++) {
				P[i] = sc.nextInt();
				tot+= P[i];
			}
			
			int last = 0;
			for (int i = 0; i < tot-2;) {

				int max = -1;
				int id = -1;
				int max2 = -1;
				int id2 = -1;
				for (int j = 0; j < len; j++) {
					if(P[j] > max){
						id = j;
						max = P[j];
					}
				}

				P[id]--;

				for (int j = 0; j < len; j++) {
					if(P[j] > max2){
						id2 = j;
						max2 = P[j];
					}
				}

				//check if can
				int total = (tot - i - 1)/2;
				//System.out.println(Arrays.toString(P));
				if(P[id2] > total && P[id] > total){
					System.out.println("D:");
				}
				
				if(P[id2] > total){
					char i1 = (char)('A' + id);
					char i2 = (char)('A' + id2);
					P[id2]--;
					System.out.print(" " + i1+""+i2);
					i+=2;
				}
				else{
					char resp = (char)('A' + id);
					System.out.print(" "+resp);
					i++;
				}

			}

			char id1 = '-';
			char id2 = 'A';
			for (int j = 0; j < len; j++) {
				if(P[j] > 0){
					if(id1 == '-'){
						id1 = (char)('A' + j);
					}
					else{
						id2 = (char)('A' + j);
					}
				}
			}
			System.out.println(" " + id1+""+id2);

		}

	}

}
