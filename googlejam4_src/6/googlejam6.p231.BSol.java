package googlejam6.p231;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class BSol {


	public static void main(String[] args) {
		
		Date d1 = new Date();
		//solveB("b.in", "b.out");
		try {
			
			FileWriter fw = new FileWriter("B-large.out");
			BufferedWriter bw = new BufferedWriter(fw);
			
			Scanner sc = new Scanner(new File("B-large.in"));
		
			long t = sc.nextLong();
			sc.nextLine();
			
			
			
			//System.out.println(t);
			for (long i2 = 0; i2 < t; i2++) {
				
				int n = sc.nextInt();
				sc.nextLine();
		
				int lines [][] = new int [2*n-1][n];
				
				for (int i = 0; i < 2*n-1; i++) {
					for (int j = 0; j < n; j++) {
						int a = sc.nextInt();
						lines[i][j] = a;
					}
					//sc.nextLine();
				}
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i = 0; i < lines.length; i++) {
					for (int j = 0; j < n; j++) {
						int h = lines[i][j];
						
						if (!map.containsKey(h)) {
							map.put(h, 1);
						} else {
							map.put(h, map.get(h)+1);
						}
						//System.out.print(lines[i][j] + " ");
					}
					//System.out.println();
				}
				
				
				//System.out.println("missing heights: ");
				Set<Entry<Integer, Integer>> entrySet = map.entrySet();
				ArrayList<Integer> m = new ArrayList<Integer>();
				for (Entry<Integer, Integer> entry : entrySet) {
					if (entry.getValue() % 2 == 1) {
						//System.out.println(entry.getKey()  + " " + entry.getValue());
						m.add(entry.getKey());
					}
				}
				Collections.sort(m);
				
				String result = "";
				if (m.size() == n) {
					//System.out.println(m);
					for (int i = 0; i < m.size(); i++) {
						result += m.get(i);
						if (i != m.size()-1) {
							result += " ";
						}
					}
				} else {
					result = null;
					System.out.println("Error ");
				}
				
				String rez =  result;
				//System.out.println("result: " + rez);
				bw.write("Case #" + (i2+1) + ": " +  rez + "\n");
				
			}
			
			
			bw.flush();
			bw.close();
			fw.close();
			sc.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} finally {
			
		}		
		//solveB("B-small-attempt0.in", "B-small-attempt0.out");
		
		Date d2 = new Date();
		//System.out.println("time: " + (d2.getTime() - d1.getTime()));
		
		
		
		


	}








	








}
