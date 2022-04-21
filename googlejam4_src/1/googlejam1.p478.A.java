package googlejam1.p478;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
public class A {
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(new File("A-large.in"));
			//Scanner sc = new Scanner(System.in);
			@SuppressWarnings("unused")
			File file = new File ("A-large.out");
		    PrintWriter pw = new PrintWriter ("A-large.out");
			int numCase = sc.nextInt();
			for (int zz =0; zz < numCase; zz++){
				int numRound = sc.nextInt();
				int[] table = new int[numRound];
				int minEaten = 0;
				int minEatenConstant = 0;
				int maxConstant = -1;

				for(int i = 0; i < numRound; i++){
					table[i] = sc.nextInt();
					if(i > 0){
						if(table[i-1] >= table[i]){
							int eaten = table[i-1] - table[i];
							minEaten += eaten;
							if(maxConstant < eaten){
								maxConstant = eaten;
							}
						}
					}
				}
				for(int i = 0 ; i < numRound - 1; i++){
					// eat the whole plate or maxConstant except the last plate
					minEatenConstant += Math.min(maxConstant, table[i]);
				}
				pw.printf("Case #%d: %d %d\n", (zz+1), minEaten, minEatenConstant);
				//System.out.printf("Case #%d: %d %d\n", (zz+1), minEaten, minEatenConstant);
			}
			sc.close();
			pw.close();
		}
		catch(Exception e){}
	}
}
