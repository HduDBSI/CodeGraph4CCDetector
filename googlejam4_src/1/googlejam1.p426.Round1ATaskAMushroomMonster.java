package googlejam1.p426;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Round1ATaskAMushroomMonster {

	
	public static void main(String args[] ) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("input2.in"));
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("output2.out")));
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //PrintWriter w = new PrintWriter(System.out);
	        
	    int T = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=T;t++) {
	    	StringTokenizer st1 = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st1.nextToken());
	    	
	    	StringTokenizer st2 = new StringTokenizer(br.readLine());
	    	int m[] = new int[n];
	    	for(int i=0;i<n;i++)
	    		m[i] = Integer.parseInt(st2.nextToken());
	    	
	    	int y = 0;
	    	for(int i=1;i<n;i++)
	    		y += Math.max(0, m[i-1] - m[i]);
	    	
	    	int z = 0;
	    	int rateMax = 0;
	    	for(int i=1;i<n;i++){
	    		if(m[i] < m[i-1])
	    			rateMax = Math.max(rateMax,m[i-1] - m[i]);
	    	}
	    	
	    	for(int i=0;i<n-1;i++)
	    		z += Math.min(rateMax, m[i]);
	    	
	        w.println("Case #" + t + ": " + y + " " + z);
	    }
	        
	    w.close();
	        
	}
}
