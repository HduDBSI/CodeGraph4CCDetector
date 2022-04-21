package googlejam6.p283;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;


public class Q2 {

	public static void main(String[] args) {
		try {
			String input="d:\\B-large.in";
		    String output="d:\\output.out";
		    
            Scanner sc = new Scanner(new FileReader(input));
            PrintWriter pw = new PrintWriter(output);
            
            int n = sc.nextInt();
            sc.nextLine();
            
            
            for (int c=0; c<n; c++) {
            	int len = sc.nextInt();
            	sc.nextLine();
                pw.print("Case #" + (c+1) + ": ");
                List<String> list = new ArrayList<>();
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int i = 0;i<2*len-1;i++){
					String z = sc.nextLine();
					String[] all = z.split(" ");
					for(String j : all){
						if(!j.isEmpty()){
							int x = Integer.parseInt(j);
							if(!map.containsKey(x)){
								map.put(x, 1);
							} else
								map.put(x, map.get(x)+1);
						}
					}
					
				}
				List<Integer> tosort = new ArrayList<>(len);
				for(int key : map.keySet()){
					if(map.get(key) % 2 == 1){
						tosort.add(key);
					}
				}
				Collections.sort(tosort);
				for(int key : tosort){
					pw.print(key + " ");
				}
				pw.println();
            }
            pw.println();
            pw.flush();
            pw.close();
            sc.close();
        } catch (FileNotFoundException ex) {
            
        }

	}
	

}
