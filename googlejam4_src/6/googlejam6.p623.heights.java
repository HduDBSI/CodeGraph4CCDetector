package googlejam6.p623;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class heights {

	/**
	 * @param args
	 */
	static String INPUT_LOCATION = "C:\\Users\\srihari\\workspace\\codejam2016\\";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileReader(INPUT_LOCATION
				+ "B-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(INPUT_LOCATION
				+ "B-large.in.out"));
		
//		Scanner sc = new Scanner(new FileReader(INPUT_LOCATION
//				+ "B-small-attempt0.in"));
//		PrintWriter pw = new PrintWriter(new FileWriter(INPUT_LOCATION
//				+ "B-small-attempt0.in.out"));
		 
		//Scanner sc=new Scanner(System.in);
		int cnttests = sc.nextInt();
		//sc.nextLine();
		for (int i = 0; i < cnttests; i++) 
			{
				int[] trackcounts = new int [2501];
				int j = sc.nextInt();
				int x = (2*j-1)*j;
				for(int k = 0;k < x; k++)
						trackcounts[sc.nextInt()] += 1;
				    
				    pw.print("Case #"+(i+1)+":");
				    //System.out.print("Case #"+(i+1)+":");
				    for(int p = 1; p<2500;p++)
				    {
				    	if(trackcounts[p]%2==1)
				    	   pw.print(" " +p);
				    		//System.out.print(" " +p);
				    }
				   
				    pw.println();
				    //System.out.println();
			}
			
			
		pw.flush();
		pw.close();
		sc.close();

	   }
}
