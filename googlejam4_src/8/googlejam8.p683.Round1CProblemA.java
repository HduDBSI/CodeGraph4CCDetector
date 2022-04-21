package googlejam8.p683;

	import java.util.*;
	import java.io.*;

	public class  Round1CProblemA {
		public static void main(String[] args) throws Exception {
			Round1CProblemA r = (new  Round1CProblemA());
			Scanner sc = new Scanner(new FileReader("input.in"));
			PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
			int T = sc.nextInt();
			for (int t=0; t<T; t++) {
				System.out.println("Now case " + (t+1));
				int N = sc.nextInt();
				int[] P = new int[N];
				for(int i=0; i<N;i++){
					P[i] = sc.nextInt();
				}
				int pe = 0;
				for(int i=0; i<N;i++){
					pe = pe + P[i];
				}
				String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String ans = "";
				while(pe>0){
					int maxp = 0;
					for(int i=1;i<P.length;i++){
						if(P[i]>P[maxp]) maxp = i;
					}
					P[maxp] = P[maxp] - 1;
					pe = pe -1;
					ans = ans + alp.charAt(maxp);
					if(pe==2){
					}else{
						for(int i=1;i<P.length;i++){
							if(P[i]>P[maxp]) maxp = i;
						}
						P[maxp] = P[maxp] - 1;
						pe = pe -1;
						ans = ans + alp.charAt(maxp);
					}
					ans = ans + " ";
				}
				
				
				pw.print("Case #" + (t+1) + ": " + ans);
				pw.println();
			}
			pw.flush();
			pw.close();
			sc.close();
		}
	}



