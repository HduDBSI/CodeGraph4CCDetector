package googlejam6.p330;


import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {
	static Scanner scan;
	static PrintWriter writer;
	
	public static void main(String[] args) {
		File file = new File("D://B-large.in");
		File out = new File("D://outBL.txt");
		try {
			scan = new Scanner(file);
			writer = new PrintWriter(out);
			int t = scan.nextInt();
			for (int i = 1; i <= t; i++) {
				writer.print("Case #" + i + ": ");
				int n = scan.nextInt();
				Map<Integer, Integer>  map = new HashMap<Integer, Integer>();
				for(int j=0; j<2*n-1; j++) {
					for(int k=0; k<n; k++) {
						int a = scan.nextInt();
						Integer m = map.get(a);
						if(m == null) {
							m = 1;
						} else {
							m++;
						}
						
						map.put(a, m);
					} 
				}
				List<Integer> ret = new ArrayList<Integer>();
				for(int k : map.keySet()) {
					if(map.get(k) % 2 == 1) {
						ret.add(k);
					}
				}
				Collections.sort(ret);
				for(int j=0; j<ret.size(); j++) {
					writer.print(ret.get(j)+" ");
				}
				writer.println();
				// solve go here
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			scan.close();
			writer.close();
		}
	}
}
