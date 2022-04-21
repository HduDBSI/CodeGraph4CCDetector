package googlejam1.p451;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Problem1 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileReader("A-large.in"));
	        int T = scanner.nextInt();
	        int[] Ns = new int[T];
	        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	        for(int i=0; i<T; i++) {
	        	Ns[i] = scanner.nextInt(); 
	        	ArrayList<Integer> subList = new ArrayList<Integer>();
	        	for(int j=0; j< Ns[i]; j++) {
	        		int current = scanner.nextInt();
	        		subList.add(current);
	        	}
	        	list.add(subList);
	        }  
	        PrintWriter out = new PrintWriter(new FileWriter("output1.txt"));        
	        for(int i=0; i<T; i++) {
	        	if(Ns[i] <= 1) {
	        		out.println("Case #" + (i+1) + ": 0 0" );
	        		continue;
	        	}
	        	ArrayList<Integer> subList = list.get(i);
	        	int maxGap = 0;
	        	int sumGap = 0;
	        	int secondSum = 0;
	        	for(int j=0; j<subList.size()-1; j++) {
	        		if(subList.get(j) > subList.get(j+1)) {
	        			sumGap += subList.get(j) - subList.get(j+1);
	        			maxGap = Math.max(maxGap, subList.get(j) - subList.get(j+1));
	        		}
	        	}
	        	for(int j=0; j<subList.size()-1; j++) {
	        		if(subList.get(j) > maxGap) {
	        			secondSum += maxGap;
	        		} else {
	        			secondSum += subList.get(j);
	        		}
	        	}
	        	out.println("Case #" + (i+1) + ": " + sumGap + " " + secondSum);
	        }
	        out.close();	       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
