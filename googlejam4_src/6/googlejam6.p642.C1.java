package googlejam6.p642;


import java.util.ArrayList;
import java.util.Scanner;

public class C1 {

	/*
	public static ArrayList<boolean[]> combFinal = new ArrayList<>();
	public static ArrayList<Integer> choice = new ArrayList<>();
	*/
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    
	    for (int i = 1; i <= t; ++i) {
	    	int n = in.nextInt();
	    	int[][] lines = new int[2*n-1][n];
	    	
	    	for(int j=0; j<2*n-1; j++){
	    		for(int k=0; k<n; k++){
	    			lines[j][k] = in.nextInt();
	    		}
	    	}
	    	System.out.print("Case #" + i + ":");
	    	ArrayList<Integer> val = new ArrayList<>();
			int m = 2*n-1;
			
			for(int i1=0; i1<m; i1++){
				for(int j=0; j<n; j++){
					val.add(lines[i1][j]);
				}
			}
			
			ArrayList<Integer> missing = new ArrayList<>();
			for(int i2=0; i2<2500; i2++){
				int count = 0;
				for(int j=0; j<val.size(); j++){
					if(val.get(j)==i2)
						count++;
				}
				if(count%2!=0){
					System.out.print(" "+i2);
					missing.add(i2);
				}
			}
	    	System.out.println("");
	    	
	    }

	}

}
