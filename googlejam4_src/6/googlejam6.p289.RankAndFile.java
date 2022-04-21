package googlejam6.p289;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Cheng Chen
 * @since Apr 15, 2016
 */

public class RankAndFile {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int casetotal = 0;
		int casenumber = 1;
		int totalline = 0;
		String line = "";
		
		try (FileReader fr = new FileReader("data/B-large.in"); BufferedReader br = new BufferedReader(fr); FileWriter fw = new FileWriter("data/B-large.out"); PrintWriter bw = new PrintWriter(fw);) {
			while ((line = br.readLine()) != null) {
				if (totalline == 0) {
					casetotal = Integer.parseInt(line);
					totalline++;
					continue;
				}
				
				if (casenumber > casetotal) {
					System.out.println("###Error: The casenumber has problem!!!");
					System.out.println("###Error: This error happened in line number" + totalline);
					System.exit(0);
				}
				/**
				 * processing
				 */
				HashMap<Integer, Integer> count=new HashMap<Integer,Integer>();
				int N=Integer.parseInt(line);
				for(int i=0;i<2*N-1;i++){
					line = br.readLine();
					String[] arrS=line.split(" ",N);
					for(String s:arrS){
						int no=Integer.parseInt(s);
						if(count.get(no)!=null)
							count.put(no, count.get(no)+1);
						else
							count.put(no,1);
					}
					totalline++;
				}
				
				ArrayList<Integer> list=new ArrayList<Integer>();
				for(int key:count.keySet()){
					if(count.get(key)%2==1)
						list.add(key);
				}
				Collections.sort(list);
				
				bw.print("Case #"+casenumber+": ");
				for(int no:list){
					bw.print(no);
					bw.print(" ");
				}
				bw.println();
				
				casenumber++;
				totalline++;
			}
		}
		
	}
	
}
