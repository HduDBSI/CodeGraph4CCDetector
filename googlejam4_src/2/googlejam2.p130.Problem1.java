package googlejam2.p130;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Problem1 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileReader("A-small-attempt1.in"));
	        int T = scanner.nextInt();
	        long[] N = new long[T];
	        for(int i=0; i<T; i++) {
	        	N[i] = scanner.nextLong();
	        }  
	        PrintWriter out = new PrintWriter(new FileWriter("output2.txt"));    
	        for(int i=0; i<T; i++) {
	        	long target = N[i];
	        	HashMap<Long, Long> map = new HashMap<Long, Long>();
	        	LinkedList<Long> list = new LinkedList<Long>();
	        	list.add((long)1);
	        	map.put((long)1, (long)1);
	        	while(!map.containsKey(target)) {
	        		Long current = list.poll();
					long temp = current;
					long current1 = 0;
					while(temp > 0) {
						long digit = temp%10;
						temp = temp/10;
						current1 = current1 * 10 + digit;
					}
	        		Long next = current1;
	        		if(!map.containsKey(next) && next <= target) {
	        			list.add(next);
	        			map.put(next, map.get(current)+1);
	        		}
	        		if(!map.containsKey(current+1)) {
	        			list.add(current+1);
	        			map.put(current+1, map.get(current)+1);
	        		}
	        	}       	
	        	out.println("Case #" + (i+1) + ": " + map.get(target));
	        }	        
	        out.close();	       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
