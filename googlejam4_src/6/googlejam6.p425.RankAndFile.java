package googlejam6.p425;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RankAndFile {
    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(new File("B-large.in"));
	int max = sc.nextInt();
	for (int kkkk = 0; kkkk < max; kkkk++) {
	    // int a = sc.nextInt();
	    int lineNumber = sc.nextInt();
	    sc.nextLine();
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    String[] line = new String[2 * lineNumber];
	    for (int i = 0; i < 2 * lineNumber - 1; i++) {
		String[] m = sc.nextLine().split(" ");
		for (String s : m) {
		    if (map.get(s) == null) {
			map.put(s, 1);
		    } else {
			if (map.get(s) == 0) {
			    map.put(s, 1);

			} else {
			    map.put(s, 0);

			}
		    }

		}
	    }
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    for (String key : map.keySet()) {
		if(map.get(key)==1 && key !=""){
		    
		    arr.add(Integer.parseInt(key));
		}
	    }
	    Collections.sort(arr);
	    StringBuilder sb = new StringBuilder();
	    sb.append("Case #" + (kkkk + 1) + ": ");
	    
	    for(Integer k:arr){
		sb.append(k+" ");
	    }
	    String str = sb.toString();
	    System.out.println(str.substring(0,str.length()-1));
	    

	    
	}

    }

}
