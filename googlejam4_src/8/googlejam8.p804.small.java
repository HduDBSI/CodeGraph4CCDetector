package googlejam8.p804;
import java.util.*;
import java.io.*;

public class small {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("A-large.in"));
		PrintWriter out = new PrintWriter("large_output.txt");
		// Scanner in = new Scanner(new File("large_input.txt"));
		// PrintWriter out=new PrintWriter("large_output.txt");
		int n = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		int m = -1;// answer
		int party = m;
		int max = 0;
		int maxid =0;
		int max2 = 0;
		int max2id =0;
		int temp = 0;
		int sum = 0;
		String ans = "";
		for (int i = 1; i <= n + 1; i++) {
			if (in.hasNext()) {
				// each case
				m = in.nextInt();
				party = m;
				sum = 0;
				int arrParty[] = new int[m];
				for (int j = 0; j < party; j++) {
					arrParty[j] = in.nextInt();
					sum = sum + arrParty[j];

				}

				while (sum > 3) {
					max = 0;

					for (int j = 0; j < party; j++) {
						if (max < arrParty[j]) {
							max = arrParty[j];
							maxid = j;
						}

					}

			
					ans = ans + (char) (maxid + 'A');

					arrParty[maxid]--;
					sum--;
					max = 0;

					for (int j = 0; j < party; j++) {
						if (max < arrParty[j]) {
							max = arrParty[j];
							maxid = j;
						}

					}
					ans = ans + (char) (maxid + 'A');

					arrParty[maxid]--;
					sum--;
					max = 0;
					ans=ans+" ";

				}
				if(sum==3)
				{
					for (int j = 0; j < party; j++) {
						if (max < arrParty[j]) {
							max = arrParty[j];
							maxid = j;
						}

					}
					ans = ans + (char) (maxid + 'A');

					arrParty[maxid]--;
					sum--;
					max = 0;
					ans=ans+" ";
				}
				
				
				if(sum<=2){
				for(int j=0;j<party;j++){
					if(arrParty[j]!=0){
						maxid=j;
					break;}
//					System.out.println(i+""+j);
				}
				for(int j=party-1;j>0;j--){
					if(arrParty[j]!=0){
						max2id=j;
					break;}
//					System.out.println(i+""+j);
				}
				if (maxid==max2id) ans=ans+(char) (maxid + 'A');
				if (maxid!=max2id) ans=ans+(char) (maxid + 'A')+(char) (max2id + 'A');}
				
				if (m != -1)
					out.println("Case #" + i + ": " + ans);

				else {
					out.println("Case #" + i + ": " + "Wrong Input");
					
				}
				ans="";
				// each case closed

			}
			// System.out.println(i);//test
		}
		in.close();
		out.close();

	}
}