package googlejam8.p675;
import java.io.*;
import java.util.*;

public class JamProblems {

    public static void main(String[] args) throws IOException {

        JamProblems r = new JamProblems();
		Scanner sc = null;
			PrintWriter pw = null;
			try {
				sc = new Scanner(new File("A-large.in"));
				pw = new PrintWriter(new File("output.out"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		    		
		    int tests = sc.nextInt();
		    for (int j = 1; j <= tests; j++) { 	  
		    	pw.print("Case #" + j + ": ");
			    int n = sc.nextInt();
			    int[] partEmp = new int[n];
			    Map<Integer, Integer> parties = new HashMap<Integer, Integer>();
			    String partNames = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			    int lastEmpl = 0;
			    for(int i = 0; i < n; i++) {
			    	partEmp[i] = sc.nextInt();
			    	parties.put(i, partEmp[i]);
			    	lastEmpl += partEmp[i];
			    }
			    //pw.print(partNames.charAt(0));
			    
			    while(true) {
			    	int fMaxInd = 0, sMaxInd = 0, maxEm = 0;
			    	for(int z = 0; z < n; z++) {
			    		if(partEmp[z] > maxEm) {
			    			maxEm = partEmp[z];
			    			fMaxInd = z;
			    		}
			    	}
			    	if(lastEmpl == 3) {
			    		pw.print(partNames.charAt(fMaxInd) + " ");
			    		partEmp[fMaxInd]--;
			    	} else {
			    		maxEm = 0;
			    		for(int z = 0; z < n; z++) {
		    	    		if(z != fMaxInd && partEmp[z] > maxEm) {
		    	    			maxEm = partEmp[z];
		    	    			sMaxInd = z;
		    	    		}
		    	    	}
			    		pw.print(partNames.charAt(fMaxInd) + "" + partNames.charAt(sMaxInd) + " ");
			    		partEmp[fMaxInd]--;
			    		partEmp[sMaxInd]--;
			    	}	
			    	lastEmpl = 0;
			    	for(int i = 0; i < n; i++) {
			    		lastEmpl += partEmp[i];
			    	}
			    	if(lastEmpl == 0) break;
			    }
			    pw.println();
		  } 
		
		  pw.close();
    }
    
}