package googlejam6.p230;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
        Scanner sc=new Scanner(System.in);
        String loopS = sc.nextLine();
        
        int loops = Integer.parseInt(loopS);
        for (int j=0; j<loops; j++) {
	        String N = sc.nextLine();
	        int nums = Integer.parseInt(N);
	        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        	List<Integer> soln = new ArrayList<Integer> ();
        	
	        for (int i=0; i < 2*nums-1; i++) {
	        	String line = sc.nextLine();
	        	String[] strArray = line.split(" ");
	        	for(int k = 0; k < strArray.length; k++) {
	        	    int key = Integer.parseInt(strArray[k]);
	        	    if (hm.containsKey(key)) {
	        	    	hm.put(key, hm.get(key)+1);
	        	    } else {
	        	    	hm.put(key,1);
	        	    }
	        	}	        	
	        }
	        
        	for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
//        		System.out.println(entry.getKey() + " " + entry.getValue());
        		if (entry.getValue()%2 != 0)
        		{
        			soln.add(entry.getKey());
        		}
        	}        	
        	Collections.sort(soln);
			int counter = j;	        
	        counter++;
			System.out.print("Case #"+ counter + ": ");
			for (int i = 0; i < soln.size()-1; i++) {
				System.out.print(soln.get(i) + " ");
			}
			System.out.println(soln.get(soln.size()-1));
        }
        sc.close();        

	}


}