package googlejam6.p590;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Problem2 {

	public static final String fileName="./round1a/"+"B-large.in";
	
	public static void main(String[] args) {
		ArrayList<String> values = new ArrayList<String>();;
		try {
		FileInputStream fis = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		FileWriter fw = new FileWriter(fileName+".out");
		BufferedWriter bw = new BufferedWriter(fw);
		int count = Integer.parseInt(br.readLine());
		for(int i=0;i<count;i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer,Integer> heights = new HashMap<Integer,Integer> ();
			for(int j=0;j<2*n-1;j++) {
				String line = br.readLine();
				String[] hvalues=line.split(" ");
				for(int k=0;k<hvalues.length;k++) {
					int val = Integer.parseInt(hvalues[k]);
					if(heights.containsKey(val))
						heights.remove(val);
					else
						heights.put(val, 1);
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>(heights.keySet());
			Collections.sort(list);
			bw.write("Case #"+(i+1)+": "+list.toString().replace("[", "").replace("]", "").replace(",", "")+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
