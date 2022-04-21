package googlejam8.p894;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class A3 {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("src/a.in");
	    PrintStream fout = new PrintStream(new FileOutputStream("src/a.out"));
	    System.setIn(fin);
	    System.setOut(fout);
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();		
	    for(int i = 1; i <= t; ++i) {
	    	int n = in.nextInt();
	    	int[][] p = new int[26][2];
	    	int sum = 0;
	    	for(int j = 0; j < n; j++) {
	    		p[j][1] = in.nextInt();
	    		p[j][0] = 65+j;
	    		sum+=p[j][1];
	    	}
	    	for(int j = 0; j < n; j++) {
    			int max = p[j][1];
    			int maxp = j;
	    		for(int k = j+1; k < n; k++) {
	    			if(max < p[k][1]){
	    				max = p[k][1];
	    				maxp = k;
	    			}
	    		}
	    		int bv= p[j][1];
	    		int bp=p[j][0];
	    		p[j][1] = max;
	    		p[j][0] = p[maxp][0];
	    		p[maxp][0] = bp;
	    		p[maxp][1] = bv;
	    	}
	    	System.out.print("Case #" + i + ":");
	    	int ave = sum/n;
	    	int party = 0;
	    	while(sum != 0) {
	    		party = 0;
	    		boolean change = false;
	    		for(int j = 0; j < n; j++ ) {
	    			if(p[j][1] > ave) {
	    				p[j][1]--;
	    				sum --;
	    				char b = (char)p[j][0];
	    				System.out.print(" "+b);
	    				change = true;
	    			}
	    			if(p[j][1]!=0){
	    				party++;
	    			}
	    		}
	    		ave = sum/party;
	    		if(change==false) {
	    			for(int j = 0; j < n-2; j++) {
	    				while(p[j][1]!=0){
	    					p[j][1]--;
		    				char b = (char)p[j][0];
		    				System.out.print(" "+b);
	    				}
	    			}
	    			while(p[n-1][1]!=0){
	    				p[n-1][1]--;
	    				char b1 = (char)p[n-1][0];
	    				char b2 = (char)p[n-2][0];
	    				System.out.print(" "+b1+b2);
	    			}
	    			break;
	    		}
	    	}
	    	System.out.println("");
	    }
	}
}
